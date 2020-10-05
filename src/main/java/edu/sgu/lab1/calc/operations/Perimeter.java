package edu.sgu.lab1.calc.operations;

public class Perimeter extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Perimeter(){
        symbol = 'p';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        result[0] = Integer.toString((operands[0] + operands[1]) * 2);
        return result;
    }

}
