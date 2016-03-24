package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.ListOfBooks;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

public class Catalogue {

    private Column column;

    private Inventory invet;
    private ListOfBooks listOfBooks;

    public Catalogue() {
        column = new Column();
        invet = new Inventory();
        listOfBooks = new ListOfBooks();
    }

    // this is wrong!!! UPDATE = not wrong, just using same list every time.
    // UPDATE == SOLVED!
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

    public Book checkoutBook(String id) {
        for (Book book : invet.getInventoryOfBooks()) {
            if (book.getId().matches(id)) {
                System.out.println(book.getSpec().getTitle());
                removeBookFromInventory(book);
                return book;
            }
        }
        String error = "Book not found. Please, select a book from the list";
        System.out.println(error);
        return null;
    }

    public List<Book> removeBookFromInventory(Book book) {
        invet.getInventoryOfBooks().remove(book);
        return invet.getInventoryOfBooks();
    }

    public Book returnBookToInventory(String id) {
        for (Book book : listOfBooks.VALUES) {
            System.out.println(book.getId());
            if (book.getId().matches(id) && !(invet.getInventoryOfBooks().contains(book))) {
                System.out.println(book.getSpec().getTitle());
                addBookToInventory(book);
                return book;
            }
        }
        String error = "That book is not available.";
        System.out.println(error);
        return null;
    }

    public List<Book> addBookToInventory(Book book) {
        System.out.println(invet.getInventoryOfBooks().size() + "la");
        invet.getInventoryOfBooks().add(book);
        return invet.getInventoryOfBooks();
    }

    //public Book returnBook(String id) {
    //    for (Book book : invet.getInventoryOfBooks()) {
    //        if (book.getId().matches(id)) {
    //            System.out.println(book.getSpec().getTitle());
    //            removeBookFromInventory(book);
    //            return book;
    //        }
    //    }
    //    String error = "Book not found. Please, select a book from the list";
    //    System.out.println(error);
    //    return null;
    //}

    //public Book getBook(String id) {
    //    for (Book book : books) {
    //        if (book.getId().equals(id)) {
    //            return book;
//}
//        }
//        return null;
//    }
}
