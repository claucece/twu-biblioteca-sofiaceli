package com.twu.biblioteca;

import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private List<Book> books;
    private Book book;
    private BookSpec bookspec;
    private String id;
    private Columns column;

    public Inventory() {
        books = new LinkedList<Book>();
        book = new Book(id, bookspec);
        column = new Columns();
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    public String getBookInformation() {
        String toPrint = null;
        for (Book book : books) {
            String title = book.getSpec().getTitle();
            String author = book.getSpec().getAuthor();
            String published_year = book.getSpec().getPublishedYear();
            column.addLine(title, author, published_year);
            toPrint = column.toString();
        }
        System.out.println(toPrint);
        return toPrint;
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
