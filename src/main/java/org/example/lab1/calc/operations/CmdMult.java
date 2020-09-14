package org.example.lab1.calc.operations;

public class CmdMult extends Cmd {
    CmdMult(){
        this.setCmdIndex(2);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Integer.toString(operand1 * operand2);
    }
}
