package edu.sgu.lab1.calc.operations;

public class Celsius extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Celsius(){
        symbol = 'c';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        result[0] = Integer.toString((int) (5.0/9*(operands[0] - 32)));
        return result;
    }

 }
