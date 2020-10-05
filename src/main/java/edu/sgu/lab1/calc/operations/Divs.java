package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.List;

public class Divs extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Divs(){
        symbol = 'd';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        StringBuilder result = new StringBuilder();
        List<String> divList = new ArrayList<>();
        for (int div = operand1; div>0;div--)
            if(operand1 % div == 0)
                divList.add(Integer.toString(div));
        for (Object item:divList.toArray()){
            if(result.length()==0)
                result.append(item);
            else result.append(", " + item);
        }
        return result.toString();
    }

}
