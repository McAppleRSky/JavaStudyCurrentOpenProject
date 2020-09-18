package edu.sgu.lab1.calc.operations;

public class Minus extends Operation {

    //private char symbol = '-';
    private int intMnemonic = Integer.MAX_VALUE;

    public Minus(){
        symbol = '-';
        operationAdd(symbol//, this
                            );
    }

    @Override
    public String getResult(int operand1, int operand2)  {
        return Integer.toString(operand1 - operand2);
    }

}
