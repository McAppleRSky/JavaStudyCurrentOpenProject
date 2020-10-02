package edu.sgu.lab1.calc.operations;

public class Round extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Round(){
        symbol = 'C';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        float value = (float)Math.PI * 2 * operand1;
      return String.format("%.1f", value);
    }

}
