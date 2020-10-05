package edu.sgu.lab1.calc.operations;

public class AreaT extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public AreaT(){
        symbol = 'S';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        return Integer.toString((operands[0] * operands[1])/2);
    }

}
