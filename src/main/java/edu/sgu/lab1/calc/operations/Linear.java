package edu.sgu.lab1.calc.operations;

public class Linear extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Linear (){
        symbol = 'L';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        return Integer.toString(- operands[1]/operands[0]);
    }

}
