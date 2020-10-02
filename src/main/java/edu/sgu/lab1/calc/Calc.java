package edu.sgu.lab1.calc;

import edu.sgu.lab1.calc.operations.Operation;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class Calc {

    private static final java.util.logging.Logger logger = Logger.getLogger(Cli.class.getName());

    protected String prefixPackage = "edu.sgu.lab1.calc.operations";
    protected HashMap<Integer, Integer> intsMnemonicAndValues = new HashMap<>();
    protected HashMap<Character, Integer> listSymbolsMnemonics = null;
    protected HashMap<Integer, PlainOperation> listMnemonicsOperations = new HashMap<>();
    protected HashMap<String, Method> method = new HashMap<>();
    protected String getResult = "getResult",
                genMnemonic = "genMnemonic",
                getMnemonic = "getMnemonic",
                getMnemonics = "getMnemonics";
    protected Class<?> operationClass = null;
    protected Object operationInstance = null;
    protected Class[] paramTypes = null;
    protected Object[] param = null;
    protected PlainOperation plainOperation = null;

    protected Calc() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Class<? extends Operation>> operations = new Reflections(prefixPackage).getSubTypesOf(Operation.class);
        if (operations.size() <= 0) throw new NullPointerException("Far too few operations");
        else {
            Iterator<Class<? extends Operation>> operation = operations.iterator();
            while (operation.hasNext()) {
                operationClass = Class.forName(operation.next().getName());
                operationInstance = operationClass.getDeclaredConstructor().newInstance();
                if (!method.containsKey(getMnemonic)) {
                    paramTypes = (Class<?>[]) null;
                    method.put(getMnemonic, operationClass.getMethod(getMnemonic, paramTypes));
                }
                paramTypes = new Class[]{int.class, int.class};
                method.put(getResult, operationClass.getMethod(getResult, paramTypes));
                param = new Object[]{};
                Integer mn = 0;
                mn = (Integer) method.get(getMnemonic).invoke(operationInstance, param);
                plainOperation = new PlainOperation(operationInstance, method.get(getResult));
                listMnemonicsOperations.put(mn, plainOperation);
            }
            paramTypes = (Class<?>[]) null;
            method.put(getMnemonics, operationClass.getMethod(getMnemonics, paramTypes));
            paramTypes = new Class[]{char.class};
            method.put(genMnemonic, operationClass.getMethod(genMnemonic, paramTypes));
            param = new Object[]{};
            listSymbolsMnemonics = (HashMap<Character, Integer>) method.get(getMnemonics).invoke(operationInstance, param);
        }
    }

    /*
     *  reference to Operation.class
     * */
    protected Integer genMnemonicInvoker(char symbol) throws InvocationTargetException, IllegalAccessException {
        Integer result = null;
        param = new Object[]{symbol};
        result = (Integer) method.get(genMnemonic).invoke(operationInstance, param);
        if ((result == null) || (result == 0)) throw new NullPointerException("No mnemonics");
        return result;
    }

    protected String solve(String[] args) throws InvocationTargetException, IllegalAccessException {
        String result, actualSymbolExpression = getActualSymbolExpression(args);
        if (args.length > 3) logger.warning("Too match parameters (more then 3)");
        switch (actualSymbolExpression) {
            case "ioi":
                result = oparate(intsMnemonicAndValues.get(1), intsMnemonicAndValues.get(0), intsMnemonicAndValues.get(2));
                break;
            case "oii": result = oparate(intsMnemonicAndValues.get(0), intsMnemonicAndValues.get(1), intsMnemonicAndValues.get(2));
                break;
            default:
                if (actualSymbolExpression.substring(0, 2).equals("oi")) {
                    if (args.length > 2) logger.warning("Too match parameters (more then 2)");
                    result = oparate(intsMnemonicAndValues.get(0), intsMnemonicAndValues.get(1), 0);
                    break;
                }
                result = ("Can not solve expression for this parameters");
                break;
        }
        return result;
    }

    protected String getActualSymbolExpression(String[] values) throws InvocationTargetException, IllegalAccessException {
        StringBuilder actualExpression = new StringBuilder("   ");
        for (int i = 0; i < actualExpression.length(); i++) {
            if(i<values.length) //for one operand (two arguments)
                actualExpression.setCharAt(i, getSymbolol_saveToMnemonicsValues(i, values[i]));
        }
        return actualExpression.toString();
    }

    protected char getSymbolol_saveToMnemonicsValues(int i, String value) throws InvocationTargetException, IllegalAccessException {
        char symbol;
        try {
            intsMnemonicAndValues.put(i, Integer.parseInt(value));
            return 'i';
        } catch (NumberFormatException numberFormatException) {
            symbol = value.charAt(0);
            if (isOperation(symbol)) {
                intsMnemonicAndValues.put(i, genMnemonicInvoker(symbol));
                return 'o';
            } else return 'n';
        }
    }

    protected boolean isOperation(char symbol) {
        return listSymbolsMnemonics.containsKey(symbol);
    }

    protected String oparate(Integer mnemonicOperation, Integer operand1, Integer operand2) throws InvocationTargetException, IllegalAccessException {
        String result;
        param = new Object[]{};
        Integer lastMnemonicOperation = (Integer) method.get(getMnemonic).invoke(operationInstance, param);
        if (lastMnemonicOperation == null) throw new NullPointerException("Can't mnemonic read last");
        else {
            param = new Object[]{operand1, operand2};
            if (mnemonicOperation == lastMnemonicOperation) {
                result = (String) method.get(getResult).invoke(operationInstance, param);
            } else {
                plainOperation = listMnemonicsOperations.get(mnemonicOperation);
                result = (String) plainOperation.getMethod().invoke(plainOperation.getInstance(), param);
            }
        }
        if (lastMnemonicOperation == null) throw new NullPointerException("Can't invoke operation");
        return result;
    }

}
