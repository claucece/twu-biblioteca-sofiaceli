package com.twu.biblioteca.controllers;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UserFinderTest {

    @Test
    public void shouldBeTrueIfUserNameMatches() throws Exception {
        String name = "001-0001";
        String password = "forloop";
        UserFinder userFinder = new UserFinder();
        boolean matcher = userFinder.findUser(name, password);
        assertTrue(matcher);
    }


}