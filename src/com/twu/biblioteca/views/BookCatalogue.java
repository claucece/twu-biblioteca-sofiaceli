package com.twu.biblioteca.views;

import com.twu.biblioteca.Helpers.ErrorPrinter;
import com.twu.biblioteca.Helpers.Separator;
import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.models.ColorInventory;
import com.twu.biblioteca.models.Inventory;

public class BookCatalogue implements InputAsker, ErrorPrinter, Separator {

    private Catalogue catalogue;
    private Column column;

    public BookCatalogue() {
        Inventory inventory = Inventory.valueOf();
        catalogue = new Catalogue(inventory);
        column = new Column();
    }

    public String returnCatalogue() {
        System.out.println(catalogue.getBookInformation());
        return catalogue.getBookInformation();
    }

    public String printBookCatalogueMenu() {
        returnCatalogue();
        String color = ColorInventory.getColor("INVERT");
        String option1 = "--> Checkout Book  ";
        String option2 = "--> Return Book  ";
        String option3 = "--> Return To Main Menu  ";
        column.addLine(option1, option2, option3);
        String toBookMenu = column.toString();
        System.out.println(color + toBookMenu + resetColor);
        return toBookMenu;
    }

    private String checkIfValidCheckOut() {
        System.out.println("Please, write the title of the book you want to checkout");
        String titleToCheckout = ask();
        String result = (catalogue.checkoutBook(titleToCheckout)) ? printSeparator() : checkIfValidCheckOut();
        return result;
    }

    private String checkIfValidReturn() {
        System.out.println("Please, write the title of the book you want to return");
        String titleToReturn = ask();
        String result = (catalogue.returnBook(titleToReturn)) ? printSeparator() : checkIfValidReturn();
        return result;
    }

    public String defineBookMenuOutcome() {
        System.out.println("Please, select a choice from the menu above:");
        String input = ask();
        if (input.equals("checkout book")) {
            return checkIfValidCheckOut();
        } else if (input.equals("return book")) {
            return checkIfValidReturn();
        } else if (input.equals("main menu")) {
            return printSeparator();
        }
        printError();
        return defineBookMenuOutcome();
    }

    @Override
    public String ask() {
        return scanner.nextLine().toLowerCase();
    }

    @Override
    public String printError() {
        String error = "Invalid Option. Please, select a valid option!";
        System.out.println(error);
        return error;
    }

    @Override
    public String printSeparator() {
        String breakLine = "===================================================";
        String information = "Returning to main menu......";
        System.out.println(color + breakLine + resetColor);
        printer.slowPrint(information, 50);
        return information;
    }
}
