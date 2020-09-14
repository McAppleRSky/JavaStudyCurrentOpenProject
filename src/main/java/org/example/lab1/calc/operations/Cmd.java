package org.example.lab1.calc.operations;

public abstract class Cmd implements Precmd {

    private int cmdIndex;
    private String allCmdInString = "+-*/";

    public void setCmdIndex(int cmdIndex) {
        this.cmdIndex = cmdIndex;
    }

    public abstract String getResult(int operand1, int operand2);

    public int getCmdIndex() {
        return cmdIndex;
    }

    public String getAllCmdInString() {
        return allCmdInString;
    }
}
