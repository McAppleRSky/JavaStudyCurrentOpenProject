package edu.sgu.lab3.example;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.sgu.lab3.example.gson.*;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.Assert.*;

public class SerialPojoTest {

    @Test
    public void testJavaIoSerial() {
        String pathname = "tmp/pojo.ser";
        ObjectOutputStream objectOutputStream = null;
        FileOutputStream fileOutputStream = null;
        SimplePojo pojo = new SimplePojo("august", 42);
        try {
            fileOutputStream = new FileOutputStream(pathname, true);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(pojo);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        File f = new File(pathname);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(f);
            objectInputStream = new ObjectInputStream(fileInputStream);

            assertNotEquals(pojo, objectInputStream.readObject());

            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGson2Json() {
        Person person = new Person(1, "Joe", new Person(2, "Mike"));
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Person.class, new PersonSerializer())
                .create();
        //&#34; &quot;
        assertEquals(gson.toJson(person), "{\"id\":1,\"name\":\"Joe\",\"parent\":2}");

        String pathname = "tmp/person.json";
        FileOutputStream fileOutputStream = null;
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream(pathname, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printStream.print(gson.toJson(person));
    }

    @Test
    @Ignore
    public void testBag() {
        Gson gson = null;
        Person person = null;
        String jsonString = "";
        String pathname = "tmp/person.json";

        TextfileReader jsonReader = new TextfileReader();
        Map rootObject;
        try {
            rootObject = (Map) new Gson()
                    .fromJson(jsonReader.readFile(
                            pathname, StandardCharsets.UTF_8),
                            Person.class
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }


        gson = new GsonBuilder().create();
        try {
            jsonString = jsonReader.readFile(pathname, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        person = gson.fromJson(jsonString, Person.class);
        System.out.println(person.toString());
    }

    @Test
    public void testPrimitivesGson() {
        // Serialization
        Gson gson = new Gson();
        assertEquals("1", gson.toJson((int) Integer.valueOf(1)));
        assertEquals("\"abcd\"", gson.toJson("abcd"));
        assertEquals("10", gson.toJson(Long.valueOf(10)));
        int[] values = {1};
        assertEquals("[1]", gson.toJson(values));

        // Deserialization
        assertEquals((int) Integer.valueOf(1), (int) gson.fromJson("1", int.class));
        assertEquals(Integer.valueOf(1), gson.fromJson("1", Integer.class));
        assertEquals(Long.valueOf(1), gson.fromJson("1", Long.class));
        assertEquals(false, gson.fromJson("false", Boolean.class));
        assertEquals("abc", gson.fromJson("\"abc\"", String.class));
        String[] strings = new String[1];
        strings[0] = "abc";
        assertArrayEquals(strings, gson.fromJson("[\"abc\"]", String[].class));
    }

    @Test
    public void testBagOfPrimitivesGson() {
        BagOfPrimitives obj = new BagOfPrimitives();
        String json = new Gson().toJson(obj);

        // Serialization
        assertEquals("{\"value1\":1,\"value2\":\"abc\"}", json);

        // Deserialization
        assertNotEquals(obj, new Gson().fromJson(json, BagOfPrimitives.class));
    }

    @Test
    public void testCollectionGson() {
        String json;
        Gson gson = new Gson();
        Integer[] values = {1, 2, 3, 4, 5};
        Collection<Integer> ints = Arrays.asList(values);

        // Serialization
        json = gson.toJson(ints);
        assertEquals("[1,2,3,4,5]", json);

        // Deserialization
        Type collectionType
                = new TypeToken<Collection<Integer>>() {
        }.getType();
        assertEquals(ints, gson.fromJson(json, collectionType));
    }

    @Test
    public void testGenericGson() {
        Gson gson = new Gson();
        Foo<Bar> foo = new Foo<Bar>();
        String json = gson.toJson(foo);
        assertEquals("{}",json);
        assertNotEquals(foo, gson.fromJson(json, foo.getClass()));

        Type fooType = new TypeToken<Foo<Bar>>(){}.getType();
        json=gson.toJson(foo, fooType);
        assertEquals("{}",json);
        assertNotEquals(foo,gson.fromJson(json, fooType));
    }
/*
https://sites.google.com/site/gson/gson-user-guide#TOC-Object-Examples
java.net.URL to match it with strings like "http://code.google.com/p/google-gson/".
java.net.URI to match it with strings like "/p/google-gson/".
*/
    @Test
    public void testEventGson() {
        String json;
        Gson gson = new Gson();
        Collection collection = new ArrayList();
        collection.add("hello");
        collection.add(5);
        collection.add(new Event("GREETINGS", "guest"));
        // Serialization
        json = gson.toJson(collection);
        assertEquals("[\"hello\",5,{\"name\":\"GREETINGS\",\"source\":\"guest\"}]", json);
    }

}
