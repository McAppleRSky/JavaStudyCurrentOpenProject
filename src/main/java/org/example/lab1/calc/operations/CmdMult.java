package org.example.lab1.calc.operations;

public class CmdMult extends Cmd{
    CmdMult(){
        this.cmdIndex = 2;
    }

    @Override
    String getResult(int operand1, int operand2) {
        return Integer.toString(operand1 * operand2);
    }

}
