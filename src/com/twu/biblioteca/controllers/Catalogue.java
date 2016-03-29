package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.ListOfBooks;

import java.util.List;

public class Catalogue implements UserCatalogueHelper {

    private Inventory inventory;
    private ListOfBooks listOfBooks;
    private Column column;

    public Catalogue(Inventory inventory) {
        this.inventory = inventory;
        listOfBooks = new ListOfBooks();
        column = new Column();
    }

    public String getBookInformation() {
        for (Book book : inventory.getInventoryOfBooks()) {
            String title = book.getSpec().getTitle();
            String author = book.getSpec().getAuthor();
            String published_year = book.getSpec().getPublishedYear();
            String type = book.getSpec().getType();
            String genre = book.getSpec().getGenre();
            column.addLine(title, author, published_year, type, genre);
        }
        return column.toString();
    }

    public List<Book> removeBookFromInventory(Book book) {
        inventory.getInventoryOfBooks().remove(book);
        return inventory.getInventoryOfBooks();
    }

    public boolean checkoutBook(String title) {
        for (Book book : inventory.getInventoryOfBooks()) {
            if (book.getSpec().getTitle().matches(title.toLowerCase())) {
                removeBookFromInventory(book);
                printSucessfulCheckout();
                return true;
            }
        }
        printUnsucessfulCheckout();
        return false;
    }

    public List<Book> addBookToInventory(Book book) {
        inventory.getInventoryOfBooks().add(book);
        return inventory.getInventoryOfBooks();
    }

    public boolean returnBook(String title) {
        for (Book book : listOfBooks.VALUES) {
            if (book.getSpec().getTitle().matches(title.toLowerCase())) {
                addBookToInventory(book);
                printSucessfulReturn();
                return true;
            }
        }
        printUnsucessfulReturn();
        return false;
    }

    @Override
    public String printSucessfulCheckout() {
        String successfullCheckOut = "Thank you! Enjoy the book";
        System.out.println(successfullCheckOut);
        return successfullCheckOut;
    }

    @Override
    public String printUnsucessfulCheckout() {
        String error = "Book not found. Please, select a book from the list.";
        System.out.println(error);
        return error;
    }

    @Override
    public String printSucessfulReturn() {
        String successfullReturn = "Thank you for returning the book.";
        System.out.println(successfullReturn);
        return successfullReturn;
    }

    @Override
    public String printUnsucessfulReturn() {
        String error = "That is not a valid book to return.";
        System.out.println(error);
        return error;
    }
}
