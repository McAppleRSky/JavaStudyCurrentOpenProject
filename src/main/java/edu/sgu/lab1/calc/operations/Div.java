package edu.sgu.lab1.calc.operations;

public class Div extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Div(){
        symbol = '/';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        int value = operands[0] / operands[1], operand1Fact = operands[1] * value;
        if (operands[0] == operand1Fact)
            return Integer.toString(value) + " (full)";
        else return "part : " + Integer.toString(value)
                + ", remain : " + Integer.toString(operands[0] - operand1Fact);
    }

}
