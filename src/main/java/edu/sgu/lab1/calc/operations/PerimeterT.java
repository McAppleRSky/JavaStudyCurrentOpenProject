package edu.sgu.lab1.calc.operations;

public class PerimeterT extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public PerimeterT(){
        symbol = 'P';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        double c =  Math.sqrt(Math.pow(operands[0], 2) + Math.pow(operands[1], 2));
        result[0] = Integer.toString((int) c + operands[0] + operands[1]);
        return result;
    }

}
