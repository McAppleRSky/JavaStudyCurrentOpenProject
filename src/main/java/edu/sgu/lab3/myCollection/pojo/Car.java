package edu.sgu.lab3.myCollection.pojo;

public class Car{

    // Марка
    private String brand;

    // Год выпуска
    private String year;

    // Объем двигателя
    private String volume;

    // Максимальная скорость
    private String speed;

    public Car(String brand, String year, String volume, String speed) {
        this.brand = brand;
        this.year = year;
        this.volume = volume;
        this.speed = speed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

}
