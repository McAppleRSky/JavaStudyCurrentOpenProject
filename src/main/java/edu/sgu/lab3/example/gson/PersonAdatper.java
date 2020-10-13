package edu.sgu.lab3.example.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import edu.sgu.lab3.example.gson.annotated.Person;

import java.io.IOException;

public class PersonAdatper extends TypeAdapter<Person> {

    @Override
    public void write(JsonWriter writer, Person value) throws IOException {
        writer.beginObject();

//        writer.name("id").value(value.getId());
//        writer.name("name").value(value.getName());
        Person parent = null;
        //parent = value.getParent();
        if (parent != null) {
//            writer.name("parent").value(parent.getId());
        }
        writer.endObject();
    }

    @Override
    public Person read(JsonReader jsonReader) throws IOException {
        return null;
    }

}
