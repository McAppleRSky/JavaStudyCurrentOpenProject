package org.example.lab1.calc.operations;

public class CmdMinus extends Cmd{
    CmdMinus(){
        this.cmdIndex = 1;
    }

    @Override
    String getResult(int operand1, int operand2) {
        return Integer.toString(operand1 - operand2);
    }
}
