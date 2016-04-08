package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.UserFinder;
import com.twu.biblioteca.models.user.User;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthentificatedUserMenuTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AuthentificatedUserMenu authentificatedUserMenu;
    private UserFinder userFinder;
    private User user = new User.Builder().libraryNumber("001-0001").password("loop").name("Klaus").emailAdress("klaus@leap.se").phoneNumber("123-123").build();

    @Before
    public void setUp() {
        authentificatedUserMenu = new AuthentificatedUserMenu();
    }

    @Test
    public void shouldPrintMenuItems() throws Exception {
        System.setOut(new PrintStream(outContent));
        String actual = "--> List books   --> List movies   --> User info   --> Log out   " +
                "\n";
        assertEquals(authentificatedUserMenu.printLoggedUserMenu(), actual);
    }

    @Test
    public void shouldPrintProperUserInformation() throws Exception {
        userFinder = mock(UserFinder.class);
        when(userFinder.getCurrentUser()).thenReturn(user);
        authentificatedUserMenu.printUserInformation(userFinder);
        assertEquals("Name: Klaus Email: klaus@leap.se Phone: 123-123 \n", authentificatedUserMenu.printUserInformation(userFinder));
    }


    @Test
    public void methodAsksForChoiceOfLoggedUser() throws Exception {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    authentificatedUserMenu.defineUserOutput(userFinder);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        t.join(1000);
        assertTrue(t.isAlive());
    }

}