package edu.sgu.lab1.calc.operations;

public class Fahrenheit extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Fahrenheit(){
        symbol = 'f';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Integer.toString((int) (operand1 * 9.0/5 + 32));
    }

 }
