package edu.sgu.lab3.myCollection.pojo;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class Compactdisk implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * Название ольбома. Mast not a null
     * @serial
     * */
    private String name;

    /*
     * Исполнитель. Mast not a null
     * @serial
     * */
    private String musician;

    /*
     * Количество треков. Mast not a null
     * @serial
     * */
    private String tracks;

    /*
     * Длительность звучания. Mast not a null
     * @serial
     * */
    private String length;

    public Compactdisk(String name, String musician, String tracks, String length) {
        this.name = name;
        this.musician = musician;
        this.tracks = tracks;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusician() {
        return musician;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public String getTracks() {
        return tracks;
    }

    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Need stream data");
    }
}
