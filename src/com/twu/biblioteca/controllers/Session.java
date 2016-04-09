package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.models.color.ColorList;

public class Session implements InputAsker {

    public String newLine = "\n";

    public boolean printSucessfulSession() {
        StringBuilder successfulSession = new StringBuilder("User authenticated. New session created.");
        System.out.println(successfulSession + newLine);
        return true;
    }

    public boolean printUnSucessfulSession() {
        String color = ColorList.getColor("RED");
        String resetColor = ColorList.getColor("RED");
        StringBuilder unsuccessfulSession = new StringBuilder(color + "User not authenticated. New session not created." + resetColor);
        System.out.println(unsuccessfulSession + newLine);
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
