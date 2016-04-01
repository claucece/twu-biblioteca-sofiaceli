package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.ErrorPrinter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Inventory implements ErrorPrinter {

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

    private boolean isListEqualToInventory() {
        return Collections.disjoint(getListOfBooks(), ListOfBooks.VALUES) && !(getListOfBooks().isEmpty());
    }

    public List<Book> returnInventoryOfBooks() {
        if (isListEqualToInventory()) {
            addBook();
        } else if (getListOfBooks().isEmpty()) {
            printError();
        }
        return books;
    }

    private List<Book> addBook() {
        for (Book book : ListOfBooks.VALUES) {
            books.add(book);
        }
        return books;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("No available books!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
