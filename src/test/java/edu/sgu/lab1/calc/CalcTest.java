package edu.sgu.lab1.calc;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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
        assertEquals(20, calc.listSymbolsMnemonics.size());
        assertEquals(20, calc.listMnemonicsOperations.size());
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
        assertEquals("5", calc.solve(args)[0].substring(0,1));
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
        assertEquals("4", calc.solve(args)[0].substring(7, 8));
        assertEquals("2", calc.solve(args)[0].substring(19));
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
        assertEquals("0", calc.solve(args)[0]);
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
        assertEquals("2", calc.solve(args)[0]);
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
        assertEquals("1", calc.solve(args)[0]);
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
        assertEquals("27", calc.solve(args[0].split(" "))[0]);
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
        assertEquals("32", calc.solve(args[0].split(" "))[0]);
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
        assertEquals("31", calc.solve(args[0].split(" "))[0]);
    }

    @Test
    public void testOneOperand() throws Exception {
        String arg = "F 1";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("oi", calc.getActualSymbolExpression(arg.split(" ")));
    }
    @Test
    public void testThreeOperand() throws Exception {
        String arg = "Q 0 0 0";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("oiii", calc.getActualSymbolExpression(arg.split(" ")));
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
        assertEquals("144", calc.solve(args[0].split(" "))[0].substring(30, 33));
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
        assertEquals("4", calc.solve(args)[0]);
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
        assertEquals("6", calc.solve(args)[0]);
    }
    @Test
    public void testRound() throws Exception {
        String[] args = new String[1];
        args[0] = "C 13";
        StringBuilder expectedValue = new StringBuilder("81,7");
        DecimalFormat format = new DecimalFormat();
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        expectedValue.setCharAt(2,  symbols.getDecimalSeparator());
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expectedValue.toString(), calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testAreaRound() throws Exception {
        String[] args = new String[1];
        args[0] = "R 13";
        StringBuilder expectedValue = new StringBuilder("530,93");
        DecimalFormat format = new DecimalFormat();
        DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
        expectedValue.setCharAt(3,  symbols.getDecimalSeparator());
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expectedValue.toString(), calc.solve(args[0].split(" "))[0]);
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
        assertEquals("8", calc.solve(args[0].split(" "))[0]);
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
        assertEquals("4", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testCelsius() throws Exception {
        String[] args = new String[1];
        args[0] = "c 800";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("426", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testFahrenheitTree() throws Exception {
        String[] args = new String[1];
        args[0] = "f 426";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("798", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testFahrenheit0() throws Exception {
        String[] args = new String[1];
        args[0] = "f 0";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("32", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testFahrenheit100() throws Exception {
        String[] args = new String[1];
        args[0] = "f 100";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("212", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testLinear() throws Exception {
        String[] args = new String[1];
        args[0] = "L 3 -24";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("8", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testDivsSimple() throws Exception {
        String[] args = new String[1];
        args[0] = "d 1";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("1", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testDivs() throws Exception {
        String[] args = new String[1];
        args[0] = "d 4";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("4, 2, 1", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testDivsBig() throws Exception {
        String[] args = new String[1];
        args[0] = "d 65536";
        String expectedValue = "65536, 32768, 16384, 8192, 4096, 2048, 1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(expectedValue, calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testQuadraticOne() throws Exception {
        String[] args = new String[1];
        args[0] = "Q 1 -6 9";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("3.0", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testQuadraticTwo() throws Exception {
        String[] args = new String[1];
        args[0] = "Q 1 -8 12";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("6.0, 2.0", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testQuadraticEmpty() throws Exception {
        String[] args = new String[1];
        args[0] = "Q 5 3 7";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("no roots", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testDegreeD1() throws Exception {
        String[] args = new String[1];
        args[0] = "D 1";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("1", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testDegreeD0() throws Exception {
        String[] args = new String[1];
        args[0] = "D 0";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("no pow", calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testDegreeDBig() throws Exception {
        String[] args = new String[1];
        args[0] = "D 65536";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536",
                calc.solve(args[0].split(" "))[0]);
    }
    @Test
    public void testSymbols() throws Exception {
        String[] args = new String[1];
        args[0] = "s qwerty";
        edu.sgu.lab1.calc.Calc calc = null;
        try {
            calc = new edu.sgu.lab1.calc.Calc();
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertArrayEquals(calc.solve(args[0].split(" ")),
            new String[]{" q, 1110001, 113, 161", " w, 1110111, 119, 167",
                " e, 1100101, 101, 145", " r, 1110010, 114, 162",
                " t, 1110100, 116, 164", " y, 1111001, 121, 171"});
    }

}
