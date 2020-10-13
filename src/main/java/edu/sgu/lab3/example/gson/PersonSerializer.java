package edu.sgu.lab3.example.gson;

import com.google.gson.*;
import edu.sgu.lab3.example.gson.Person;

import java.lang.reflect.Type;


public //static
            class PersonSerializer implements JsonSerializer<Person> {
    public JsonElement serialize(final Person person, final Type type, final JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("id", new JsonPrimitive(person.getId()));
        result.add("name", new JsonPrimitive(person.getName()));
        Person parent = person.getParent();
        if (parent != null) {
            result.add("parent", new JsonPrimitive(parent.getId()));
        }
        return result;
    }

}
