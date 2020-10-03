package edu.sgu.lab1.calc.operations;

public class Linear extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Linear (){
        symbol = 'L';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
      return Integer.toString(0 - operand2/operand1);
    }

}
