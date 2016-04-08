package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.user.User;

public class Session implements InputAsker{

    UserFinder userFinder = new UserFinder();
    //maybe this will be gone
    private Inventory inventory;
    private String title;
    private Catalogue catalogue = new Catalogue(inventory);
    private User user;

    public boolean newSession() throws Exception {
        System.out.println("Please, enter your library Number:");
        String libraryNumberAsker = ask();
        System.out.println("Please, enter your password:");
        String passwordAsker = ask();
        if (userFinder.findUser(libraryNumberAsker, passwordAsker) == true) {
            String session = "User authenticated. New session created.";
            System.out.println(session);
            return true;
        }
        String noSession = "User not authenticated. New session not created.";
        System.out.println(noSession);
        return false;
    }

//    public boolean logIn() throws Exception {
//        if (newSession().equals("User authenticated. New session created.")) {
//            user.isLogIn(true);
//            return true;
//        }
//        return false;
    //}

//    public String whoHasReserved() throws Exception {
//        if (logIn() == true) {
//            if (catalogue.isACheckout(title, inventory) == true) {
//                return userFinder.user.getName();
//            }
//        }
//        return null;
//    }

    @Override
    public String ask() {
        return scanner.nextLine().toLowerCase();
    }

}
