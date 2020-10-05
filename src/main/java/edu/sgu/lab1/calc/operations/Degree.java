package edu.sgu.lab1.calc.operations;

public class Degree extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Degree(){
        symbol = '^';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        return Integer.toString((int) Math.pow(operands[0], operands[1]));
    }

}
