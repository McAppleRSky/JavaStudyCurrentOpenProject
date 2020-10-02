package edu.sgu.lab1.calc.operations;

public class Div extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Div(){
        symbol = '/';
        operationAdd(symbol);
        name = "Div";
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Integer.toString( operand1 / operand2);
    }

}
