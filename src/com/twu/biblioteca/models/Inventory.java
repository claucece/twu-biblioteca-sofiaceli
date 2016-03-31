package com.twu.biblioteca.models;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private static List<Book> books;

    private Inventory() {
        books = new LinkedList<Book>(ListOfBooks.VALUES);
    }

    public static Inventory valueOf() {
        return new Inventory();
    }

    public List<Book> getListOfBooks() {
        return books;
    }

    public List<Book> returnInventoryOfBooks() {
        if (Collections.disjoint(getListOfBooks(), ListOfBooks.VALUES) && !(getListOfBooks().isEmpty())) {
            addBook();
        } else if (getListOfBooks().isEmpty()) {
            String error = "No available books!";
            System.out.println(error);
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
