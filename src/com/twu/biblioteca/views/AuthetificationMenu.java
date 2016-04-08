package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Column;
import com.twu.biblioteca.controllers.Session;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;

public class AuthetificationMenu implements ErrorPrinter, Separator, InputAsker {

    private Session session;
    private Menu menu;

    public AuthetificationMenu() {
        session = new Session();
        menu = new Menu();
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

    public String defineTypeOfUser() throws Exception {
        String input = ask();
        if (input.equals("log in")) {
            printSeparator();
            if (session.newSession() == true) {
                printSeparator();
                return printLoggedUserMenu();
            }
        } else if (input.equals("anonymous user")) {
            printSeparator();
            menu.printUserMenu();
            return menu.defineOutput();
        }
        printError();
        return defineTypeOfUser();
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
        out.println("Please, select a kind of user:");
        out.println("1. Anonymous user      2.Log in");
        return scanner.nextLine().toLowerCase();
    }
}
