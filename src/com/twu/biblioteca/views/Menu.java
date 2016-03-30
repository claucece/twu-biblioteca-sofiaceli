package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.models.Inventory;

public class Menu implements InputAsker, ErrorPrinter, Separator {

    private BookCatalogue bookCatalogue;

    public Menu() {
        bookCatalogue = new BookCatalogue();
    }

    public String toLineColumn() {
        Column column = new Column();
        String option1 = "--> List books  ";
        String option2 = "--> Quit  ";
        column.addLine(option1, option2);
        String toMenu = column.toString();
        System.out.println(toMenu);
        return toMenu;
    }

    private String exit() {
        String bye = "Thanks for your visit. Bye!";
        System.out.println(bye);
        return bye;
    }

    public String defineOuput() {
        String input = ask();
            if (input.equals("list books")) {
                //printSeparator();
                bookCatalogue.toLineColumn();
                bookCatalogue.defineBookMenuOutcome();
            } else if (input.equals("quit")) {
                return exit();
            } else {
                printError();
            }
        toLineColumn();
        return defineOuput();
    }

    @Override
    public String ask() {
        out.println("Please, select a choice");
        return scanner.nextLine().toLowerCase();
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("Select a valid option!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }

    @Override
    public String printSeparator() {
        return color + breakLine + resetColor;
    }
}
