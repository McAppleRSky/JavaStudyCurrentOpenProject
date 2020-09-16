package edu.sgu.lab1.calc;

import edu.sgu.lab1.calc.operations.Operation;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

public class Cli {

    private static Calc calc = new Calc();
    //private static OparationsBuilder oparationsBuilder = new OparationsBuilder("");

    public static void main(String[] args) {

        System.out.println( calc.solve(args) );
    }
}

// https://www.baeldung.com/java-method-reflection
