package edu.sgu.lab1.calc;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class Cli {

    private static final Logger logger = Logger.getLogger(Calc.class.getName());

    private static Calc calc;

    public static void main(String[] args) {

        try {
            calc = new Calc();
            System.out.println( calc.solve(args) );
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

// https://www.baeldung.com/java-method-reflection
