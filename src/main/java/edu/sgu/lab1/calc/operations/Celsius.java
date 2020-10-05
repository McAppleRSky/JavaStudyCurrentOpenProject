package edu.sgu.lab1.calc.operations;

public class Celsius extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Celsius(){
        symbol = 'c';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        return Integer.toString((int) (5.0/9*(operands[0] - 32)));
    }

 }
