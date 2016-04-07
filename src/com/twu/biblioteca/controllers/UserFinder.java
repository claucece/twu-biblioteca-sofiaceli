package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.user.User;
import com.twu.biblioteca.models.user.UserList;

public class UserFinder {

    public boolean findUser(String name) {
        for (User userLibraryNumber : UserList.VALUES) {
            if (name.matches(userLibraryNumber.getLibraryNumber())) {
                return true;
            }
        }
        return false;
    }
}
