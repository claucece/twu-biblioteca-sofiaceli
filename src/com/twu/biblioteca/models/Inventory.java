package com.twu.biblioteca.models;

import com.twu.biblioteca.controllers.Column;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private static List<Book> books;
    private Book book;
    private BookSpec bookspec;
    private String id;
    private Column column;

    public Inventory() {
        books = new LinkedList<Book>();
        book = new Book(id, bookspec);
        column = new Column();
    }

    public List<Book> getInventoryOfBooks() {
        if (books.isEmpty()) {
            addBook();
        }
        return books;
    }

    public Book addBook() {
        for (Book book : ListOfBooks.VALUES) {
            books.add(book);
        }
        return book;
    }

    public Book getBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    //public List<Book> search(BookSpec searchSpec) {
    //    List<Book> matchingBooks = new LinkedList<Book>();
    //    for (Book i : books) { //for-each loop. Looks better.
    //        Book book = i;
    //        if (book.getSpec().matches(searchSpec))
    //            matchingBooks.add(book);
    //    }
    //    return matchingBooks;
    // }


}
