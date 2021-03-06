package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.UserFinder;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.models.book.BookInventory;
import com.twu.biblioteca.models.color.ColorList;
import com.twu.biblioteca.models.movie.MovieInventory;

public class AuthentificatedUserMenu implements ErrorPrinter, Separator, InputAsker {

    private Catalogue catalogue;
    private BookInventory bookInventory;
    private MovieInventory movieInventory;
    private String newLine = "\n";

    public AuthentificatedUserMenu() {
        catalogue = new Catalogue();
        bookInventory = new BookInventory();
        movieInventory = new MovieInventory();
    }

    public String printLoggedUserMenu() {
        Column column = new Column();
        String option1 = "--> List books  ";
        String option2 = "--> List movies  ";
        String option3 = "--> User info  ";
        String option4 = "--> Log out  ";
        column.addLine(option1, option2, option3, option4);
        String toMenu = column.toString();
        System.out.println(toMenu);
        return toMenu;
    }

    public String printUserInformation(UserFinder userFinder) {
        Column column = new Column();
        String color = ColorList.getColor("PURPLE");
        String option1 = "Name: " + userFinder.getCurrentUser().getName();
        String option2 = "Email: " + userFinder.getCurrentUser().getEmailAdress();
        String option3 = "Phone: " + userFinder.getCurrentUser().getPhoneNumber();
        column.addLine(option1, option2, option3);
        String toMenu = column.toString();
        System.out.println(color + toMenu + resetColor);
        return toMenu;
    }

    private String logOut() {
        String logOut = "You have been log out.";
        printer.printSlowly(logOut, 40);
        System.out.println(newLine);
        return logOut;
    }

    public String defineUserOutput(UserFinder userFinder) throws Exception {
        String input = ask();
        if (input.equals("list books")) {
            printSeparator();
            catalogue.defineBookMenuOutcome(bookInventory);
        } else if (input.equals("list movies")) {
            printSeparator();
            catalogue.defineBookMenuOutcome(movieInventory);
        } else if (input.equals("user info")) {
            printUserInformation(userFinder);
            printSeparator();
        } else if (input.equals("log out")) {
            return logOut();
        } else {
            printError();
        }
        printLoggedUserMenu();
        return defineUserOutput(userFinder);
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

    @Override
    public String ask() {
        out.println("The librarian says: \n" +
                "    Please, select a choice:");
        return scanner.nextLine().toLowerCase();
    }
}
