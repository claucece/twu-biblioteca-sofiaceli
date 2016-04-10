package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.controllers.*;
import com.twu.biblioteca.models.book.BookInventory;
import com.twu.biblioteca.models.movie.MovieInventory;

public class AnonymousUserMenu implements InputAsker, ErrorPrinter, Separator {

    private Catalogue catalogue;
    private BookInventory bookInventory;
    private MovieInventory movieInventory;

    public AnonymousUserMenu() {
        catalogue = new Catalogue();
        bookInventory = new BookInventory();
        movieInventory = new MovieInventory();
    }

    public String printAnonymousUserMenu() {
        Column column = new Column();
        printSeparator();
        String option1 = "--> List books  ";
        String option2 = "--> List movies  ";
        String option3 = "--> Quit  ";
        column.addLine(option1, option2, option3);
        String toMenu = column.toString();
        System.out.println(toMenu);
        return toMenu;
    }

    public String exit() {
        String bye = "Thanks for your visit. Bye!";
        System.out.println(bye);
        return bye;
    }

    public String defineOutput() throws Exception {
        String input = ask();
        if (input.equals("list books")) {
            catalogue.returnCatalogue(bookInventory);
        } else if (input.equals("list movies")) {
            catalogue.returnCatalogue(movieInventory);
        } else if (input.equals("quit")) {
            return exit();
        } else {
            printError();
        }
        printAnonymousUserMenu();
        return defineOutput();
    }

    @Override
    public String ask() {
        out.println("The librarian says: \n" +
                "    Please, select a choice:");
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
