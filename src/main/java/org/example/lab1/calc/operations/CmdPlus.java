package org.example.lab1.calc.operations;

public class CmdPlus extends Cmd{
    CmdPlus(){
        this.cmdIndex = 0;
    }

    @Override
    String getResult(int operand1, int operand2) {
        return Integer.toString(operand1 + operand2);
    }
}
