package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.user.User;
import com.twu.biblioteca.models.user.UserList;

public class UserFinder {

    private User currentUser;

    public boolean findUser(String libraryNumber, String password) throws Exception {
        int hashCodePassword = password.hashCode();
        for (User user : UserList.VALUES) {
            if (libraryNumber.equals(user.getLibraryNumber()) && hashCodePassword == user.getPassword()) {
                currentUser = new User.Builder().libraryNumber(libraryNumber).password(user.getHashPassword().toString()).name(user.getName()).emailAdress(user.getEmailAdress()).phoneNumber(user.getPhoneNumber()).build();
                return this.currentUser.isLogIn(true);
            }
        }
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }

}
