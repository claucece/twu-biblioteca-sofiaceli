package com.twu.biblioteca.helpers;

public abstract class AbstractElement implements Element {

    private String title;
    private String author;
    private String publishedYear;
    private String rating;

    public AbstractElement(String title, String author, String publishedYear, String rating) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.rating = rating;
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

    public String getRating() {
        return rating;
    }

}
