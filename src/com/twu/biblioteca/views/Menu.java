package com.twu.biblioteca.views;

import com.twu.biblioteca.Helpers.ErrorPrinter;
import com.twu.biblioteca.Helpers.Separator;
import com.twu.biblioteca.controllers.*;

public class Menu implements InputAsker, ErrorPrinter, Separator {

    private Column column;
    private BookCatalogue bookCatalogue;

    public Menu() {
        column = new Column();
        bookCatalogue = new BookCatalogue();
    }

    public String printMenu() {
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
                printSeparator();
                bookCatalogue.printBookCatalogueMenu();
                bookCatalogue.defineBookMenuOutcome();
            } else if (input.equals("quit")) {
                return exit();
            } else {
                printError();
            }
        printMenu();
        return defineOuput();
    }

    @Override
    public String ask() {
        out.println("Please, select a choice");
        return scanner.nextLine().toLowerCase();
    }

    @Override
    public String printError() {
        String error = "Select a valid option!";
        System.out.println(errorColor + error + resetColor);
        return error;
    }

    @Override
    public String printSeparator() {
        String breakLine = "===================================================";
        System.out.println(color + breakLine + resetColor);
        return breakLine;
    }
}
