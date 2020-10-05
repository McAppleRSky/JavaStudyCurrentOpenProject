package edu.sgu.lab1.calc.operations;

public class Fibonacci extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Fibonacci(){
        symbol = 'F';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        int value;
        String result = unSolveMsg;
        if(operands[0]<1)return result;
        value = fibonacciSumm(1, 1, operands[0]);
        result = "value of element #" + operands[0] + " is dec : " + Integer.toString(value)
                + ", hex : "+ Integer.toHexString(value)
                + ", oct : "+ Integer.toOctalString(value)
                + ", bin : "+ Integer.toBinaryString(value);
        return result;
    }

    protected int fibonacciSumm(int prev, int prevPrev, int n, int...ext) {
        if(n>0) return fibonacciSumm(prev+prevPrev, prev, n-1);
        else return prev;
    }

}
