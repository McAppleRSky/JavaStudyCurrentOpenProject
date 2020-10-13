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
        printMsg(inviteMsgIter);
        params = getParams("-i iname -o oname -h");
        if(params.containsKey('h'))
            printMsg(helpMsgIter);
        try {
            if(params.containsKey('i')) inputFilename=params.get('i');
            else throw new Exception("Need inputfile");
            if(params.containsKey('o')) outputFilename=params.get('o');
            else throw new Exception("Need outputfile");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void printMsg(Iterator<String> msgIter){
        while(msgIter.hasNext())System.out.println(msgIter.next());
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
