package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.user.User;
import com.twu.biblioteca.models.user.UserList;

public class UserFinder {

    User user;

    public boolean findUser(String libraryNumber, String password) throws Exception {
        int hashCodePassword = password.hashCode();
        for (User user : UserList.VALUES) {
            if (libraryNumber.equals(user.getLibraryNumber()) && hashCodePassword == user.getPassword()) {
                user = new User.Builder().libraryNumber(libraryNumber).password(user.getHashPassword().toString()).name(user.getName()).emailAdress(user.emailAdress).phoneNumber(user.getPhoneNumber()).build();
                return true;
            }
        }
        return false;
    }

}
