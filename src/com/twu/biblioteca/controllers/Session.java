package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.UserMessagesHelper;

public class Session implements InputAsker {

    private UserMessagesHelper userMessages;

    public Session() {
        userMessages = new UserMessagesHelper();
    }

    private String askForLibraryNumber() {
        StringBuilder libraryNumber = new StringBuilder("    So, you're a returning user... \n" +
                "    Please, tell me your library number:");
        System.out.println(libraryNumber);
        return ask();
    }

    private String askForPassword() {
        StringBuilder password = new StringBuilder("    Please, tell me your password:");
        System.out.println(password);
        return ask();
    }

    public boolean newSession(UserFinder userFinder) throws Exception {
        if (userFinder.findUser(askForLibraryNumber(), askForPassword())) {
            return userMessages.printSucessfulSessionCreation();
        }
        return userMessages.printUnSucessfulSessionCreation();
    }

    @Override
    public String ask() {
        return scanner.nextLine().toLowerCase();
    }

}
