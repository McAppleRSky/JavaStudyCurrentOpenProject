package edu.sgu.lab1.calc.operations;

public class Area extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Area(){
        symbol = 'S';
        operationAdd(symbol);
        name = "Area";
    }

    @Override
    public String getResult(int operand1, int operand2) {
      return Integer.toString((operand1 * operand2)/2);
    }

}
