package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Operation {

    public abstract String getResult(int operand1, int operand2);

    protected static String symbols = "";

    protected static HashMap<String, Integer> intMnemonics = new HashMap<>();
    protected static HashMap<Integer, Object> operations = new HashMap<>();

    protected void operationAdd(char symbol, Object operation){
        StringBuilder stringBuilder = new StringBuilder(symbols);
        symbols = stringBuilder.append(symbol).toString();

        Integer intMnemonic = getMnemonic(symbol);
        intMnemonics.put(String.valueOf(symbol), intMnemonic);
        operations.put(intMnemonic, operation);
    }

    public Integer getMnemonic(char symbol){
        Integer result = null;
        result = Integer.valueOf((byte)symbol);
        if ((result == null) || (result==0)) throw new NullPointerException("No mnemonics");
        return result;
    }

    public String getSymbols(){
        return symbols;
    };

    public HashMap<String, Integer> getIntMnemonics(){
        if (intMnemonics == null ) throw new NullPointerException("No mnemonics");
        return intMnemonics;
    };

    public HashMap<Integer, Object> getOperations(){
        if (operations == null ) throw new NullPointerException("No operations");
        return operations;
    };
}
