package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private List<Book> books;
    private Book book;
    private BookSpec bookspec;

    public Inventory() {
        books = new LinkedList<Book>();
        book = new Book(bookspec);
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book addBook(BookSpec spec) {
        books.add(book);
        return book;
    }

}
