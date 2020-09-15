package org.example.lab1.calc;

import org.example.lab1.calc.operations.Cmd;
import org.reflections.Reflections;
import java.util.Set;

public class Cli {

    private static Calc calc = new Calc();
    static String prefixPackage = "org.example.lab1.calc.operations";
    static Reflections reflections;
    static Set<Class<? extends Cmd>> list;

    public static void main(String[] args) {
        list = new Reflections(prefixPackage).getSubTypesOf(Cmd.class);
        System.out.println(calc.solve(args));
    }
}
