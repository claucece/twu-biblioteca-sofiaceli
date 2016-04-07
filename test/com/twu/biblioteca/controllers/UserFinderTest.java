package com.twu.biblioteca.controllers;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class UserFinderTest {

    @Test
    public void shouldBeTrueIfUserNameMatches() {
        String name = "001-0001";
        UserFinder userFinder = new UserFinder();
        boolean matcher = userFinder.findUser(name);
        assertTrue(matcher);
    }


}