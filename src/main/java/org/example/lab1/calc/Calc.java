package org.example.lab1.calc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;

public class Calc {

    static Logger logger = LogManager.getLogger("Calc");
//    private String result = null;
//    private final String defaultResult = "nothing";

//    private final String allOperationsInString = "+-*/";
    /*    private final int intPlus = (byte)allOperationsInString.charAt(0);
    private final int intMinus = (byte)allOperationsInString.charAt(1);
    private final int intMult = (byte)allOperationsInString.charAt(2);
    private final int intAmult = (byte)allOperationsInString.charAt(3);
*/


    private HashMap<Integer, Integer> intIndexAndValues = new HashMap<>();
    private List<Class<?>> OpreationClass;

    public int getIntValueForIndex (int i){
        return intIndexAndValues.get(i);
    }
    public int getIntValuesCount (){
        return intIndexAndValues.size();
    }

    public String solve(String[] Args) {
        String tstCouldSolveSig = "ioi";
        if (!tstArgsCount(Args)) return ("Too many parameters");
        else
            if( ! tstCouldSolveSig.equals(getSnapshotExpression(Args)))
                return ("Can not solve expression for this parameters");
            else
                return oparate();
    }

    public boolean tstArgsCount(String[] tstStrs) {
        if (tstStrs.length < 3) return false;
        else if (tstStrs.length > 3) logger.warn("Too match parameters");
        return true;
    }

    public String getSnapshotExpression(String[] values){
        StringBuffer  snapshotWhitespaces = new StringBuffer("   ");
        for(int i=0;i<snapshotWhitespaces.length();i++) {
            snapshotWhitespaces.setCharAt(i, getChar4SnapsotAndSaveToInts(i, values[i]));
        }
        return snapshotWhitespaces.toString();
    }

    public char getChar4SnapsotAndSaveToInts(int i, String value) {
        try {
            intIndexAndValues.put(i, Integer.parseInt(value));
            return 'i';
        } catch (NumberFormatException numberFormatException) {
            if(isOperation(value)){
                intIndexAndValues.put(i, getOperationIntByString(value));
                return 'o';
            }
        }
        return 'n';
    }

    boolean isOperation(String value){
//        StringBuffer operationsBuffer = new StringBuffer(allOperationsInString);
//        for(int i=0;i<operationsBuffer.length();i++)
//            if(operationsBuffer.charAt(i) == value.charAt(0))
//                return true;
        return false;
    }

    public int getOperationIntByString(String oparationInString){
        switch (oparationInString.charAt(0)){
            case '+': return 0;//intPlus;
            case '-': return 0;//intMinus;
            case '*': return 0;//intMult;
            case '/': return 0;//intAmult;
            default:
                throw new NullPointerException("Unsupported opearation");
        }
    }

    public String oparate() {
        String result = null;
//        result = cmds.getResult(intIndexAndValues.get(1), intIndexAndValues.get(0), intIndexAndValues.get(2));
//        if (result == null) throw new NullPointerException("result = null");
        return result;
    }

    public void setOperationsList(List<Class<?>> allClassesFrom) {
        this.OpreationClass = allClassesFrom;
    }




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
