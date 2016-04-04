package com.twu.biblioteca.models;

public abstract class AbstractElementSpec implements ElementSpec{

    private String title;
    private String author;
    private String publishedYear;

    public AbstractElementSpec(String title, String author, String publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title.toLowerCase();
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishedYear() {
        return publishedYear;
    }

}
