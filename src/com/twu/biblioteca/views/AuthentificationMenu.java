package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Session;
import com.twu.biblioteca.controllers.UserFinder;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.models.color.ColorList;

public class AuthentificationMenu implements InputAsker, Separator, ErrorPrinter {

    private Session session;
    private AuthentificatedUserMenu authenticatedUserMenu;
    private AnonymousUserMenu anonymousUserMenu;
    private UserFinder userFinder;

    public AuthentificationMenu() {
        session = new Session();
        authenticatedUserMenu = new AuthentificatedUserMenu();
        anonymousUserMenu = new AnonymousUserMenu();
        userFinder = new UserFinder();
    }

    public void generateAuthenticatedUserSession() throws Exception {
        printSeparator();
        authenticatedUserMenu.printLoggedUserMenu();
        authenticatedUserMenu.defineUserOutput(userFinder);
    }

    public String generateAnonymousUserSession() throws Exception {
        anonymousUserMenu.printAnonymousUserMenu();
        return anonymousUserMenu.defineOutput();
    }

    public String exit() {
        String bye = "Thanks for your visit. Bye!";
        System.out.println(bye);
        return bye;
    }

    public String defineTypeOfUser() throws Exception {
        String input = ask();
        if (input.equals("log in")) {
            printSeparator();
            if (session.newSession(userFinder) == true) {
                generateAuthenticatedUserSession();
            }
        } else if (input.equals("anonymous user")) {
            return generateAnonymousUserSession();
        }else if (input.equals("quit")) {
            return exit();
        } else {
            printError();
        }
        printSeparator();
        return defineTypeOfUser();
    }

    @Override
    public String ask() {
        out.println("Please, select a kind of user:");
        String color = ColorList.getColor("INVERT");
        out.println(color + "1. Anonymous user      2.Log in      3.Quit" + resetColor);
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
