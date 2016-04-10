package com.twu.biblioteca.models.UserTests;

import com.twu.biblioteca.anotations.ValidationChecker;
import com.twu.biblioteca.models.user.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private static ValidationChecker checker;
    private User user;
    private User errorUser;
    private String data = "password";

    @Before
    public void setUp() {
        user = new User.Builder().libraryNumber("001-0001").password(data).name("user").emailAdress("user@usermail.com").phoneNumber("603-200").build();
        errorUser = new User.Builder().libraryNumber("001001").password(data).name("u").emailAdress("userusermail.com").phoneNumber("60200").build();
        checker = new ValidationChecker();
    }

    @Test
    public void shouldReturnName() {
        assertEquals("user", user.getName());
    }

    @Test
    public void shouldHaveAValidLengthName() throws IllegalAccessException {
        List<String> mylist = new ArrayList<String>();
        assertEquals(mylist, checker.validateSize(user));
    }

    @Test
    public void shouldNotAllowAnInvalidLengthName() throws IllegalAccessException {
        List<String> mylist = new ArrayList<String>(Collections.singletonList("Invalid size"));
        assertEquals(mylist, checker.validateSize(errorUser));
    }

    @Test
    public void shouldBeNotNull() throws IllegalAccessException {
        user = new User.Builder().libraryNumber("001-0001").password(data).name(null).emailAdress("user@usermail.com").phoneNumber("603-200").build();
        List<String> mylist = new ArrayList<String>(Collections.singletonList("Could not be assigned null"));
        assertEquals(mylist, checker.validateNotNull(user));
    }

    @Test
    public void shouldReturnLibraryNumber() {
        assertEquals("001-0001", user.getLibraryNumber());
    }

    @Test
    public void shouldLibraryNumberHaveAProperFormat() throws IllegalAccessException {
        List<String> mylist = new ArrayList<String>(Collections.singletonList("Should have this format: '000-0000'"));
        assertEquals(mylist, checker.validateFormat(errorUser));
    }

    @Test
    public void shouldReturnEmail() {
        assertEquals("user@usermail.com", user.getEmailAdress());
    }

    @Test
    public void shouldEmailHaveAProperFormat() throws IllegalAccessException {
        List<String> mylist = new ArrayList<String>(Collections.singletonList("Should have this format: 'name@servicemail.com'"));
        assertEquals(mylist, checker.validateEmail(errorUser));
    }

    @Test
    public void shouldPhoneNumber() {
        assertEquals("603-200", user.getPhoneNumber());
    }

    @Test
    public void shouldPhoneHaveAProperFormat() throws IllegalAccessException {
        List<String> mylist = new ArrayList<String>(Collections.singletonList("Should have this format: '000-000'"));
        assertEquals(mylist, checker.validatePhone(errorUser));
    }

}