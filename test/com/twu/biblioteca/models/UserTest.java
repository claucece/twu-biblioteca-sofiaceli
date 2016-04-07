package com.twu.biblioteca.models;

import com.twu.biblioteca.anotations.ValidationChecker;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserTest {

    private static ValidationChecker checker;
    private User user;
    private User errorUser;

    @Before
    public void setUp() {
        checker = new ValidationChecker();
    }

    @Test
    public void shouldReturnName() {
        User user = mock(User.class);
        User.Builder builder = newBuilderMock();
        when(user.getName()).thenReturn("user");
        assertEquals(user.getName(), "user");
    }

    @Test
    public void shouldHaveAValidLengthName() throws IllegalAccessException {
        String data = "password";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        errorUser = new User.Builder().libraryNumber("001-0001").password(data).name("user").emailAdress("user@usermail.com").phoneNumber("603-200").build();
        List<String> mylist = new ArrayList<String>();
        assertEquals(mylist, checker.validateSize(errorUser));
    }

    @Test
    public void shouldNotAllowAnInvalidLengthName() throws IllegalAccessException {
        String data = "password";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        user = new User.Builder().libraryNumber("001-0001").password(data).name("us").emailAdress("user@usermail.com").phoneNumber("603-200").build();
        List<String> mylist = new ArrayList<String>(Arrays.asList("Invalid size"));
        assertEquals(mylist, checker.validateSize(user));
    }

    @Test
    public void shouldBeNotNull() throws IllegalAccessException {
        String data = "password";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        user = new User.Builder().libraryNumber("001-0001").password(data).name(null).emailAdress("user@usermail.com").phoneNumber("603-200").build();
        List<String> mylist = new ArrayList<String>(Arrays.asList("Could not be assigned null"));
        assertEquals(mylist, checker.validateNotNull(user));
    }

    @Test
    public void shouldLibraryNumberHaveAProperFormat() throws IllegalAccessException {
        String data = "user";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        user = new User.Builder().libraryNumber("001000").password(data).name("user").emailAdress("user@usermail.com").phoneNumber("603-200").build();
        List<String> mylist = new ArrayList<String>(Arrays.asList("Should have this format: '000-0000'"));
        assertEquals(mylist, checker.validateFormat(user));
    }

    @Test
    public void shouldEmailHaveAProperFormat() throws IllegalAccessException {
        String data = "user";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        user = new User.Builder().libraryNumber("001-0001").password(data).name("user").emailAdress("userusermail.com").phoneNumber("603-200").build();
        List<String> mylist = new ArrayList<String>(Arrays.asList("Should have this format: 'name@servicemail.com'"));
        assertEquals(mylist, checker.validateEmail(user));
    }

    @Test
    public void shouldPhoneHaveAProperFormat() throws IllegalAccessException {
        String data = "user";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        user = new User.Builder().libraryNumber("001-0001").password(data).name("user").emailAdress("user@usermail.com").phoneNumber("60-820").build();
        List<String> mylist = new ArrayList<String>(Arrays.asList("Should have this format: '000-000'"));
        assertEquals(mylist, checker.validatePhone(user));
    }

//    @Test
//    public void shouldReturnUserName() {
//        User f = mock(User.class);
//        User.Builder b = newBuilderMock();
//        when(b.build()).thenReturn(f);
//        when(f.getName()).thenReturn(null);
//        String expected = f.getName();
//        String actual = null;
//        assertTrue(expected.);
//        //assertEquals(expected, actual);
    //}

//    @Test
//    public void shouldReturnEmailAdress() {
//        String expected = user.getEmailAdress();
//        String actual = "user@usermail.com";
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldReturnPhoneNumber() {
//        String expected = user.getPhoneNumber();
//        String actual = "6038200";
//        assertEquals(expected, actual);
//    }

    @Test
    public void shouldReturnPhone() {
        User user = mock(User.class);
        User.Builder builder = newBuilderMock();
        when(builder.build()).thenReturn(user);
        //when(f.ask()).thenReturn("lo");
        user.getHashPassword();
    }

    private User.Builder newBuilderMock() {
        User.Builder b = mock(User.Builder.class);
        when(b.password("lo")).thenReturn(b);
        when(b.name("user")).thenReturn(b);
        return b;
    }
}