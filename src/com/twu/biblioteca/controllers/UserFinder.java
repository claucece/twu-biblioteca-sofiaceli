package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.user.User;
import com.twu.biblioteca.models.user.UserList;

public class UserFinder {

    String libraryNumber;
    String password;
    User user;

    public boolean findUser(String libraryNumber, String password) throws Exception {
        //System.out.println(libraryNumber);
        //System.out.println(password);
        int hashCodePassword = password.hashCode();
        for (User user : UserList.VALUES) {
            if (libraryNumber.equals(user.getLibraryNumber()) && hashCodePassword == user.getPassword()) {
                new User.Builder().libraryNumber(libraryNumber).password(user.getHashPassword().toString()).name(user.getName()).emailAdress(user.emailAdress).phoneNumber(user.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

}
