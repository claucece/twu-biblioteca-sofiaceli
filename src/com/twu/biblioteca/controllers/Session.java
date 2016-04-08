package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;

public class Session implements InputAsker{

    UserFinder userFinder = new UserFinder();

    public String newSession() throws Exception {
        if (userFinder.findUser(ask(), ask()) == true) {
            String session = "User authenticated. New session created.";
            System.out.println(session);
            return session;
        }
        String noSession = "User not authenticated. New session not created.";
        System.out.println(noSession);
        return noSession;
    }

    public boolean logIn() throws Exception {
        if (newSession().equals("User authenticated. New session created.")) {
            return true;
        }
        return false;
    }

    @Override
    public String ask() {
        out.println("Please enter your libraryNumber");
        return scanner.nextLine().toLowerCase();
    }

}
