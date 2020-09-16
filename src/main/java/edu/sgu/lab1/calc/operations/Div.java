package edu.sgu.lab1.calc.operations;

public class Div extends Operation {

    private char symbol = '/';
    private int intMnemonic = Integer.MAX_VALUE;

    public Div(){
        operationAdd(symbol, this);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Float.toString(operand1 / operand2);
    }

}
