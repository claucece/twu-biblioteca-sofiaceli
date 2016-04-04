package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.models.ColorModel.ColorList;
import com.twu.biblioteca.models.Inventory;

public class BookCatalogue implements InputAsker, ErrorPrinter, Separator {

    private Catalogue catalogue;

    public BookCatalogue() {
        Inventory inventory = Inventory.valueOf();
        catalogue = new Catalogue(inventory);
    }

    public String returnCatalogue() {
        return catalogue.putBookInformationInColumns();
    }

    public String toLineColumn() {
        Column column = new Column();
        System.out.println(returnCatalogue());
        String color = ColorList.getColor("INVERT");
        String option1 = "--> Checkout Book  ";
        String option2 = "--> Return Book  ";
        String option3 = "--> Return To Main Menu  ";
        column.addLine(option1, option2, option3);
        String toBookMenu = column.toString();
        System.out.println(color + toBookMenu + resetColor);
        return toBookMenu;
    }

    private String checkIfValidCheckOut() {
        System.out.println("Please, write the title of the book you want to checkout." +
                "\nIf you want to quit, please enter 'quit'");
        String titleToCheckout = ask();
        String result = (catalogue.isACheckoutBook(titleToCheckout)) ? printSeparator() : checkIfValidCheckOut();
        return result;
    }

    private String checkIfValidReturn() {
        System.out.println("Please, write the title of the book you want to return." +
                "\nIf you want to quit, please enter 'quit'");
        String titleToReturn = ask();
        String result = (catalogue.isABookReturn(titleToReturn)) ? printSeparator() : checkIfValidReturn();
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
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("Invalid Option. Please, select a valid option!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }

    @Override
    public String printSeparator() {
        String information = "Returning to main menu......";
        System.out.println(color + breakLine + resetColor);
        printer.printSlowly(information, 50);
        return information;
    }
}
