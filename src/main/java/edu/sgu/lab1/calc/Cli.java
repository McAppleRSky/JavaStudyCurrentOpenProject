package edu.sgu.lab1.calc;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Cli {

    private static final Logger logger = Logger.getLogger(Calc.class.getName());

    private static Calc calc;
    final private static String[] msg = {"Variant 1:", " + plus; - minus; * multiply; / division;",
            "Variant 2:"," ^ degree;","Variant 3:"," P - perimeter of right triangle by cathetuses, S - square of right triangle by cathetuses;",
    "Variant 4:", " F - Fibonacci summ sequence (positive). Arguments: number iteration summ;",
    "Variant 5:", " M - mod"};

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
