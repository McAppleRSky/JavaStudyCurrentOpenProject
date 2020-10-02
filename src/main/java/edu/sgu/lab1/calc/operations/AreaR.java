package edu.sgu.lab1.calc.operations;

public class AreaR extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public AreaR(){
        symbol = 'R';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        float value =(float)Math.PI * operand1 * operand1;
      return String.format("%.2f", value);
    }

}
