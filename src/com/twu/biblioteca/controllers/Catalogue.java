package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.ListOfBooks;

import java.util.List;

public class Catalogue {

    private Inventory inventory;
    private ListOfBooks listOfBooks;
    private Column column;

    public Catalogue(Inventory inventory) {
        this.inventory = inventory;
        listOfBooks = new ListOfBooks();
        column = new Column();
    }

    // UPDATE == SOLVED!
    public String getBookInformation() {
        for (Book book : inventory.getInventoryOfBooks()) {
            String title = book.getSpec().getTitle();
            String author = book.getSpec().getAuthor();
            String published_year = book.getSpec().getPublishedYear();
            String type = book.getSpec().getType();
            column.addLine(title, author, published_year, type);
        }
        return column.toString();
    }

    public List<Book> removeBookFromInventory(Book book) {
        inventory.getInventoryOfBooks().remove(book);
        return inventory.getInventoryOfBooks();
    }

    public String checkoutBook(String title) {
        for (Book book : inventory.getInventoryOfBooks()) {
            if (book.getSpec().getTitle().matches(title.toLowerCase())) {
                removeBookFromInventory(book);
                String successfullCheckOut = "Thank you! Enjoy the book";
                System.out.println(successfullCheckOut);
                return successfullCheckOut;
            }
        }
        String error = "Book not found. Please, select a book from the list";
        System.out.println(error);
        return error;
    }

    public List<Book> addBookToInventory(Book book) {
        inventory.getInventoryOfBooks().add(book);
        return inventory.getInventoryOfBooks();
    }

    public String returnBook(String title) {
        for (Book book : listOfBooks.VALUES) {
            if (book.getSpec().getTitle().matches(title.toLowerCase())) {
                addBookToInventory(book);
                String successfullReturn = "Thank you for returning the book.";
                System.out.println(successfullReturn);
                return successfullReturn;
            }
        }
        String error = "That is not a valid book to return.";
        System.out.println(error);
        return error;
    }

}
