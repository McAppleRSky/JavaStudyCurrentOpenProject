package edu.sgu.lab1.calc;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cli {

    private static final Logger logger;
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        logger = Logger.getLogger(Cli.class.getName());
        logger.setLevel(Level.WARNING);
    }

    private static Calc calc;
    final private static String[] msg = {"Variant 1:", " + plus; - minus; * multiply; / division;",
            "Variant 2:"," ^ degree;","Variant 3:"," P - perimeter of right triangle by cathetuses, S - square of right triangle by cathetuses;",
    "Variant 4:", " F - Fibonacci summ sequence (positive). Arguments: number iteration summ;",
    "Variant 5:", " M - mod", "Variant 7:", " N - NOD m, n;", "Variant 8: C - Round by radius; R - Round area by radius;",
    "Variant 9: q - area of square; p - perimeter of square;",
    "Variant 10:", "Variant 11: d - positiv degree of two;",
            "Variant 12: c - Fahrenheit to Celsius; f - Celsius to Fahrenheit;",
    "Variant 13: Q - Quadratic;", "Variant 14: d - Divisions;",
    "Variant 15: linear equation kX+b=0."};

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("?! Need input parameters (type trough delimiter whitespace. Mask: digit, operation, digit). ");
            for (String str : msg) System.out.println(str);
        }
        else try {
            if (args[0].split(" ").length==1) logger.warning("Receive one argument : " + args[0].split(" ")[0]);
            calc = new Calc();
            System.out.println( " " + args[0] + " = " + calc.solve(args[0].split(" ")) );
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
