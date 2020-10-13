package edu.sgu.lab3.example;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class SimplePojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private int count;

    public SimplePojo(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Need stream data");
    }
}
