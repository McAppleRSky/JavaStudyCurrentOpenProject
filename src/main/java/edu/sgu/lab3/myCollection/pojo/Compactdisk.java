package edu.sgu.lab3.myCollection.pojo;

public class Compactdisk {

    // Название aльбома
    private String name;

    // Исполнитель
    private String musician;

    // Количество треков
    private String tracks;

    // Длительность звучания
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

}
