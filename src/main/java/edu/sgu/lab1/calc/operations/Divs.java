package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.List;

public class Divs extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Divs(){
        symbol = 'd';
        operationAdd(symbol);
        result = new String[1];
    }

    @Override
    public String[] getResult(int ... operands) {
        StringBuilder resultString = new StringBuilder();
        List<String> divList = new ArrayList<>();
        for (int div = operands[0]; div>0;div--)
            if(operands[0] % div == 0)
                divList.add(Integer.toString(div));
        for (Object item:divList){
            if(resultString.length()==0)
                resultString.append(item);
            else resultString.append(", " + item);
        }
        result[0] = resultString.toString();
        return result;
    }

}
