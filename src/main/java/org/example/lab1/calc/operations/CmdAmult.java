package org.example.lab1.calc.operations;

public class CmdAmult extends Precmd{

    CmdAmult(){
        this.cmdIndex = 3;
    }

    @Override
    String getResult(int operand1, int operand2) {
        return Float.toString(operand1 / operand2);
    }


}
