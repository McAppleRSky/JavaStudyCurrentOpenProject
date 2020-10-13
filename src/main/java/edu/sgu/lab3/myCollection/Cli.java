package edu.sgu.lab3.myCollection;

import edu.sgu.lab1.calc.Calc;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Cli {

    private static final Logger logger;
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        logger = Logger.getLogger(Cli.class.getName());
        logger.setLevel(Level.WARNING);
    }

    static HashMap<Character, String> params;

    final private static Iterator<String>
            inviteMsgIter = Arrays.asList("Collection stady: variant 1").iterator(),
            helpMsgIter = Arrays.asList("Help:", " -i filename;", " -o filename;", " -h for help.").iterator();

    private static String inputFilename, outputFilename;

    public static void main(String[] args) {
        while(inviteMsgIter.hasNext())System.out.println(inviteMsgIter.next());
        params = getParams("-i name -h");
        if(params.containsKey('h'))
            while(helpMsgIter.hasNext()) System.out.println(helpMsgIter.next());
        try {
            if(params.containsKey('i')) inputFilename=params.get('i');
            else throw new Exception("Need inputfile");
            if(params.containsKey('o')) outputFilename=params.get('o');
            else throw new Exception("Need outputfile");
        } catch (Exception e) {
            e.printStackTrace();
        }




/*
            case
            try {
            if (args[0].split(" ").length==1) logger.warning("Receive one argument : " + args[0].split(" ")[0]);
            calc = new Calc();
            String[] results= calc.solve(args[0].split(" "));
            for (String result:results){
                switch (results.length){
                    case 0:
                        System.out.println("calc no return result");
                        break;
                    case 1:
                        System.out.println(" " + args[0] + " = " + result);
                        break;
                    default:
                        System.out.println(result);
                        break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
*/
    }

    static HashMap<Character,String> getParams(String arg){
        HashMap<Character,String> params = new HashMap();
        String[] paramsStr = arg.split("-");
        if(paramsStr.length>0){
            for(String paramStr:paramsStr) {
                String[] curKeyVal = paramStr.split(" ");
                String key, val;
                if(curKeyVal.length>0){
                    key = curKeyVal[0];
                    if(key.length()==1)
                        switch (curKeyVal.length){
                            case 1: params.put(key.charAt(0), "");
                                break;
                            case 2: val = curKeyVal[1];
                                params.put(key.charAt(0), val);
                                break;
                        }
                }
            }
        }
        return params;
    }

}
