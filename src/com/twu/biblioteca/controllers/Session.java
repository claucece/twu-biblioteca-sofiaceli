package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;

public class Session implements InputAsker{

    UserFinder userFinder = new UserFinder();

//    public String newSession(InputAsker asker) {
//        if (userFinder.findUser(asker.ask()) == true) {
//            String session = "User authenticated. New session created.";
//            return session;
//        }
//        String noSession = "User not authenticated. New session not created.";
//        return noSession;
//    }

    @Override
    public String ask() {
        out.println("Please enter your libraryNumber");
        return scanner.nextLine().toLowerCase();
    }

}
