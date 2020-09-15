package edu.sgu.lab1.calc;

import edu.sgu.lab1.calc.operations.Operation;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class Cli {

    private static Calc calc = new Calc();
    static String prefixPackage = "edu.sgu.lab1.calc.operations";
    static Set<Class<? extends Operation>> operations;
    static Class<?> classOperation;

    public static void main(String[] args) {
        operations = new Reflections(prefixPackage).getSubTypesOf(Operation.class);
        if (operations.size()<=0) System.out.println("I dont know operations");
        else{
            Iterator<Class<? extends Operation>> operation = operations.iterator();
            while (operation.hasNext()){
                try {
                    classOperation = Class.forName(operation.next().getName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
//            for (Class<? extends Operation> operation :operations){
            }
        //Class operation = (Class) classOperation.getDeclaredConstructor().newInstance();
        //Method[] methods = classOperation.getMethods();
        Method method = null;
        try {
            method = classOperation.getMethod("getSymbols", null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        String str = null;
        try {
            method.invoke(str, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //Operation preOperation = (Operation) currentOperation;
        //Map<Key,Item> map = new HashMap<Key,Item>();
        //for (Item i : list) map.put(i.getKey(),i);
        System.out.println(calc.solve(args));
    }
}
