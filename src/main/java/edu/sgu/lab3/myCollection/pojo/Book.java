package edu.sgu.lab3.myCollection.pojo;

import java.io.InvalidObjectException;
import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    /*
     * Автор. Mast not a null
     * @serial
     * */
    private String author;

    /*
     * Год издания. Mast not a null
     * @serial
     * */
    private String year;

    /*
     * Количество страниц. Mast not a null
     * @serial
     * */
    private String pages;

    /*
     * Издательство. Mast not a null
     * @serial
     * */
    private String publisher;

    public Book(String author, String date, String pages, String publisher) {
        this.author = author;
        this.year = date;
        this.pages = pages;
        this.publisher = publisher;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Need stream data");
    }
}
