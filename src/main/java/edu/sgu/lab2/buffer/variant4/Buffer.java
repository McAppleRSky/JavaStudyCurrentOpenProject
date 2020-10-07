package edu.sgu.lab2.buffer.variant4;

import edu.sgu.lab2.buffer.comps.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Buffer extends CBuffer implements NBufCount6, LSize80,
        IBufferComputable, IBufferComputMin, IBufferPrintable,
        IBufferSortable, IBufferSortQuick,
        IBufferStorable, IBufferStore2 {

    private Double[] buffer, result = new Double[2];

    public Buffer(int count) {
        super(count);
        bufSize = size;
        if (count<=bufSize) generate(count);
        else bufCount--;
    }
    @Override
    public void close() {
        buffer = null;
        bufSize = 0;
        bufCount--;
    }
    @Override
    public void generate(int count) {
        buffer = new Double[count];
        Random random = new Random();
        for(int i=0;i<count;i++){
            buffer[i]=random.nextDouble();
        }
    }

    @Override
    public void printInfo() {
        System.out.println("Buffer ID: "+bufID+", buffer type: "+buffer[0].getClass()+", buffer size: "+bufSize);
    }

    @Override
    public void print() {
        StringBuffer resultStrng = new StringBuffer();
        for(int i=0;i<buffer.length;i++)
            resultStrng.append(buffer[i]);
        System.out.println(resultStrng.toString());
    }

    @Override
    public void printFirstN(int n) {
        StringBuffer resultStrng = new StringBuffer();
        if(n<buffer.length) {
            for(int i=0;i<n;i++)
                resultStrng.append(buffer[i]);
        } else resultStrng.append("Insufficient items");
        System.out.println(resultStrng.toString());
    }

    @Override
    public void sort() {
        int count = buffer.length;
        if(count>1) {
            switch (algorithmName){
                case "Bubble":
                    bubble(count);
                    break;
                case "Quick":
                    quick(0, count-1);
                    break;
                case "Select":
                    select(count);
                    break;
                case "Shell":
                    shell(count);
                    break;
                default:
                    throw new NullPointerException("Nothing to sort");
            }
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
        int i, j, gap, k;
        int[] arr = {9,5,3,2,1};
        for(k=0;k<5;k++){
            gap=arr[k];
            for(i=gap;i<count;++i){
                result[0]=buffer[i];
                for(j=i-gap;(result[0]<buffer[j])&&(j>=0);j=j-gap)
                    buffer[j+gap]=buffer[j];
                buffer[j+gap]=result[0];
            }
        }
    }

    @Override
    public void comput() {
        if(buffer.length<2) {
            System.out.println("Too small buffer fo compute");
        } else
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
    }

    private void min() {
        result[0] = Double.MAX_VALUE;
        for (int i=0;i<buffer.length;i++)
            if (buffer[i]<result[0]) result[0]=buffer[i];
    }

    private void max() {
        result[0] = Double.MIN_VALUE;
        for (int i=0;i>buffer.length;i++)
            if (buffer[i]<result[0]) result[0]=buffer[i];
    }

    private void sum() {
        for (int i=0;i>buffer.length;i++) result[0]+=buffer[i];
    }

    @Override
    public void store(String filename) {
        if( filename.isEmpty()||buffer.length<2) {
            System.out.println("No file or buffer");
        } else
            try {
                switch (storeMethod){
                    case "oneLine":
                        saveOneLine(filename);
                        break;
                    case "separateLines":
                        saveSeparateLines(filename);
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
        for(int i=1;i<buffer.length;i++)
            resultString.append(buffer[i]);
        out.println(resultString);
        out.close();
    }
    private void saveSeparateLines(String filename) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);
        for(int i=1;i<buffer.length;i++)
            out.println(buffer[i].toString());
        out.close();
    }
}
