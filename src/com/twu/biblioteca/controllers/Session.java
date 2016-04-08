package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.models.Inventory;

public class Session implements InputAsker{

    UserFinder userFinder = new UserFinder();
    private Inventory inventory;
    private String title;
    private Catalogue catalogue = new Catalogue(inventory);

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

    public String whoHasReserved() throws Exception {
        if (logIn() == true) {
            if (catalogue.isACheckout(title, inventory) == true) {
                return userFinder.user.getName();
            }
        }
        return null;
    }

    @Override
    public String ask() {
        out.println("Please enter your libraryNumber");
        return scanner.nextLine().toLowerCase();
    }

}
