package edu.sgu.lab2.buffer;

//import edu.sgu.lab2.buffer.variant1.Buffer;
import edu.sgu.lab2.buffer.*;
import org.junit.Ignore;
import org.junit.Test;

//import java.nio.Buffer;

import static org.junit.Assert.*;

public class BufferTest {

    @Test
    public void testVariant1() {
        edu.sgu.lab2.buffer.variant1.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant1.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant2() {
        edu.sgu.lab2.buffer.variant2.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant2.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant3() {
        edu.sgu.lab2.buffer.variant3.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant3.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant4() {
        edu.sgu.lab2.buffer.variant4.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant4.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant5() {
        edu.sgu.lab2.buffer.variant5.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant5.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant6() {
        edu.sgu.lab2.buffer.variant6.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant6.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant7() {
        edu.sgu.lab2.buffer.variant7.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant7.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant8() {
        edu.sgu.lab2.buffer.variant8.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant8.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant9() {
        edu.sgu.lab2.buffer.variant9.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant9.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant10() {
        edu.sgu.lab2.buffer.variant10.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant10.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant11() {
        edu.sgu.lab2.buffer.variant11.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant11.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant12() {
        edu.sgu.lab2.buffer.variant12.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant12.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant13() {
        edu.sgu.lab2.buffer.variant13.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant13.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant14() {
        edu.sgu.lab2.buffer.variant14.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant14.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }
    @Test
    public void testVariant15() {
        edu.sgu.lab2.buffer.variant15.Buffer buffer;
        buffer = new edu.sgu.lab2.buffer.variant15.Buffer(11);
        assertEquals(1, buffer.getBufCount());
        assertEquals(1, buffer.getBufID());
        buffer.close();
        buffer=null;
    }

}