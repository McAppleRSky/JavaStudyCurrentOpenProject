package edu.sgu.lab1.calc.operations;

public class Plus extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Plus(){
        symbol = '+';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Integer.toString(operand1 + operand2);
    }

 }
