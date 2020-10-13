package edu.sgu.lab3.example.gson.annotated;

import com.google.gson.annotations.JsonAdapter;
import edu.sgu.lab3.example.gson.PersonAdatper;

@JsonAdapter(PersonAdatper.class)
public class Person {
    public int id;
    public String name;
    public Person parent;
}
