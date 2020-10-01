package edu.sgu.lab1.calc.operations;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class FibonacciTest {

    @Test
    public void testIsFibonacciMax() {
        Fibonacci fibonacci = new Fibonacci();
        assertFalse(fibonacci.isFibonacci(Integer.MAX_VALUE, 0));
    }
    @Test
    public void testIsFibonacci0() {
        Fibonacci fibonacci = new Fibonacci();
        assertFalse(fibonacci.isFibonacci(1, 0));
    }
    @Test
    public void testIsFibonacci1() {
        Fibonacci fibonacci = new Fibonacci();
        assertTrue (fibonacci.isFibonacci(1, 1));
    }
    @Test
    public void testIsFibonacci3() {
        Fibonacci fibonacci = new Fibonacci();
        assertTrue (fibonacci.isFibonacci(1, 3));
    }
    @Test
    public void testIsFibonacci4() {
        Fibonacci fibonacci = new Fibonacci();
        assertFalse(fibonacci.isFibonacci(1,4));
    }
    @Test
    public void testIsFibonacci5() {
        Fibonacci fibonacci = new Fibonacci();
        assertTrue (fibonacci.isFibonacci(1,5));
    }
    @Test
    public void testIsFibonacci8() {
        Fibonacci fibonacci = new Fibonacci();
        assertTrue (fibonacci.isFibonacci(1,8));
    }
    @Test
    public void testIsFibonacci17711() {
        Fibonacci fibonacci = new Fibonacci();
        assertTrue (fibonacci.isFibonacci(1,17711));
    }
}
