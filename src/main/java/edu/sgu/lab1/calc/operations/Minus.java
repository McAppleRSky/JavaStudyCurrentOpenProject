package edu.sgu.lab1.calc.operations;

public class Minus extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Minus(){
        symbol = '-';
        operationAdd(symbol);
        name = "Minus";
    }

    @Override
    public String getResult(int operand1, int operand2)  {
        return Integer.toString(operand1 - operand2);
    }

}
