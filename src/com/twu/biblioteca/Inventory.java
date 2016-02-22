package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private List<Book> books;

    public Inventory() {
        books = new LinkedList<Book>();
    }

    public void addBook(
            BookSpec spec) {
        Book book = new Book(spec);
        books.add(book);
    }

}
