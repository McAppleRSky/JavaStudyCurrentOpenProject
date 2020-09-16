package edu.sgu.lab1.calc;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalcTest {

    @Test
    public void testMnemonicValue() {
        Calc calc = new Calc();
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "+") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "-") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "/") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "*") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "*") == 'o');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "0") == 'i');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "999") == 'i');
        assertTrue(calc.getSymbolol_SaveToMnemonicsValues(0, "_") != 'n');
    }
    @Test
    public void testExpression() throws Exception {
        String[] expression = {"1","+","1"};
        Calc calc = new Calc();
        assertEquals(calc.getActualSymbolExpression(expression),"ioi");
    }
    @Test
    public void testNotExpression() throws Exception {
        String[] expression = {"/","0","_"};
        Calc calc = new Calc();
        assertEquals(calc.getActualSymbolExpression(expression),"oin");
    }
}
