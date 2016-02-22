package com.twu.biblioteca;

public class Book {

    private String id;
    private BookSpec spec;

    public Book(String id, BookSpec spec) {
        this.id = id;
        this.spec = spec;
    }

    public String getId() {
        return id;
    }

    public Book(BookSpec spec) {
        this.spec = spec;
    }

    public BookSpec getSpec() {
        return spec;
    }
}
