package org.example.lab1.calc.operations;

public class CmdAmult extends Cmd {

    CmdAmult(){
        this.setCmdIndex(3);
    }

    @Override
    public String getResult(int operand1, int operand2) {
        return Float.toString(operand1 / operand2);
    }

}
