package com.twu.biblioteca;

/**
 * Created by sceli on 2/22/16.
 */
public class Book {

    BookSpec spec;

    public Book(BookSpec spec) {
        this.spec = spec;
    }

    public BookSpec getSpec() {
        return spec;
    }
}
