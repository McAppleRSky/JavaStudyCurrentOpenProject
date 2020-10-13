package edu.sgu.lab3.example.gson;

public class Person {
    public int id;
    public String name;
    public Person parent;

    public Person(final int id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Person(final int id, final String name, final Person parent) {
        super();
        this.id = id;
        this.name = name;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Person getParent() {
        return parent;
    }

    public void setParent(final Person parent) {
        this.parent = parent;
    }

}
