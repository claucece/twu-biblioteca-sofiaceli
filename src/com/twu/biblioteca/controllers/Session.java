package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;

import static com.twu.biblioteca.helpers.Separator.printer;

public class Session implements InputAsker {

    public String newLine = "\n";

    public boolean printSucessfulSession() {
        String successfulSession = "User authenticated. New session created.";
        printer.printSlowly(successfulSession, 40);
        System.out.println(newLine);
        return true;
    }

    public boolean printUnSucessfulSession() {
        String unsuccessfulSession = "User not authenticated. New session not created.";
        printer.printSlowly(unsuccessfulSession, 40);
        System.out.println(newLine);
        return false;
    }

    public String askForLibraryNumber() {
        StringBuilder libraryNumber = new StringBuilder("Please, enter your library number:");
        System.out.println(libraryNumber);
        return ask();
    }

    public String askForPassword() {
        StringBuilder password = new StringBuilder("Please, enter your password:");
        System.out.println(password);
        return ask();
    }

    public boolean newSession(UserFinder userFinder) throws Exception {
        if (userFinder.findUser(askForLibraryNumber(), askForPassword()) == true) {
            return printSucessfulSession();
        }
        return printUnSucessfulSession();
    }

    @Override
    public String ask() {
        return scanner.nextLine().toLowerCase();
    }

}
