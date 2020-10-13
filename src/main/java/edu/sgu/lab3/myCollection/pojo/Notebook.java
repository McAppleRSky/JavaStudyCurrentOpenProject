package edu.sgu.lab3.myCollection.pojo;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class Notebook implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * Идентификатор модели. Mast not a null
     * @serial
     * */
    private String vendor;

    /*
     * Производитель процессора. Mast not a null
     * @serial
     * */
    private String cpu;

    /*
     * Тактовая частота процессора. Mast not a null
     * @serial
     * */
    private String clock;

    /*
     * Объем ОЗУ. Mast not a null
     * @serial
     * */
    private String memory;

    public Notebook(String vendor, String cpu, String clock, String memory) {
        this.vendor = vendor;
        this.cpu = cpu;
        this.clock = clock;
        this.memory = memory;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getClock() {
        return clock;
    }

    public void setClock(String clock) {
        this.clock = clock;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Need stream data");
    }
}
