package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.List;

public class DegreeD extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public DegreeD(){
        symbol = 'D';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        StringBuilder resultString = new StringBuilder();
        List<Integer> pows = new ArrayList<>();
        for (int i=0;i>=0;i++){
            int pow = (int) Math.pow(2, i);
            if (pow>operands[0]) {
                if(pows.size()==0) resultString.append("no pow");
                break;
            } else pows.add(pow);
        }
        for (int pow:pows){
            if (resultString.length()==0) resultString.append(Integer.toString(pow));
            else resultString.append(", " + Integer.toString(pow));
        }
        result[0] = resultString.toString();
        return result;
    }

}
