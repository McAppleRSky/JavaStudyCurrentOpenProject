package edu.sgu.lab1.calc;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void testConstructor() {
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("edu.sgu.lab1.calc.operations", calc.prefixPackage);
        assertEquals(4, calc.method.size());
        assertEquals(13, calc.listSymbolsMnemonics.size());
        assertEquals(13, calc.listMnemonicsOperations.size());
    }
    @Test
    public void testSymbolOperation() {
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
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
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
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
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
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
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
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
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(calc.getActualSymbolExpression(args),"oin");
    }
    @Test
    public void testFullDiv() throws Exception {
        String[] args = {"20","/","4"};
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("5", calc.solve(args).substring(0,1));
    }
    @Test
    public void testPartDiv() throws Exception {
        String[] args = {"14","/","3"};
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("4", calc.solve(args).substring(7, 8));
        assertEquals("2", calc.solve(args).substring(19));
    }
    @Test
    public void testMinus() throws Exception {
        String[] args = {"1","-","1"};
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
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
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
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
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("1", calc.solve(args));
    }
    @Test
    public void testDegree() throws Exception {
        String[] args = new String[1];
        args[0] = "3 ^ 3";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("27", calc.solve(args[0].split(" ")));
    }
    @Test
    public void testPerimeterT() throws Exception {
        String[] args = new String[1];
        args[0] = "S 13 5";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("32", calc.solve(args[0].split(" ")));
    }
    @Test
    public void testAreaT() throws Exception {
        String[] args = new String[1];
        args[0] = "P 13 5";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("31", calc.solve(args[0].split(" ")));
    }

    @Test
    public void testOneOperand() throws Exception {
//        String[] args = new String[1];
        String arg = "F 1";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("oi ", calc.getActualSymbolExpression(arg.split(" ")));
    }
    @Test
    public void testFibonacci() throws Exception {
        String[] args = new String[1];
        args[0] = "F 10";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("144", calc.solve(args[0].split(" ")).substring(30, 33));
    }
    @Test
    public void testNodFull() throws Exception {
        String[] args = {"N","20","4"};
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("4", calc.solve(args));
    }
    @Test
    public void testNodPart() throws Exception {
        String[] args = {"N","12","18"};
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("6", calc.solve(args));
    }
    @Test
    public void testRound() throws Exception {
        String[] args = new String[1];
        args[0] = "C 13";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("81,7", calc.solve(args[0].split(" ")));
    }
    @Test
    public void testAreaRound() throws Exception {
        String[] args = new String[1];
        args[0] = "R 13";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("530,93", calc.solve(args[0].split(" ")));
    }
    @Test
    public void testPerimeter() throws Exception {
        String[] args = new String[1];
        args[0] = "p 2 2";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("8", calc.solve(args[0].split(" ")));
    }
    @Test
    public void testArea() throws Exception {
        String[] args = new String[1];
        args[0] = "q 2 2";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("4", calc.solve(args[0].split(" ")));
    }

}
