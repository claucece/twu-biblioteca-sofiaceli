package com.twu.biblioteca.models.user;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserList {

    private static String firstPassword = "forloop";
    private static String secondPassword = "foreachloop";
    private static String thridPassword = "for";

    private static final User[] PRIVATE_VALUES = {(new User.Builder().libraryNumber("001-0001").password(firstPassword).name("Klaus").emailAdress("klaus@leap.se").phoneNumber("123-123").build()),
            (new User.Builder().libraryNumber("001-0002").password(secondPassword).name("Bob").emailAdress("bob@leap.se").phoneNumber("124-124").build()),
            (new User.Builder().libraryNumber("001-0003").password(thridPassword).name("Anna").emailAdress("anna@leap.se").phoneNumber("125-125").build()),
    };

    public static final List<User> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

}

