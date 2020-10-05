package edu.sgu.lab1.calc.operations;

public class Fahrenheit extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Fahrenheit(){
        symbol = 'f';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        result[0] = Integer.toString((int) (operands[0] * 9.0/5 + 32));
        return result;
    }

 }
