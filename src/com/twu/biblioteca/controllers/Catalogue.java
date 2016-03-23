package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.Book;

public class Catalogue {

    private Column column;

    public Catalogue() {
        column = new Column();
    }

    public String getBookInformation(Inventory inventory) {
        for (Book book : inventory.getInventoryOfBooks()) {
            String title = book.getSpec().getTitle();
            String author = book.getSpec().getAuthor();
            String published_year = book.getSpec().getPublishedYear();
            String type = book.getSpec().getType();
            column.addLine(title, author, published_year, type);
        }
        System.out.println(column.toString());
        return column.toString();
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
