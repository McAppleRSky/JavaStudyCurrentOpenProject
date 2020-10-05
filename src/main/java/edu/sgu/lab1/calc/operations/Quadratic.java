package edu.sgu.lab1.calc.operations;

public class Quadratic  extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Quadratic (){
        symbol = 'Q';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        return Integer.toString(operands[0]+operands[1]+operands[2]);
    }

}
