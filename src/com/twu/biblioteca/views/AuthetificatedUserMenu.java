package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.UserFinder;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.models.book.BookInventory;
import com.twu.biblioteca.models.movie.MovieInventory;

public class AuthetificatedUserMenu implements ErrorPrinter, Separator, InputAsker {

    private MenuCatalogue menuCatalogue;
    private BookInventory bookInventory;
    private MovieInventory movieInventory;

    public AuthetificatedUserMenu() {
        menuCatalogue = new MenuCatalogue();
        bookInventory = new BookInventory();
        movieInventory = new MovieInventory();
    }

    public String printLoggedUserMenu() throws Exception {
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

    public String defineUserOutput(UserFinder userFinder) throws Exception {
        String input = ask();
        if (input.equals("list books")) {
            printSeparator();
            menuCatalogue.toLineColumn(bookInventory);
        } else if (input.equals("list movies")) {
            printSeparator();
            menuCatalogue.toLineColumn(movieInventory);
        } else if (input.equals("user info")) {
            System.out.println(userFinder.getCurrentUser().getName());
            return logOut();
        } else if (input.equals("log out")) {
            return logOut();
        } else {
            printError();
        }
        printLoggedUserMenu();
        return defineUserOutput(userFinder);
    }

    public String logOut() {
        String bye = "You have been log out";
        System.out.println(bye);
        return bye;
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
        out.println("Please, select a choice:");
        return scanner.nextLine().toLowerCase();
    }
}
