package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.UserCatalogueHelper;
import com.twu.biblioteca.models.BookModel.BookInventory;
import com.twu.biblioteca.models.ListOfElements;

public class Catalogue implements UserCatalogueHelper, ErrorPrinter {

    private BookInventory bookInventory;

    public Catalogue(BookInventory bookInventory) {
        this.bookInventory = bookInventory;
    }

    public String putBookInformationInColumns() {
        Column column = new Column();
        for (Element book : bookInventory.returnInventoryOfElements()) {
            String title = book.getSpec().getTitle();
            String author = book.getSpec().getAuthor();
            String published_year = book.getSpec().getPublishedYear();
            String type = book.getSpec().getType();
            String genre = book.getSpec().getGenre();
            column.addLine(title, author, published_year, type, genre);
        }
        return column.toString();
    }

    public boolean removeBookFromInventory(Element book) {
        return bookInventory.returnInventoryOfElements().remove(book);
    }

    public boolean isACheckoutBook(String title) {
        for (Element book : bookInventory.returnInventoryOfElements()) {
            if (book.getSpec().getTitle().matches(title.toLowerCase())) {
                removeBookFromInventory(book);
                printSucessfulCheckout();
                return true;
            } else if (title.equals("quit")) {
                return true;
            }
        }
        printUnsucessfulCheckout();
        return false;
    }

    private void addBookToInventory(Element book) {
        if (!(bookInventory.returnInventoryOfElements().contains(book))) {
            bookInventory.returnInventoryOfElements().add(book);
            printSucessfulReturn();
        } else {
            printError();
        }
    }

    public boolean isABookReturn(String title) {
        for (Element book : ListOfElements.VALUES) {
                String bookToReturn = book.getSpec().getTitle();
                if (bookToReturn.matches(title.toLowerCase())) {
                    addBookToInventory(book);
                    return true;
                } else if (title.equals("quit")) {
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
