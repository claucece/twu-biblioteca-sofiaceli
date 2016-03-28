package com.twu.biblioteca.models;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private static List<Book> books;

    public Inventory() {
        books = new LinkedList<Book>();
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
