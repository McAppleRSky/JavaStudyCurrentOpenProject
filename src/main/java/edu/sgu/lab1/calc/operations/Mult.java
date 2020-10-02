package edu.sgu.lab1.calc.operations;

public class Mult extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Mult(){
        symbol = '*';
        operationAdd(symbol);
        name = "Mult";
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Integer.toString(operand1 * operand2);
    }

}
