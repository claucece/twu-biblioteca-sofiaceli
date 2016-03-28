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

    // this is wrong!!! UPDATE = not wrong, just using same list every time.
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

    public Book checkoutBook(String title) {
        for (Book book : inventory.getInventoryOfBooks()) {
            if (book.getSpec().getTitle().matches(title)) {
                //System.out.println(book.getSpec().getTitle());
                removeBookFromInventory(book);
                return book;
            }
        }
        String error = "Book not found. Please, select a book from the list";
        System.out.println(error);
        return null;
    }

    public List<Book> addBookToInventory(Book book) {
        System.out.println(inventory.getInventoryOfBooks().size() + "la");
        inventory.getInventoryOfBooks().add(book);
        return inventory.getInventoryOfBooks();
    }

    public Book returnBook(String title) {
        for (Book book : listOfBooks.VALUES) {
            //System.out.println(book.getSpec().getAuthor());
            if (book.getSpec().getTitle().matches(title)) {
                //System.out.println(book.getSpec().getTitle());
                addBookToInventory(book);
                return book;
            }
        }
        String error = "That book is not available.";
        System.out.println(error);
        return null;
    }

}
