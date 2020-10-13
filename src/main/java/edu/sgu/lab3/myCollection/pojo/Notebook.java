package edu.sgu.lab3.myCollection.pojo;


public class Notebook {

    // Идентификатор модели
    private String vendor;

    // Производитель процессора
    private String cpu;

    // Тактовая частота процессора
    private String clock;

    // Объем ОЗУ
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

}
