package edu.sgu.lab1.calc;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class Cli {

    private static final Logger logger = Logger.getLogger(Calc.class.getName());

    private static Calc calc;

    public static void main(String[] args) {
        if(args.length == 0) System.out.println("?! Need input parameters (type trough delimiter whitespace. Mask: digit, operation, digit). ");
        else try {
            calc = new Calc();
            System.out.println( " "+args[0] + " = " + calc.solve(args[0].split(" ")) );
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}

// https://www.baeldung.com/java-method-reflection
