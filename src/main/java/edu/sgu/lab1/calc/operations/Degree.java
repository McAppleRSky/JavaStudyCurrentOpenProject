package edu.sgu.lab1.calc.operations;

public class Degree extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Degree(){
        symbol = '^';
        operationAdd(symbol);
        name = "Degree";
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Integer.toString((int) Math.pow(operand1, operand2));
    }

}
