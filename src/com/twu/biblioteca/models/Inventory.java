package com.twu.biblioteca.models;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private static List<Book> books;

    private Inventory() {
        books = new LinkedList<Book>();
    }

    public static Inventory valueOf() {
        return new Inventory();
    }

    public List<Book> getInventoryOfBooks() {
        if (books.isEmpty()) {
            addBook();
        }
        return books;
    }

    public List<Book> addBook() {
        for (Book book : ListOfBooks.VALUES) {
            books.add(book);
        }
        return books;
    }
}
