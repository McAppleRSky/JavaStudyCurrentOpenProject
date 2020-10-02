package edu.sgu.lab1.calc.operations;

public class Div extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Div(){
        symbol = '/';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        int value = operand1 / operand2, operand1Fact = operand2 * value;
        if (operand1 == operand1Fact)
            return Integer.toString(value) + " (full)";
        else return "part : " + Integer.toString(value)
                + ", remain : " + Integer.toString(operand1 - operand1Fact);
    }

}
