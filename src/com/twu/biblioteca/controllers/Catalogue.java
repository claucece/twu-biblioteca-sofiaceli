package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.UserCatalogueHelper;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.ListOfBooks;

import java.util.List;

public class Catalogue implements UserCatalogueHelper, ErrorPrinter {

    private Inventory inventory;

    public Catalogue(Inventory inventory) {
        this.inventory = inventory;
    }

    public String putBookInformationInColumns() {
        Column column = new Column();
        for (Book book : inventory.returnInventoryOfBooks()) {
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
        inventory.returnInventoryOfBooks().remove(book);
        return inventory.returnInventoryOfBooks();
    }

    public boolean isACheckoutBook(String title) {
        for (Book book : inventory.returnInventoryOfBooks()) {
            if (book.getSpec().getTitle().matches(title.toLowerCase())) {
                removeBookFromInventory(book);
                printSucessfulCheckout();
                return true;
            }
        }
        printUnsucessfulCheckout();
        return false;
    }

    private void addBookToInventory(Book book) {
        if (!(inventory.returnInventoryOfBooks().contains(book))) {
            inventory.returnInventoryOfBooks().add(book);
            printSucessfulReturn();
        } else {
            printError();
        }
    }

    public boolean isABookReturn(String title) {
        for (Book book : ListOfBooks.VALUES) {
            String bookToReturn = book.getSpec().getTitle();
            if (bookToReturn.matches(title.toLowerCase())) {
                addBookToInventory(book);
                return true;
            }
        }
        printUnsucessfulReturn();
        return false;
    }

    @Override
    public StringBuilder printSucessfulCheckout() {
        StringBuilder successfullCheckOut = new StringBuilder("Thank you! Enjoy the book");
        System.out.println(inStockColor + successfullCheckOut + resetStockColor);
        return successfullCheckOut;
    }

    @Override
    public StringBuilder printUnsucessfulCheckout() {
        StringBuilder error = new StringBuilder("Book not found. Please, select a book from the list.");
        System.out.println(notInStockColor + error + resetStockColor);
        return error;
    }

    @Override
    public StringBuilder printSucessfulReturn() {
        StringBuilder successfullReturn = new StringBuilder("Thank you for returning the book.");
        System.out.println(inStockColor + successfullReturn + resetStockColor);
        return successfullReturn;
    }

    @Override
    public StringBuilder printUnsucessfulReturn() {
        StringBuilder error = new StringBuilder("That is not a valid book to return.");
        System.out.println(notInStockColor + error + resetStockColor);
        return error;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("Book already in stock");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
