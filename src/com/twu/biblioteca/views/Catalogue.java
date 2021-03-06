package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.models.color.ColorList;
import com.twu.biblioteca.models.Inventory;


public class Catalogue implements InputAsker, ErrorPrinter, Separator {

    private Circulation circulation;
    private Inventory inventory;

    public Catalogue() {
        circulation = new Circulation(inventory);
    }

    public String returnCatalogue(Inventory inventory) {
        System.out.println(circulation.putInformationInColumns(inventory));
        return circulation.putInformationInColumns(inventory);
    }

    public String toLineColumn(Inventory inventory) {
        Column column = new Column();
        returnCatalogue(inventory);
        String color = ColorList.getColor("INVERT");
        String option1 = "--> Checkout " + inventory.getName();
        String option2 = "--> Return " + inventory.getName();
        String option3 = "--> Return To Main  ";
        column.addLine(option1, option2, option3);
        String toBookMenu = column.toString();
        System.out.println(color + toBookMenu + resetColor);
        return toBookMenu;
    }

    private String checkIfValidCheckOut(Inventory inventory) {
        System.out.println("Please, write the title of the " + inventory.getName() + " you want to checkout." +
                "\nIf you want to quit, please enter 'quit'");
        String titleToCheckout = ask();
        String result = (circulation.isACheckout(titleToCheckout, inventory)) ? printSeparator() : checkIfValidCheckOut(inventory);
        return result;
    }

    private String checkIfValidReturn(Inventory inventory) {
        System.out.println("Please, write the title of the " + inventory.getName() + " you want to return." +
                "\nIf you want to quit, please enter 'quit'");
        String titleToReturn = ask();
        String result = (circulation.isAReturn(titleToReturn, inventory)) ? printSeparator() : checkIfValidReturn(inventory);
        return result;
    }

    public String defineBookMenuOutcome(Inventory inventory) {
        toLineColumn(inventory);
        System.out.println("Please, select a choice from the menu above:");
        String input = ask();
        if (input.equals("checkout book") || (input.equals("checkout movie"))) {
            return checkIfValidCheckOut(inventory);
        } else if (input.equals("return book") || (input.equals("return movie"))) {
            return checkIfValidReturn(inventory);
        } else if (input.equals("main menu")) {
            return printSeparator();
        }
        printError();
        return defineBookMenuOutcome(inventory);
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
