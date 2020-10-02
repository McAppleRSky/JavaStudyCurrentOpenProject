package edu.sgu.lab1.calc.operations;

import java.util.logging.Logger;

public class Fibonacci extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Fibonacci(){
        symbol = 'F';
        operationAdd(symbol);
        name = "Fibonacci";
    }


    @Override
    public String getResult(int operand1, int operand2) {
        String result = unSolveMsg;
        if(operand1<1)return result;
        result = Integer.toString(fibonacciSumm(1, 1, operand1));

        /*if(operand1<1) logger.warning("Source number mast be = 1");
        String result = "San't solve";
        if(operand1 > 1) logger.warning("Source number mast be = 1");
        if(isFibonacci(1, operand1)){}
        else new Exception("Source number not fibonacci");
        //Integer.toString((int) Math.pow(operand1, operand2));*/
        return result;
    }

    //int i = 0;
    protected int fibonacciSumm(int prev, int prevPrev, int n) {
        /*i++;
        if (prev<0) try {
            throw new Exception("i = " + i);
        } catch (Exception e) {e.printStackTrace();}*/
        if(n>0) return fibonacciSumm(prev+prevPrev, prev, n-1);
        else return prev;
    }

//    private final String cantSolve = "Can't solve";
    /* private int prev = 0;
    protected boolean isFibonacci(int curr, int actualNumb){
        int summ = curr + prev;
        if(summ<0) return false;
        else{
            prev = curr;
            if(actualNumb == summ) return true;
            return isFibonacci(summ, actualNumb);}}*/
}
