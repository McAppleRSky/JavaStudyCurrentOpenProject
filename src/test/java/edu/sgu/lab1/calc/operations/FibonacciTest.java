package edu.sgu.lab1.calc.operations;

import org.junit.Test;

//import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void testIsFibonacci0() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(fibonacci.getResult(0, 0)[0], fibonacci.unSolveMsg);
        assertEquals(fibonacci.getResult(-1, 0)[0], fibonacci.unSolveMsg);
    }
    @Test
    public void testIsFibonacci1() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(2, fibonacci.fibonacciSumm(1,1,1));
    }
    @Test
    public void testIsFibonacci2() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(3, fibonacci.fibonacciSumm(1,1,2));
    }
    @Test
    public void testIsFibonacci3() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(5, fibonacci.fibonacciSumm(1,1,3));
    }
    @Test
    public void testIsFibonacci9() {
        Fibonacci fibonacci = new Fibonacci();
        assertEquals(89, fibonacci.fibonacciSumm(1,1,9));
    }
    @Test
    public void testIsFibonacciMax() {
        Fibonacci fibonacci = new Fibonacci();
        assertTrue(fibonacci.fibonacciSumm(1,1,44)>0);
        assertEquals(1836311903, fibonacci.fibonacciSumm(1,1,44));
    }
    @Test
    public void testIsFibonacciOver() {
        Fibonacci fibonacci = new Fibonacci();
        assertTrue(fibonacci.fibonacciSumm(1,1,45)<0);
        assertEquals(-1323752223, fibonacci.fibonacciSumm(1,1,45));
    }

}
