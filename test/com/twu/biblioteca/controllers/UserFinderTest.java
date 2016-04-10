package com.twu.biblioteca.controllers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserFinderTest {

    @Test
    public void shouldBeTrueIfUserNameAndPasswordMatches() throws Exception {
        String name = "001-0002";
        String password = "foreachloop";
        UserFinder userFinder = new UserFinder();
        boolean matcher = userFinder.findUser(name, password);
        assertTrue(matcher);
    }

    @Test
    public void shouldBeFalseIfUserNameAndPasswordDoNotMatch() throws Exception {
        String name = "001-0002";
        String password = "for";
        UserFinder userFinder = new UserFinder();
        boolean matcher = userFinder.findUser(name, password);
        assertFalse(matcher);
    }

}