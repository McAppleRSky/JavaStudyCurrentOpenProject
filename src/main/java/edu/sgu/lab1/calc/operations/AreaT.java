package edu.sgu.lab1.calc.operations;

public class AreaT extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public AreaT(){
        symbol = 'S';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
      return Integer.toString((operand1 * operand2)/2);
    }

}
