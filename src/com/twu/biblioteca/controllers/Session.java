package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.helpers.UserMessagesHelper;

public class Session implements InputAsker {

    private UserMessagesHelper userMessages;

    public Session(){
        userMessages = new UserMessagesHelper();
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
            return userMessages.printSucessfulSessionCreation();
        }
        return userMessages.printUnSucessfulSessionCreation();
    }

    @Override
    public String ask() {
        return scanner.nextLine().toLowerCase();
    }

}
