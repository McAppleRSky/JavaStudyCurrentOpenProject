package org.example.lab1.currentExamples;

import java.io.*;
import java.util.Scanner;

public class CurrentOpen {

    public static void main(String[] args) {
        for(int i=0;i<args.length;i++)
            System.out.println("args[" + i + "]:" + args[i]);
    }

    Object crashMethod(){
        Object result = null;
        if (result == null)
            throw new NullPointerException("return = null");
        return (result);
    }

    void testCrashMethod(){
        Object tstObject;
        try {
            tstObject = crashMethod();
        }catch (Exception exception){
            System.err.println("An exception was thrown");
            throw exception;
        }
    }

    void binReader(){
        FileInputStream in = null;
        FileOutputStream out = null;
        int c;
        try {
            in = new FileInputStream("a.txt");
            out = new FileOutputStream("b.txt");
            while ((c = in.read()) != -1) { out.write(c); }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (in != null) { in.close(); }
            if (out != null) { out.close(); }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void buffReader(){
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader("a.txt"));
            out = new PrintWriter(new FileWriter("b.txt"));
            String l;
            while ((l = in.readLine()) != null) {
                out.println(l);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    void scanReader(){

        File file = new File("testfile.txt");
        try {
// Объявляем класс Scanner, инициализируем его с параметром file
// Создаем цикл, который будет считывать строки, пока не дойдем до конца файла.
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                if (scanner.hasNextInt()) {
                    int i = scanner.nextInt();
                    System.out.println("Тип Integer: " + i);
                } else if (scanner.hasNextDouble()) {
                    double d = scanner.nextDouble();
                    System.out.println("Тип double: " + d);
                } else if (scanner.hasNextBoolean()) {
                    Boolean b = scanner.nextBoolean();
                    System.out.println("Тип boolean: " + b);
                } else {
                    System.out.println("String: " + scanner.next());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
