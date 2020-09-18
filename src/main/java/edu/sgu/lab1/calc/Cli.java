package edu.sgu.lab1.calc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

public class Cli {

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
