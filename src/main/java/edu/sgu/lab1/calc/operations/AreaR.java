package edu.sgu.lab1.calc.operations;

public class AreaR extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public AreaR(){
        symbol = 'R';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        float value =(float)Math.PI * operands[0] * operands[0];
      return String.format("%.2f", value);
    }

}
