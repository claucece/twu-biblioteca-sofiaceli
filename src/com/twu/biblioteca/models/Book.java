package com.twu.biblioteca.models;

public class Book {

    private static String id;
    private BookSpec spec;

    public Book(BookSpec spec) {
        this.spec = spec;
    }

    public String getId() {
        return id;
    }

    public BookSpec getSpec() {
        return spec;
    }
}
