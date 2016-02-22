package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private List<Book> books;
    private Book book;
    private BookSpec bookspec;
    private String id;

    public Inventory() {
        books = new LinkedList<Book>();
        book = new Book(id, bookspec);
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> addBook(Book book) {
        books.add(book);
        return books;
    }

    public List<Book> getAllBooks() {
        for (Book book : books) {
            System.out.println(book.getSpec().getTitle() + " " + book.getSpec().getAuthor() + " " + book.getSpec().getPublishedYear());
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
