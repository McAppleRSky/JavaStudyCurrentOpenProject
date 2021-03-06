package edu.sgu.lab1.calc.operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public abstract class Operation{

    protected String unSolveMsg = "Can't solve";

    protected char symbol;

    protected String[] result;

    public abstract String[] getResult(int ... operands);

    protected static HashMap<Character, Integer> intMnemonics = new HashMap<>();

        protected void operationAdd(char symbol){
        //StringBuilder stringBuilder = new StringBuilder(symbols);
        //symbols = stringBuilder.append(symbol).toString();
        Integer intMnemonic = genMnemonic(symbol);
        intMnemonics.put(symbol, intMnemonic);
    }


    public Integer genMnemonic(char symbol){
        Integer result = null;
        result = Integer.valueOf((byte)symbol);
        if ((result == null) || (result==0)) throw new NullPointerException("No mnemonics");
        return result;
    }

    public Integer getMnemonic(){
        Integer result = null;
        result = genMnemonic(symbol);
        if ((result == null) || (result==0)) throw new NullPointerException("Can't return mnemonics");
        return result;
    }

    public HashMap<Character, Integer> getMnemonics(){
        if (intMnemonics == null ) throw new NullPointerException("No mnemonics");
        return intMnemonics;
    }

}
