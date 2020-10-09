package edu.sgu.lab2.buffer;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;

public class BufferTest {

    String[][] expected = new String[][]{
/* 1*/  {"3", "Integer", "50", "bubble", "min", "oneLine"},
/* 2*/  {"4", "Long", "60", "select", "max", "separateLines"},
/* 3*/  {"5", "Float", "70", "shell", "sum", "oneLine"},
/* 4*/  {"6", "Double", "80", "quick", "min", "separateLines"},
/* 5*/  {"7", "Long", "90", "bubble", "max", "oneLine"},
/* 6*/  {"3", "Float", "80", "select", "sum", "separateLines"},
/* 7*/  {"4", "Double", "70", "shell", "min", "oneLine"},
/* 8*/  {"5", "Integer", "60", "quick", "max", "separateLines"},
/* 9*/  {"6", "Float", "50", "bubble", "sum", "oneLine"},
/*10*/  {"7", "Double", "40", "select", "min", "separateLines"},
/*11*/  {"3", "Long", "90", "bubble", "max", "oneLine"},
/*12*/  {"4", "Integer", "70", "select", "sum", "separateLines"},
/*13*/  {"5", "Double", "50", "shell", "min", "oneLine"},
/*14*/  {"6", "Long", "30", "quick", "max", "separateLines"},
/*15*/  {"7", "Integer", "60", "bubble", "sum", "oneLine"}
    };

    @Test
    public void testVariant1() {
        int var = 1, count=3, size=50;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant1.Buffer[] buffer = new
                edu.sgu.lab2.buffer.variant1.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant1.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant1.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant1.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant2() {
        int var = 2, count=4, size=60;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant2.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant2.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant2.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant2.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant2.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant3() {
        int var = 3, count=5, size=70;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant3.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant3.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant3.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant3.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant3.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant4() {
        int var = 4, count=6, size=80;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant4.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant4.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant4.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant4.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant4.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant5() {
        int var = 5, count=7, size=90;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant5.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant5.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant5.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant5.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant5.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant6() {
        int var = 6, count=3, size=80;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant6.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant6.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant6.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant6.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant6.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant7() {
        int var = 7, count=4, size=70;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant7.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant7.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant7.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant7.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant7.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant8() {
        int var = 8, count=5, size=60;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant8.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant8.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant8.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant8.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant8.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant9() {
        int var = 9, count=6, size=50;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant9.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant9.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant9.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant9.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant9.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant10() {
        int var = 10, count=7, size=40;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant10.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant10.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant10.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant10.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant10.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant11() {
        int var = 11, count=3, size=90;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant11.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant11.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant11.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant11.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant11.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant12() {
        int var = 12, count=4, size=70;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant12.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant12.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant12.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant12.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant12.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant13() {
        int var = 13, count=5, size=50;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant13.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant13.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant13.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant13.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant13.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant14() {
        int var = 14, count=6, size=30;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant14.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant14.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant14.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant14.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant14.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }
    @Test
    public void testVariant15() {
        int var = 15, count=7, size=60;
        System.out.println("Variant: "+var);
        edu.sgu.lab2.buffer.variant15.Buffer[] buffer
                = new edu.sgu.lab2.buffer.variant15.Buffer[count];
        for(int i=0;i<count;i++) {
            buffer[i] = new edu.sgu.lab2.buffer.variant15.Buffer(size);
            assertEquals(i+1,buffer[i].getBufID());
        }
        int i=0; String n;
        for(edu.sgu.lab2.buffer.variant15.Buffer buf:buffer){
            assertArrayEquals(expected[var-1], new String[]{
                    Integer.toString(buf.getBufCount()),
                    buf.getLast().getClass().toString().substring(16),
                    Integer.toString(buf.getLastN()+1),
                    buf.getSortAlgorithmName(),
                    buf.getComputMethod(),
                    buf.getStoreMethod()});
            buf.print();
            buf.printFirstN(10);
            buf.comput();
            buf.sort();
            buf.printFirstN(10);
            if(i<9)n="0";
            else n="";
            buf.store("buf-v"+var+"+N"+n+i++);
        }
        for(edu.sgu.lab2.buffer.variant15.Buffer buf:buffer)
            buf.close();
        buffer=null;
    }

}
