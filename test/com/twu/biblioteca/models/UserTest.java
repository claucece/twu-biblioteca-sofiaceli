package com.twu.biblioteca.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User.Builder("001-0001", "shouldbeahash").name("User").emailAdress("user@usermail.com").phoneNumber("6038200").build();
    }

    @Test
    public void shouldReturnLibraryNumber() {
        String expected = user.getLibraryNumber();
        String actual = "001-0001";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnUserName() {
        String expected = user.getName();
        String actual = "User";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmailAdress() {
        String expected = user.getEmailAdress();
        String actual = "user@usermail.com";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnPhoneNumber() {
        String expected = user.getPhoneNumber();
        String actual = "6038200";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnHashedPassword() {
        String expected = user.getHashPassword();
        String actual = "shouldbeahash";
        assertEquals(expected, actual);
    }

}