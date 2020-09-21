package edu.sgu.lab1.calc;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void testConstructor() {
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("edu.sgu.lab1.calc.operations", calc.prefixPackage);
        assertEquals(4, calc.method.size());
        assertEquals(4, calc.listSymbolsMnemonics.size());
        assertEquals(4, calc.listMnemonicsOperations.size());
    }
    @Test
    public void testSymbolOperation() {
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertTrue(calc.isOperation('+'));
        assertTrue(calc.isOperation('-'));
        assertTrue(calc.isOperation('*'));
        assertTrue(calc.isOperation('/'));
        assertFalse(calc.isOperation('~'));
    }
    @Test
    public void testMnemonic() {
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            assertTrue((Integer)calc.genMnemonicInvoker('+')>Integer.valueOf(0));
            assertEquals(Integer.valueOf(43), (Integer)calc.genMnemonicInvoker('+'));
            assertEquals(Integer.valueOf(45), (Integer)calc.genMnemonicInvoker('-'));
            assertEquals(Integer.valueOf(42), (Integer)calc.genMnemonicInvoker('*'));
            assertEquals(Integer.valueOf(47), (Integer)calc.genMnemonicInvoker('/'));
            assertEquals(Integer.valueOf(126), (Integer)calc.genMnemonicInvoker('~'));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testMnemonicValue() {
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(0, "0") == 'i');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(1, "999") == 'i');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(2, "+") == 'o');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(3, "-") == 'o');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(4, "/") == 'o');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(5, "*") == 'o');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(6, "**") == 'o');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(7, "_") != 'o');
            assertTrue(calc.getSymbolol_saveToMnemonicsValues(7, "~") == 'n');
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testExpression() throws Exception {
        String[] args = {"1","/","1"};
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(calc.getActualSymbolExpression(args),"ioi");
    }
    @Test
    public void testNotExpression() throws Exception {
        String[] args = {"/","0","_"};
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(calc.getActualSymbolExpression(args),"oin");
    }
    @Test
    public void testSimpleDiv() throws Exception {
        String[] args = {"1","/","1"};
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("1", calc.solve(args));
    }
    @Test
    public void testMinus() throws Exception {
        String[] args = {"1","-","1"};
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("0", calc.solve(args));
    }
    @Test
    public void testPlus() throws Exception {
        String[] args = {"1","+","1"};
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("2", calc.solve(args));
    }
    @Test
    public void testMult() throws Exception {
        String[] args = {"1","*","1"};
        Calc calc = null;
        try {
            calc = new Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("1", calc.solve(args));
    }
}
