package edu.sgu.lab1.calc.operations;

public class Degree extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Degree(){
        symbol = '^';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        result[0] = Integer.toString((int) Math.pow(operands[0], operands[1]));
        return result;
    }

}
