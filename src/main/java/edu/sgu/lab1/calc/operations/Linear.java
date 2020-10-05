package edu.sgu.lab1.calc.operations;

public class Linear extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Linear (){
        symbol = 'L';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        result[0] = Integer.toString(- operands[1]/operands[0]);
        return result;
    }

}
