package edu.sgu.lab1.calc;

import edu.sgu.lab1.calc.operations.Operation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Calc {

    static Logger logger = LogManager.getLogger("Calc");

    private String prefixPackage = "edu.sgu.lab1.calc.operations";
    private String symbolsOperations = null;
    private HashMap<String, Integer> symbolsMnemonics = null;
    private HashMap<Integer, Object> mnemonicsOperations = null;

    private Method getSymbolsMethod = null,
            getIntMnemonicsMethod = null,
            getOperationsMethod = null,
            getMnemonicMethod = null,
            getResultMethod = null;
    private Object instanceCurrentLastOperation = null;
    private Class[] paramTypesMethod = null;
    private Class<?> operationClass = null;

    protected Calc() {
        Set<Class<? extends Operation>> operations;
        operations = new Reflections(prefixPackage).getSubTypesOf(Operation.class);
        if (operations.size() <= 0) throw new NullPointerException("Far too few operations");
        else {
            Iterator<Class<? extends Operation>> operation = operations.iterator();
            while (operation.hasNext()) {
                try {
                    operationClass = Class.forName(operation.next().getName());
                    instanceCurrentLastOperation = operationClass.getDeclaredConstructor().newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            getSymbolsMethod = operationClass.getMethod("getSymbols", null);
            getIntMnemonicsMethod = operationClass.getMethod("getIntMnemonics", null);
            getOperationsMethod = operationClass.getMethod("getOperations", null);
            paramTypesMethod = new Class[]{char.class};
            getMnemonicMethod = operationClass.getMethod("getMnemonic", paramTypesMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            symbolsOperations = (String) getSymbolsMethod.invoke(instanceCurrentLastOperation, null);
            symbolsMnemonics = (HashMap<String, Integer>) getIntMnemonicsMethod.invoke(instanceCurrentLastOperation, null);
            mnemonicsOperations = (HashMap<Integer, Object>) getOperationsMethod.invoke(instanceCurrentLastOperation, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected Integer getMnemonicInvoker(char symbol){
        Integer result = null;
        try {
            // reference to Operation.class
            result = (Integer) getOperationsMethod.invoke(instanceCurrentLastOperation, symbol);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ((result == null) || (result==0)) throw new NullPointerException("No mnemonics");
        return result;
    }



//    private String result = null;
//    private final String defaultResult = "nothing";

//    private final String allOperationsInString = "+-*/";
    /*    private final int intPlus = (byte)allOperationsInString.charAt(0);
    private final int intMinus = (byte)allOperationsInString.charAt(1);
    private final int intMult = (byte)allOperationsInString.charAt(2);
    private final int intAmult = (byte)allOperationsInString.charAt(3);
*/


    private HashMap<Integer, Integer> intMnemonicsAndValues = new HashMap<>();
//    private List<Class<?>> OpreationClass;

    //private int getIntValueForIndex (int i){return intMnemonicAndValues.get(i);}
    //private int getIntValuesCount (){return intMnemonicAndValues.size();}

    protected String solve(String[] Args //, String sympols, HashMap<String, Integer> intMnemonics, HashMap<Integer, Object> operatoons
    ) {
        String expectedSymbolExpression = "ioi";
        if (!tstArgsCount(Args)) return ("Too many parameters");
        else if (!expectedSymbolExpression.equals(getActualSymbolExpression(Args)))
            return ("Can not solve expression for this parameters");
        else
            return oparate(intMnemonicsAndValues.get(1),
                            intMnemonicsAndValues.get(0),
                            intMnemonicsAndValues.get(2));
    }

    protected boolean tstArgsCount(String[] tstStrs) {
        if (tstStrs.length < 3) return false;
        else if (tstStrs.length > 3) logger.warn("Too match parameters");
        return true;
    }

    protected String getActualSymbolExpression(String[] values) {
        StringBuffer actualExpression = new StringBuffer("   ");
        for (int i = 0; i < actualExpression.length(); i++) {
            actualExpression.setCharAt(i, getSymbolol_SaveToMnemonicsValues(i, values[i]));
        }
        return actualExpression.toString();
    }

    protected char getSymbolol_SaveToMnemonicsValues(int i, String value) {
        char symbol;
        try {
            intMnemonicsAndValues.put(i, Integer.parseInt(value));
            return 'i';
        } catch (NumberFormatException numberFormatException) {
            symbol = value.charAt(0);
            if ( isOperation(symbol) ) {
                intMnemonicsAndValues.put(i, getMnemonicInvoker(symbol));
                return 'o';
            }
        }
        return 'n';
    }

    private boolean isOperation(char symbol) {
        StringBuffer operationsBuffer = new StringBuffer(symbolsOperations);
        for(int i=0;i<operationsBuffer.length();i++)
            if(operationsBuffer.charAt(i) == symbol)
                return true;
        return false;
    }

    /*    public int getOperationIntByString(String oparationInString) {
        switch (oparationInString.charAt(0)) {
            case '+':
                return 0;//intPlus;
            case '-':
                return 0;//intMinus;
            case '*':
                return 0;//intMult;
            case '/':
                return 0;//intAmult;
            default:
                throw new NullPointerException("Unsupported opearation");
        }
    }*/

    private String oparate(Integer mnemonicOperation, Integer operand1, Integer operand2) {
        String result = null;
        operationClass = mnemonicsOperations.get(mnemonicOperation).getClass();
        paramTypesMethod = new Class[]{Integer.class, Integer.class};
        try {
            getResultMethod = operationClass.getMethod("getResult", paramTypesMethod);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            result = (String) getResultMethod.invoke(operationClass, operand1, operand2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == null) throw new NullPointerException("result = null");
        return result;
    }

    //public void setOperationsList(List<Class<?>> allClassesFrom) {this.OpreationClass = allClassesFrom;}




    /*    public boolean isOperation(int actualIntOperation, String ExpectedOparationInString){
        if (getOperationIntByString(ExpectedOparationInString) == actualIntOperation)
            return (true);
        else return false;
*/






/*    public String getResult() {
        if (result == null) return (defaultResult);
        return result;
    }
*/


}
