package org.example.lab1.calc;

import org.example.lab1.calc.operations.Cmd;
import org.example.lab1.calc.operations.Precmd;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.Collection;
import java.util.Set;

// http://java-online.ru/java-reflection.xhtml
public class Cli {


/*    private static List<Class<?>> getAllClassesFrom(String packageName) {
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
*/

    private static Calc calc = new Calc();

    static String prefixPackage = "org.example.lab1.calc.operations";
    static Reflections reflections;
    //static Set<Class<? extends Cmd>> subTypes;
    //static Collection srcPath;
    static SubTypesScanner scanner;

    public static void main(String[] args) {

        //Set<Class<? extends org.example.lab1.calc.operations.Cmd>> list ;
//        calc.setOperationsList(list);

        //list = new Reflections(prefixPackage).getSubTypesOf(Cmd.class)
        //Reflections
        //reflections = new Reflections(prefixPackage);
        //srcPath = ClasspathHelper.forPackage(prefixPackage);

        //scanner = new SubTypesScanner();
        ConfigurationBuilder cfg = new ConfigurationBuilder()
                .setUrls(ClasspathHelper.forPackage(prefixPackage))
                .setScanners(new SubTypesScanner());
        reflections = new Reflections( //ClasspathHelper.forPackage(prefixPackage)
                                        //srcPath
                                        //, //new SubTypesScanner()
                                            //scanner);
                                        //new ConfigurationBuilder()
                                                //.setUrls(ClasspathHelper.forPackage(prefixPackage))
                                                //.setScanners(new SubTypesScanner())
                                            cfg);
        Set<Class<? extends Cmd>> verbs = reflections.getSubTypesOf(Cmd.class);

        //Set<Class<? extends org.example.lab1.calc.operations.Cmd>>
                //subTypes = reflections.getSubTypesOf(org.example.lab1.calc.operations.Cmd.class);
                                                ;

        System.out.println(calc.solve(args));
    }
}
