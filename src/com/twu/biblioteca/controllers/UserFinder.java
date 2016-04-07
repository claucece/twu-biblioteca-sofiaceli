package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.user.User;
import com.twu.biblioteca.models.user.UserList;

public class UserFinder {

    String libraryNumber;
    String password;
    User user;

    public boolean findUser(String libraryNumber, String password) throws Exception {
        int hashCodePassword = password.hashCode();
        for (User user : UserList.VALUES) {
            if (libraryNumber.equals(user.getLibraryNumber()) && hashCodePassword == user.getPassword()) {
                return true;
            }
        }
        return false;
    }

    public User.Builder setUser() throws Exception {
        if (findUser(libraryNumber, password) == true) {
            password = String.valueOf(user.getHashPassword());
            return new User.Builder().libraryNumber(libraryNumber).password(password).name(user.getName()).emailAdress(user.emailAdress).phoneNumber(user.getPhoneNumber());
        }
        return null;
    }
}
