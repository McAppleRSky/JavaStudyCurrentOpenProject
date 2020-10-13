package edu.sgu.lab2.buffer;

import edu.sgu.lab2.buffer.variant1.Buffer;

public class Cli {

    private static String sep = System.getProperty("line.separator");
    private static int len = sep.length(),
            count=3, size=50;
    private static Buffer[] buffer = new Buffer[count];

    public static void main(String[] args) {
        for (int i = 0; i < count; i++) buffer[i] = new Buffer(size);
        String name;
        int bufcount = 0;
        for (Buffer buf : buffer) {
            System.out.println("Current buffer: " + buf.getBufID());
            System.out.println("Buffer size: " + buf.getLastN()+1);
            System.out.println("Buffer type: " + buf.getLast().getClass().toString().substring(16));
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            name = "buf-n" + ++bufcount;
            buf.store(name);
        }
    }
}
