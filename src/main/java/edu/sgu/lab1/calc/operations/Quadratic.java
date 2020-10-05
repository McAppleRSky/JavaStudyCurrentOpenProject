package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.List;

public class Quadratic  extends Operation {

    private int intMnemonic = Integer.MAX_VALUE;

    public Quadratic (){
        symbol = 'Q';
        operationAdd(symbol);
    }

    @Override
    public String getResult(int ... operands) {
        List<Float> roots = new ArrayList<>();
        List<Double> sqrtDiscriminants = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        float discriminant = operands[1]*operands[1]-4*operands[0]*operands[2];
        if(discriminant < 0) result.append("no roots");
        else {
            if(discriminant > 0){
                sqrtDiscriminants.add(Math.sqrt(discriminant));
                sqrtDiscriminants.add(-Math.sqrt(discriminant));
            }else sqrtDiscriminants.add((double) 0);
            for (double sqrtDiscriminant:sqrtDiscriminants)
                roots.add(
                        (float)((-operands[1]+sqrtDiscriminant)/(2*operands[0])) );
            for (float root:roots){
                if(result.length()==0) result.append(Double.toString(root));
                else result.append(", " + Float.toString(root));
            }
        }
        return result.toString();
    }

}
