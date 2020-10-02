package edu.sgu.lab1.calc.operations;

public class Perimeter extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Perimeter(){
        symbol = 'p';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
      return Integer.toString((operand1 + operand2) * 2);
    }

}
