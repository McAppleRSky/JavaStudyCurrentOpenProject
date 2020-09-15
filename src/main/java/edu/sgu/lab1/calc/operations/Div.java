package edu.sgu.lab1.calc.operations;

public class Div extends Operation {

    private char symbol = '/';
    private int intMnemonic = Integer.MAX_VALUE;

    @Override
    public String getResult(int operand1, int operand2) {
        return Float.toString(operand1 / operand2);
    }

    @Override
    protected void init() {
        StringBuilder stringBuilder = new StringBuilder(simbols);
        stringBuilder.append(symbol);
        intMnemonic = (byte)symbol;
        mnemonics.put(String.valueOf(symbol), Integer.valueOf(symbol));
    }


    void Plus(){
        init();
    }

}
