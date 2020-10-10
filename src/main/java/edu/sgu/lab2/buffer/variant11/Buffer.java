package edu.sgu.lab2.buffer.variant11;

import edu.sgu.lab2.buffer.comps.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Buffer extends CBuffer implements //NBufCount3, LSize90,
        IBufferComputable, IBufferComputMax, IBufferPrintable,
        IBufferSortable, IBufferSortBubble,
        IBufferStorable, IBufferStore1 {

    private Long[] buffer, result = new Long[2];

    public Buffer(int count) {
        super(count);
        generate(count);
    }
    @Override
    public void generate(int count) {
        buffer = new Long[count];
        Random random = new Random();
        for(int i=0;i<count;i++)
            buffer[i]=random.nextLong();
    }
    @Override
    public void close() {
        buffer = null;
        bufSize = 0;
        bufCount--;
    }

    public Long getLast (){
        if( (buffer.length==0)||(buffer.length!=bufSize))  throw new NullPointerException("Buffer is pull for value");
        return buffer[bufSize-1];
    }
    public int getLastN (){
        if( (buffer.length==0)||(buffer.length!=bufSize))  throw new NullPointerException("Buffer is pull for number");
        return buffer.length-1;
    }
    @Override
    public void printInfo() {
        System.out.println("Buffer ID: "+bufID+", buffer type: "+buffer[0].getClass()+", buffer size: "+bufSize);
        System.out.println("Total buffers: "+getBufCount());
    }

    @Override
    public void print() {
        System.out.println("Full count buffer ("+buffer[0].getClass().toString().substring(16)+"):");
        printFirstN(buffer.length);
    }

    @Override
    public void printFirstN(int n) {
        StringBuffer resultStrng = new StringBuffer();
        for(int i=0;i<n;i++)
            if(i==0) resultStrng.append(buffer[i]);
            else
                resultStrng
                        .append(", ")
                        .append(buffer[i]);
        System.out.println("Count "+n+": "+resultStrng.toString());
    }

    @Override
    public String getSortAlgorithmName() {
        return algorithmName;
    }
    @Override
    public String getComputMethod() {
        return computMethod;
    }
    @Override
    public String getStoreMethod() {
        return storeMethod;
    }

    @Override
    public void sort() {
        int count = buffer.length;
        if(count>1) {
            switch (algorithmName){
                case "bubble":
                    bubble(count);
                    break;
                case "quick":
                    quick(0, count-1);
                    break;
                case "select":
                    select(count);
                    break;
                case "shell":
                    shell(count);
                    break;
                default:
                    throw new NullPointerException("Nothing to sort");
            }
            System.out.println("Sorting algorithm: "+algorithmName);
        } else throw new NullPointerException("Nothing sort");
    }
    private void bubble(int count){
        for(int a=1;a<count;++a)
            for(int b=count-1;b>=a;--b)
                if (buffer[b-1]>buffer[b]){
                    result[0] = buffer[b-1];
                    buffer[b-1] = buffer[b];
                    buffer[b] = result[0];
                }
    }
    private void quick(int left, int right){
        int i=left, j=right;
        result[0]=buffer[(left+right)/2]; // выбор компаранда
        do{
            while ( (buffer[i]<result[0])&&(i<right) ) i++;
            while ( (result[0]<buffer[j])&&(j>left) ) j--;
            if(i<=j){
                result[1]=buffer[i];
                buffer[i]=buffer[j];
                buffer[j]=result[1];
                i++;
                j--;
            }
        }while (i<=j);
        if (left<j) quick(left, j);
        if (i<right) quick(i, right);
    }
    private void select(int count){
        int b, c;
        boolean exchange;
        for(int a=0;a<count-1;++a){
            exchange=false;
            c=a;
            result[0] = buffer[a];
            for(b=a+1;b<count;b++)
                if(buffer[b]<result[0]){
                    c=b;
                    result[0]=buffer[b];
                    exchange=true;
                }
            if(exchange){
                buffer[c]=buffer[a];
                buffer[a]=result[0];
            }
        }
    }
    private void shell(int count){
        int[] gaps = //{9,5,3,2,1}
                {23,10,4,1};
        for(int gap:gaps){
            for(int i=gap;i<count;i++){
                result[0]=buffer[i];
                int j=i-gap;
                for(;j>=0 && result[0]<buffer[j];j-=gap)
                    buffer[j+gap]=buffer[j];
                buffer[j+gap]=result[0];
            }
        }
    }


    @Override
    public void comput() {
        if(buffer.length<2)
            System.out.println("Too small buffer fo compute");
        else {
            switch (computMethod){
                case "max":
                    max();
                    break;
                case "min":
                    min();
                    break;
                case "sum":
                    sum();
                    break;
                default:
                    throw new NullPointerException("No saver");
            }
            System.out.println(computMethod+": "+result[0]);
        }
    }
    private void min() {
        result[0] = Long.MAX_VALUE;
        for (int i=0;i<buffer.length;i++)
            if (buffer[i]<result[0]) result[0]=buffer[i];
    }
    private void max() {
        result[0] = Long.MIN_VALUE;
        for (int i=0;i<buffer.length;i++)
            if (buffer[i]>result[0]) result[0]=buffer[i];
    }
    private void sum() {
        result[0] = result[0] = Long.valueOf(0);
        for (int i=0;i<buffer.length;i++) result[0]+=buffer[i];
    }

    @Override
    public void store(String filename) {
        if( filename.isEmpty()||buffer.length<2) {
            System.out.println("No file or buffer");
        } else
            try {
                switch (storeMethod){
                    case "oneLine":
                        saveOneLine(path+"/"+filename);
                        break;
                    case "separateLines":
                        saveSeparateLines(path+"/"+filename);
                        break;
                    default:
                        throw new NullPointerException("No saver");
                }
            } catch (FileNotFoundException |NullPointerException e) {
                e.printStackTrace();
            }
    }
    private void saveOneLine(String filename) throws FileNotFoundException {
        StringBuilder resultString = new StringBuilder();
        PrintWriter out = new PrintWriter(filename);
        for(int i=0;i<buffer.length;i++) {
            if(i>0)
                resultString
                        .append((char)0x09);
            resultString.append(buffer[i]);
        }
        out.println(resultString);
        out.close();
    }
    private void saveSeparateLines(String filename) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);
        for(int i=0;i<buffer.length;i++)
            out.println(buffer[i].toString());
        out.close();
    }

}
