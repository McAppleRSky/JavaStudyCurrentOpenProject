package edu.sgu.lab1.calc.operations;

import edu.sgu.lab1.calc.Cli;

import java.util.logging.Logger;

public class Fibonacci extends Operation {

    private static final java.util.logging.Logger logger = Logger.getLogger(Fibonacci.class.getName());

    private int intMnemonic = Integer.MAX_VALUE;

//    private final String cantSolve = "Can't solve";

    public Fibonacci(){
        symbol = 'F';
        operationAdd(symbol);
    }

    private int prev = 0;

    protected boolean isFibonacci(int curr, int actualNumb){
        int summ = curr + prev;
        if(summ<0) return false;
        else{
            prev = curr;
            if(actualNumb == summ) return true;
            return isFibonacci(summ, actualNumb);
        }
    }

    @Override
    public String getResult(int operand1, int operand2) {
        String result = "San't solve";
        if(operand1 > 1) logger.warning("Source number mast be = 1");
        if(isFibonacci(1, operand1)){

        }
        else new Exception("Source number not fibonacci");

        return result;
        //Integer.toString((int) Math.pow(operand1, operand2));
    }

}
