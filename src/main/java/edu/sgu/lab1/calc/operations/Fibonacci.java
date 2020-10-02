package edu.sgu.lab1.calc.operations;

public class Fibonacci extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Fibonacci(){
        symbol = 'F';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        int value;
        String result = unSolveMsg;
        if(operand1<1)return result;
        value = fibonacciSumm(1, 1, operand1);
        result = "value of element #" + operand1 + " is dec : " + Integer.toString(value)
                + ", hex : "+ Integer.toHexString(value)
                + ", oct : "+ Integer.toOctalString(value)
                + ", bin : "+ Integer.toBinaryString(value);
        return result;
    }

    protected int fibonacciSumm(int prev, int prevPrev, int n) {
        if(n>0) return fibonacciSumm(prev+prevPrev, prev, n-1);
        else return prev;
    }

}
