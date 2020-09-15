package edu.sgu.lab1.calc;

import edu.sgu.lab1.calc.operations.Operation;
import org.reflections.Reflections;
import java.util.Set;

public class Cli {

    private static Calc calc = new Calc();
    static String prefixPackage = "edu.sgu.lab1.calc.operations";
    static Set<Class<? extends Operation>> operations;

    public static void main(String[] args) {
        operations = new Reflections(prefixPackage).getSubTypesOf(Operation.class);
        if (operations.size()<=0) System.out.println("I dont now operations");
        else{
            operations.toArray()[0]
        }

        //Map<Key,Item> map = new HashMap<Key,Item>();
        //for (Item i : list) map.put(i.getKey(),i);
        System.out.println(calc.solve(args));
    }
}
