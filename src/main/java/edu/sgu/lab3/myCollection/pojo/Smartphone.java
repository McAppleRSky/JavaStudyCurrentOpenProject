package edu.sgu.lab3.myCollection.pojo;

public class Smartphone {

    // Модель
    private String model;

    // Размер экрана
    private String size;

    // Тип экрана
    private String screen;

    // Объем встроенной флэш-памяти
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

}
