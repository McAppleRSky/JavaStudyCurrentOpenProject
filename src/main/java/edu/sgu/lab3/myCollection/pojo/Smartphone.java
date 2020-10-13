package edu.sgu.lab3.myCollection.pojo;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class Smartphone implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * Модель. Mast not a null
     * @serial
     * */
    private String model;

    /*
     * Размер экрана. Mast not a null
     * @serial
     * */
    private String size;

    /*
     * Тип экрана. Mast not a null
     * @serial
     * */
    private String screen;

    /*
     * Объем встроенной флэш-памяти. Mast not a null
     * @serial
     * */
    private String flash;

    public Smartphone(String model, String size, String screen, String flash) {
        this.model = model;
        this.size = size;
        this.screen = screen;
        this.flash = flash;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getFlash() {
        return flash;
    }

    public void setFlash(String flash) {
        this.flash = flash;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Need stream data");
    }
}
