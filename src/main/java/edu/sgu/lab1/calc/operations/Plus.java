package edu.sgu.lab1.calc.operations;

public class Plus extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Plus(){
        symbol = '+';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        result[0] = Integer.toString(operands[0] + operands[1]);
        return result;
    }

 }
