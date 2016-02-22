package com.twu.biblioteca;

public class Book {

    BookSpec spec;

    public Book(BookSpec spec) {
        this.spec = spec;
    }

    public BookSpec getSpec() {
        return spec;
    }
}
