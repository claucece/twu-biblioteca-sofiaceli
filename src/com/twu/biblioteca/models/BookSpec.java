package com.twu.biblioteca.models;

public class BookSpec {

    private String title;
    private String author;
    private String publishedYear;

    public BookSpec(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }
}
