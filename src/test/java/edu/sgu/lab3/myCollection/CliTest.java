package edu.sgu.lab3.myCollection;

import edu.sgu.lab3.myCollection.pojo.Book;
import org.junit.Test;
import org.w3c.dom.css.Counter;

import java.io.*;

import static org.junit.Assert.*;

public class CliTest extends Cli {

    String[][] expected = new String[][]{
/* 1*/  {"Book",       "1", "dec", "HashSet",   "HashMap"},
/* 2*/  {"Car",        "2", "inc", "TreeSet",   "TreeMap"},
/* 3*/  {"Compactdisk","3", "dec", "LinkedHashSet","LinkedHashMap"},
/* 4*/  {"Notebook",   "4", "inc", "HashSet",   "HashMap"},
/* 5*/  {"Smartphone", "1", "dec", "TreeSet",   "TreeMap"},
/* 6*/  {"Book",       "2", "inc", "LinkedHashSet","LinkedHashMap"},
/* 7*/  {"Car",        "3", "dec", "HashSet",   "HashMap"},
/* 8*/  {"Compactdisk","4", "inc", "TreeSet",   "TreeMap"},
/* 9*/  {"Notebook",   "1", "dec", "LinkedHashSet","LinkedHashMap"},
/*10*/  {"Smartphone", "2", "inc", "HashSet",   "HashMap"},
/*11*/  {"Book",       "3", "dec", "TreeSet",   "TreeMap"},
/*12*/  {"Car",        "4", "inc", "LinkedHashSet","LinkedHashMap"},
/*13*/  {"Compactdisk","1", "dec", "HashSet",   "HashMap"},
/*14*/  {"Notebook",   "2", "inc", "TreeSet",   "TreeMap"},
/*15*/  {"Smartphone", "3", "dec", "LinkedHashSet","LinkedHashMap"}
    };

    @Test
    public void testParams() {
        params = getParams("-i iname -o oname -h");
        assertFalse(params.isEmpty());
        assertEquals(3, params.size());
        assertTrue(params.containsKey('h'));
        assertTrue(params.containsKey('i'));
        assertTrue(params.get('i').equals("iname"));
        assertTrue(params.get('o').equals("oname"));
    }


}
