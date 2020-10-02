package edu.sgu.lab1.calc.operations;

public class Nod extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Nod(){
        symbol = 'N';//GCD
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Integer.toString(NOD(operand1, operand2));
    }

    protected int NOD(int m, int n) {
        int mod = m%n;
        if(mod==0) return n;
        else return NOD(n, mod);
    }

}
