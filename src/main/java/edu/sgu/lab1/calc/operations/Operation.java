package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Operation {

    protected char symbol;

    public abstract String getResult(int operand1, int operand2);

//    private static String symbols = "";
//    public String getSymbols(){return symbols;};

    protected static HashMap<Character, Integer> intMnemonics = new HashMap<>();
    protected static HashMap<Integer, Object> operations = new HashMap<>();

    protected void operationAdd(char symbol, Object operation){
        //StringBuilder stringBuilder = new StringBuilder(symbols);
        //symbols = stringBuilder.append(symbol).toString();
        Integer intMnemonic = mnemonic(symbol);
        intMnemonics.put(symbol, intMnemonic);
        operations.put(intMnemonic, operation);
    }

    public Integer mnemonic(char symbol){
        Integer result = null;
        result = Integer.valueOf((byte)symbol);
        if ((result == null) || (result==0)) throw new NullPointerException("No mnemonics");
        return result;
    }

    public Integer getMnemonic(){
        Integer result = null;
        result = mnemonic(symbol);
        if ((result == null) || (result==0)) throw new NullPointerException("Can't return mnemonics");
        return result;
    }

    public HashMap<Character, Integer> getMnemonics(){
        if (intMnemonics == null ) throw new NullPointerException("No mnemonics");
        return intMnemonics;
    };

    public HashMap<Integer, Object> getOperations(){
        if (operations == null ) throw new NullPointerException("No operations");
        return operations;
    };
}
