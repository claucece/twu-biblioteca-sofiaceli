package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.models.ColorInventory;
import com.twu.biblioteca.models.Inventory;

public class BookCatalogue implements InputAsker, ErrorPrinter, Separator {

    private Catalogue catalogue;
    private Inventory inventory;
    private Column column;

    public BookCatalogue() {
        inventory = inventory.valueOf();
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

    public String checkIfValidCheckOut() {
        System.out.println("Please, write the title of the book you want to checkout");
        String titleToCheckout = ask();
        if (catalogue.checkoutBook(titleToCheckout) == true) {
            return printSeparator();
        } else {
            return checkIfValidCheckOut();
        }
    }

    public String checkIfValidReturn() {
        System.out.println("Please, write the title of the book you want to return");
        String titleToReturn = ask();
        if (catalogue.returnBook(titleToReturn) == true) {
            return printSeparator();
        } else {
            return checkIfValidReturn();
        }
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
        String input = scanner.nextLine().toLowerCase();
        return input;
    }

    @Override
    public String printError() {
        String error = "Invalid Option. Please, select a valid option!";
        System.out.println(error);
        return error;
    }

    @Override
    public String printSeparator() {
        String color = ColorInventory.getColor("CYAN");
        String breakLine = "===================================================";
        String information = "Returning to main menu......";
        System.out.println(color + breakLine + resetColor);
        printer.slowPrint(information, 50);
        return information;
    }
}
