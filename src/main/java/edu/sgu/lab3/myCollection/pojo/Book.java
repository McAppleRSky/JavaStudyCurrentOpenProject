package edu.sgu.lab3.myCollection.pojo;

public class Book {

    // Автор
    private String author;

    // Год издания
    private String year;

    // Количество страниц
    private String pages;

    // Издательство
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

}
