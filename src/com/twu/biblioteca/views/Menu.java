package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.models.book.BookInventory;
import com.twu.biblioteca.models.movie.MovieInventory;

public class Menu implements InputAsker, ErrorPrinter, Separator {

    private MenuCatalogue menuCatalogue;
    private BookInventory bookInventory;
    private MovieInventory movieInventory;
    private Session session;

    public Menu() {
        menuCatalogue = new MenuCatalogue();
        bookInventory = new BookInventory();
        movieInventory = new MovieInventory();
        session = new Session();
    }

    public String toLineColumn() {
        Column column = new Column();
        String option1 = "--> List books  ";
        String option2 = "--> List movies  ";
        String option3 = "--> Log in  ";
        String option4 = "--> Quit  ";
        column.addLine(option1, option2, option3, option4);
        String toMenu = column.toString();
        System.out.println(toMenu);
        return toMenu;
    }

    public String exit() {
        String bye = "Thanks for your visit. Bye!";
        System.out.println(bye);
        return bye;
    }

    public String defineTypeOfUser() throws Exception {
        System.out.println("Please, enter the kind of user you are:");
        System.out.println("1. Anonymous user      2.Log in");
        String input = ask();
        if (input.equals("log in")) {
            printSeparator();
            if (session.logIn() == true) {
                toLineColumn();
                defineOutput();
            }
        } else if (input.equals("anonymous user")) {
            printSeparator();
        }
        printError();
        return defineTypeOfUser();
    }

    public String defineOutput() throws Exception {
        String input = ask();
            if (input.equals("list books")) {
                printSeparator();
                menuCatalogue.toLineColumn(bookInventory);
            } else if (input.equals("list movies")) {
                printSeparator();
                menuCatalogue.toLineColumn(movieInventory);
            //} else if (input.equals("log in")) {
            //    printSeparator();
            //    session.newSession();
            } else if (input.equals("quit")) {
                return exit();
            } else {
                printError();
            }
        toLineColumn();
        return defineOutput();
    }

    @Override
    public String ask() {
        out.println("Please, select a choice:");
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
        String separator = color + breakLine + resetColor;
        System.out.println(color + breakLine + resetColor);
        return separator;
    }
}
