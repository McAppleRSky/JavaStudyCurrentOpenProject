package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.List;

public class Symbols extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Symbols(){
        symbol = 's';
        operationAdd(symbol);
    }

    @Override
    public String[] getResult(int ... operands) {
        String inputStrung = restoreString(operands),
                delim = ", ";
        result = new String[operands.length];
        for(int i=0;i<inputStrung.length();i++){
            StringBuilder resultString = new StringBuilder(" ");
            resultString
                .append(inputStrung.charAt(i))
                    .append(delim)
                    .append(Integer.toBinaryString(operands[i]))
                    .append(delim)
                    .append(Integer.toString(operands[i]))
                    .append(delim)
                    .append(Integer.toOctalString(operands[i]))
            ;
            result[i] = resultString.toString();
        }
        return result;
    }

    private String restoreString(int[] operands) {
        StringBuilder resultString = new StringBuilder();
        for(int symbol:operands) resultString.append((char)symbol);
        return resultString.toString();
    }

}
