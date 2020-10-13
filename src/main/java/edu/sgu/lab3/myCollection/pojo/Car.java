package edu.sgu.lab3.myCollection.pojo;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * Марка. Mast not a null
     * @serial
     * */
    private String brand;

    /*
     * Год выпуска. Mast not a null
     * @serial
     * */
    private String year;

    /*
     * Объем двигателя. Mast not a null
     * @serial
     * */
    private String volume;

    /*
     * Максимальная скорость. Mast not a null
     * @serial
     * */
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

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Need stream data");
    }
}
