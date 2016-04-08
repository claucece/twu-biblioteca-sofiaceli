package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Session;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;

public class AuthentificationMenu implements InputAsker, Separator, ErrorPrinter {

    private Session session;
    private AuthetificatedUserMenu authenticatedUserMenu;
    private AnonymousUserMenu anonymousUserMenu;

    public AuthentificationMenu() {
        session = new Session();
        authenticatedUserMenu = new AuthetificatedUserMenu();
        anonymousUserMenu = new AnonymousUserMenu();
    }

    public String defineTypeOfUser() throws Exception {
        String input = ask();
        if (input.equals("log in")) {
            printSeparator();
            if (session.newSession() == true) {
                printSeparator();
                authenticatedUserMenu.printLoggedUserMenu();
                return authenticatedUserMenu.defineUserOutput();
            }
        } else if (input.equals("anonymous user")) {
            printSeparator();
            anonymousUserMenu.printAnonymousUserMenu();
            return anonymousUserMenu.defineOutput();
        }
        printError();
        return defineTypeOfUser();
    }

    @Override
    public String ask() {
        out.println("Please, select a kind of user:");
        out.println("1. Anonymous user      2.Log in");
        return scanner.nextLine().toLowerCase();
    }

    @Override
    public String printSeparator() {
        String separator = color + breakLine + resetColor;
        System.out.println(color + breakLine + resetColor);
        return separator;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("Select a valid option!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}