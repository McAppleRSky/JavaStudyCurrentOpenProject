package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.List;

public class Before extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Before(){
        symbol = 'b';
        operationAdd(symbol);
    }

    @Override
    public String[] getResult(int ... operands) {
        String delim = ", ", numb;
        int intA = 65;
        if( (operands[0]<intA)||(operands[0]>90) ){
            result = new String[1];
            result[0] = "Not a alphabet symbol";
        }
        else {
            int count = operands[0] - intA + 1;
            result = new String[count];
            for(int i = 0;i<count;i++){
                if(i<9)numb = " "+Integer.toString(i+1)+". ";
                else numb = Integer.toString(i+1)+". ";
                StringBuilder resultString = new StringBuilder();
                resultString
                        .append(numb)
                        .append((char)(intA+i))                        .append(delim)
                        .append(Integer.toHexString(intA+i))
                        .append(delim)
                        .append(Integer.toOctalString(intA+i))
                        .append(delim)
                        .append(Integer.toBinaryString(intA+i));
                result[i]=resultString.toString();
            }
        }
        return result;
    }

}
