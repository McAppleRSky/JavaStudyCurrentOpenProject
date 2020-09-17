package edu.sgu.lab1.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void testConstructor() {
        Calc calc = new Calc();
        assertEquals("edu.sgu.lab1.calc.operations", calc.prefixPackage);
        assertEquals(5, calc.method.size());
        assertEquals(4, calc.listSymbolsMnemonics.size());
        assertEquals(4, calc.listMnemonicsOperations.size());
    }
    @Test
    public void testSymbolOperation() {
        Calc calc = new Calc();
        assertTrue(calc.isOperation('+'));
        assertTrue(calc.isOperation('-'));
        assertTrue(calc.isOperation('*'));
        assertTrue(calc.isOperation('/'));
        assertFalse(calc.isOperation('~'));
    }
    @Test
    public void testMnemonic() {
        Calc calc = new Calc();
        assertTrue((Integer)calc.mnemonicInvoker('+')>Integer.valueOf(0));
        assertEquals(Integer.valueOf(43), (Integer)calc.mnemonicInvoker('+'));
        assertEquals(Integer.valueOf(45), (Integer)calc.mnemonicInvoker('-'));
        assertEquals(Integer.valueOf(42), (Integer)calc.mnemonicInvoker('*'));
        assertEquals(Integer.valueOf(47), (Integer)calc.mnemonicInvoker('/'));
        assertEquals(Integer.valueOf(126), (Integer)calc.mnemonicInvoker('~'));
    }
    @Test
    public void testMnemonicValue() {
        Calc calc = new Calc();
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "0") == 'i');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(1, "999") == 'i');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(2, "+") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(3, "-") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(4, "/") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(5, "*") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(6, "**") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(7, "_") != 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(7, "~") == 'n');
    }
    @Test
    public void testExpression() throws Exception {
        String[] args = {"1","/","1"};
        Calc calc = new Calc();
        assertEquals(calc.getActualSymbolExpression(args),"ioi");
    }
    @Test
    public void testNotExpression() throws Exception {
        String[] args = {"/","0","_"};
        Calc calc = new Calc();
        assertEquals(calc.getActualSymbolExpression(args),"oin");
    }
    @Test
    public void testSimpleDiv() throws Exception {
        String[] args = {"1","/","1"};
        Calc calc = new Calc();
        assertEquals("1.0", calc.solve(args));
    }
    @Test
    public void testPlus() throws Exception {
        String[] args = {"1","+","1"};
        Calc calc = new Calc();
        assertEquals("2", calc.solve(args));
    }
    @Test
    public void testMinus() throws Exception {
        String[] args = {"1","-","1"};
        Calc calc = new Calc();
        assertEquals("0", calc.solve(args));
    }
    @Test
    public void testMult() throws Exception {
        String[] args = {"1","*","1"};
        Calc calc = new Calc();
        assertEquals("1", calc.solve(args));
    }
}
