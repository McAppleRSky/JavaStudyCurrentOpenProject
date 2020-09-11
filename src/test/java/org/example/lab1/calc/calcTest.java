package org.example.lab1.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class calcTest {

    @Test
    public void testIntArg() {
        Calc calc = new Calc();
        assertTrue(calc.getChar4SnapsotAndSaveToInts(0, "0") == 'i');
        assertTrue(calc.getIntValuesCount() == 1);
        assertTrue(calc.getIntValueForIndex(0) == 0);
    }

    @Test
    public void testNotIntArg() {
        Calc calc = new Calc();
        assertTrue(calc.getChar4SnapsotAndSaveToInts(0, "+") != 'i');
        assertTrue(calc.getIntValuesCount() == 1);
        assertEquals(calc.getIntValueForIndex(0), '+');
    }

    @Test
    public void testPlusArg() {
        Calc calc = new Calc();
        assertTrue(calc.getChar4SnapsotAndSaveToInts(0, "+") == 'o');
        assertTrue(calc.getIntValuesCount() == 1);
        assertEquals(calc.getIntValueForIndex(0), '+');
    }

    @Test
    public void tstMinusArg() {
        Calc calc = new Calc();
        assertTrue(calc.getChar4SnapsotAndSaveToInts(0, "-") == 'o');
        assertTrue(calc.getIntValuesCount() == 1);
        assertEquals(calc.getIntValueForIndex(0), '-');
    }
    @Test
    public void testMultArg() {
        Calc calc = new Calc();
        assertTrue(calc.getChar4SnapsotAndSaveToInts(0, "*") == 'o');
        assertTrue(calc.getIntValuesCount() == 1);
        assertEquals(calc.getIntValueForIndex(0), '*');
    }
    @Test
    public void testAMultArg() {
        Calc calc = new Calc();
        assertTrue(calc.getChar4SnapsotAndSaveToInts(0, "/") == 'o');
        assertTrue(calc.getIntValuesCount() == 1);
        assertEquals(calc.getIntValueForIndex(0), '/');
    }
    @Test
    public void tstNOperArg() {
        Calc calc = new Calc();
        assertTrue(calc.getChar4SnapsotAndSaveToInts(0, "%%%") == 'n');
        assertTrue(calc.getIntValuesCount() == 0);
    }
    @Test
    public void testExpression() throws Exception {
        String[] expression = {"1","+","1"};
        Calc calc = new Calc();
        calc.tstArgsCount(expression);
        assertEquals(calc.getSnapshotExpression(expression),"ioi");
    }
}
