package edu.sgu.lab1.calc.operations;

public class Round extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Round(){
        symbol = 'C';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        float value = (float)Math.PI * 2 * operands[0];
        result[0] = String.format("%.1f", value);
        return result;
    }

}
