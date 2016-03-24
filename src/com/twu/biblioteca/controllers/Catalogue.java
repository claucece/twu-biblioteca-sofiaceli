package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.Book;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Catalogue {

    private Column column;

    public Catalogue() {
        column = new Column();
    }

    // this is wrong!!! UPDATE = not wrong, just using same list every time.
    public String getBookInformation(Inventory inventory) {
        String title = null, author = null, published_year = null, type = null;
        for (Book book : inventory.getInventoryOfBooks()) {
            title = book.getSpec().getTitle();
            author = book.getSpec().getAuthor();
            published_year = book.getSpec().getPublishedYear();
            type = book.getSpec().getType();
            column.addLine(title, author, published_year, type);
        }
        System.out.println(column);
        return "lo";
    }

    public String checkoutBook(String id) {
        //for (Book i : books) {
            //        Book book = i;
            //        if (book.getSpec().matches(searchSpec))
            //            matchingBooks.add(book);
            //    }
            //    return matchingBooks;
        return "blea";
    }

    //public Book getBook(String id) {
    //    for (Book book : books) {
    //        if (book.getId().equals(id)) {
    //            return book;
//}
//        }
//        return null;
//    }
}
