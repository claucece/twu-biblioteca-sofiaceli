package com.twu.biblioteca.views;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class AnonymousUserMenuTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private AnonymousUserMenu anonymousUserMenu;

    @Before
    public void setUp() {
        anonymousUserMenu = new AnonymousUserMenu();
    }

    @Test
    public void shouldPrintMenuItems() throws Exception {
        System.setOut(new PrintStream(outContent));
        String actual = "--> List books   --> List movies   --> Log in   --> Quit   " +
                "\n";
        assertEquals(anonymousUserMenu.printAnonymousUserMenu(), actual);
    }

}


