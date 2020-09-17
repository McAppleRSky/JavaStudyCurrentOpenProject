package edu.sgu.lab1.calc;

import edu.sgu.lab1.calc.operations.Div;
import edu.sgu.lab1.calc.operations.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Calc {

    static Logger logger = LogManager.getLogger("Calc");

    protected String prefixPackage = "edu.sgu.lab1.calc.operations";
    protected HashMap<Integer, Integer> intsMnemonicAndValues = new HashMap<>();
    protected HashMap<Character, Integer> listSymbolsMnemonics = null;
    protected HashMap<Integer, Object> listMnemonicsOperations = null;
    protected HashMap<String, Method> method = new HashMap<>();
    protected String //getSymbols = "getSymbols",
            getMnemonics = "getMnemonics",
            getOperations = "getOperations",
            mnemonic = "mnemonic",
            getResult = "getResult",
            getMnemonic = "getMnemonic";
    protected Class<?> operationClass = null;
    protected Object operationInstance = null;
    protected Class[] paramTypes = null;
    protected Object[] param = null;

    protected Calc() {
        Set<Class<? extends Operation>> operations;
        operations = new Reflections(prefixPackage).getSubTypesOf(Operation.class);
        if (operations.size() <= 0) throw new NullPointerException("Far too few operations");
        else {
            Iterator<Class<? extends Operation>> operation = operations.iterator();
            while (operation.hasNext()) {
                try {
                    operationClass = Class.forName(operation.next().getName());
                    operationInstance = operationClass.getDeclaredConstructor().newInstance();
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            paramTypes = (Class<?>[]) null;
            method.put(getMnemonics, operationClass.getMethod(getMnemonics, paramTypes));
            method.put(getOperations, operationClass.getMethod(getOperations, paramTypes));
            method.put(getMnemonic, operationClass.getMethod(getMnemonic, paramTypes));
            paramTypes = new Class[]{char.class};
            method.put(mnemonic, operationClass.getMethod(mnemonic, paramTypes));
            paramTypes = new Class[]{int.class, int.class};
            method.put(getResult, operationClass.getMethod(getResult, paramTypes));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            param =  new Object[] {};
            listSymbolsMnemonics
                = (HashMap<Character, Integer>) method.get(getMnemonics)
                    .invoke(operationInstance, param);
            listMnemonicsOperations
                = (HashMap<Integer, Object>) method.get(getOperations)
                    .invoke(operationInstance, param);
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     *  reference to Operation.class
     * */
    protected Integer mnemonicInvoker(char symbol) {
        Integer result = null;
        try {
            param = new Object[]{symbol};
            result = (Integer) method.get(mnemonic).invoke(operationInstance, param);
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ((result == null) || (result == 0)) throw new NullPointerException("No mnemonics");
        return result;
    }

    protected String solve(String[] Args) {
        String expectedSymbolExpression = "ioi";
        if (!tstArgsCount(Args)) return ("Too many parameters");
        else if (!expectedSymbolExpression.equals(getActualSymbolExpression(Args)))
            return ("Can not solve expression for this parameters");
        else
            return oparate(intsMnemonicAndValues.get(1), intsMnemonicAndValues.get(0), intsMnemonicAndValues.get(2));
    }

    protected boolean tstArgsCount(String[] tstStrs) {
        if (tstStrs.length < 3) return false;
        else if (tstStrs.length > 3) logger.warn("Too match parameters");
        return true;
    }

    protected String getActualSymbolExpression(String[] values) {
        StringBuilder actualExpression = new StringBuilder("   ");
        for (int i = 0; i < actualExpression.length(); i++) {
            actualExpression.setCharAt(i, getSymbolol_SaveToMnemonicsValues(i, values[i]));
        }
        return actualExpression.toString();
    }

    protected char getSymbolol_SaveToMnemonicsValues(int i, String value) {
        char symbol;
        try{intsMnemonicAndValues.put(i, Integer.parseInt(value));
            return 'i';
        } catch (NumberFormatException numberFormatException) {
            symbol = value.charAt(0);
            if (isOperation(symbol)) {
                intsMnemonicAndValues.put(i, mnemonicInvoker(symbol));
                return 'o';
            }else return 'n';
        }
    }

    protected boolean isOperation(char symbol) {
        return listSymbolsMnemonics.containsKey(symbol);
    }

    protected String oparate(Integer mnemonicOperation, Integer operand1, Integer operand2) {
        String result = null;
        param =  new Object[] {};
        Integer lastMnemonicOperation = null;
        try {
            lastMnemonicOperation = (Integer) method.get(getMnemonic).invoke(operationInstance, param);
        } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (lastMnemonicOperation == null) throw new NullPointerException("Can't mnemonic read last");
        else {
            param =  new Object[] {operand1, operand2};
            if (mnemonicOperation == lastMnemonicOperation){
                try {
                    result = (String) method.get(getResult).invoke(operationInstance, param);
                } catch (IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
/*        operationClass.
        operationInstance
//        if(operationInstance)
        operationClass = listMnemonicsOperations.get(mnemonicOperation).getClass();
        try {
            operationInstance = operationClass.getDeclaredConstructor().newInstance();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
        paramTypes = new Class[]{int.class, int.class};
        try {
            method.put(getResult, operationClass.getMethod(getResult, paramTypes));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        param = new Object[]{operand1, operand2};
        try {
            result = (String) method.get(getResult).invoke(operationClass, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        //if (result == null) throw new NullPointerException("result = null");
        return result;
    }

}
