package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;

public class Session implements InputAsker{

    public boolean printSucessfullSession() {
        String session = "User authenticated. New session created.";
        System.out.println(session);
        return true;
    }

    public boolean printUnSucessfullSession() {
        String noSession = "User not authenticated. New session not created.";
        System.out.println(noSession);
        return false;
    }

    public String askForLibraryNumber() {
        System.out.println("Please, enter your library Number:");
        return ask();
    }

    public String askForPassword() {
        System.out.println("Please, enter your password:");
        return ask();
    }

    public boolean newSession(UserFinder userFinder) throws Exception {
        if (userFinder.findUser(askForLibraryNumber(), askForPassword()) == true) {
            return printSucessfullSession();
        }
        return printUnSucessfullSession();
    }

    @Override
    public String ask() {
        return scanner.nextLine().toLowerCase();
    }

}
