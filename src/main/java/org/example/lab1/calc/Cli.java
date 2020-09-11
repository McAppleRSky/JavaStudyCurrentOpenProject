package org.example.lab1.calc;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cli {

    static String operationPckage = "org.example.lab1.calc.operations";

    private static List<Class<?>> getAllClassesFrom(String packageName) {
        return new Reflections(packageName, new SubTypesScanner(false))
                .getAllTypes()
                .stream()
                .map(name -> {
                    try {
                        return Class.forName(name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static Calc calc = new Calc();

    public static void main(String[] args) {

        calc.setOperationsList(getAllClassesFrom(operationPckage));

        System.out.println(calc.solve(args));
    }
}
