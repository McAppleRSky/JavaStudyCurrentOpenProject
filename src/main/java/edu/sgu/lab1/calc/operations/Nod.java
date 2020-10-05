package edu.sgu.lab1.calc.operations;

public class Nod extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Nod(){
        symbol = 'N';//GCD
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        result[0] = Integer.toString(NOD(operands[0], operands[1]));
        return result;
    }

    protected int NOD(int m, int n) {
        int mod = m%n;
        if(mod==0) return n;
        else return NOD(n, mod);
    }

}
