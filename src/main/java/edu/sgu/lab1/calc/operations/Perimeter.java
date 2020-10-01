package edu.sgu.lab1.calc.operations;

public class Perimeter extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Perimeter(){
        symbol = 'P';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
      double c =  Math.sqrt(Math.pow(operand1, 2) + Math.pow(operand2, 2));
      return Integer.toString((int) c + operand1 + operand2);
    }

}
