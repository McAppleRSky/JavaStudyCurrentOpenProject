package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Operation {

    public abstract String getResult(int operand1, int operand2);
    protected abstract void init();

    protected String symbols = "";
    protected HashMap<String, Integer> mnemonics = new HashMap<>();
    protected HashMap<Integer, Object> operations = new HashMap<>();
    public abstract String getSymbols();


    /*    private int cmdIndex;

    public void setCmdIndex(int cmdIndex) {
        this.cmdIndex = cmdIndex;
    }


    public int getCmdIndex() {
        return cmdIndex;
    }

    public String getAllCmdInString() {
        return allCmdInString;
    }*/

}
