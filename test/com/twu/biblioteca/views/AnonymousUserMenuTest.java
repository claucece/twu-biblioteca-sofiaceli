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
        String actual = "--> List books   --> List movies   --> Quit   " +
                "\n";
        assertEquals(anonymousUserMenu.printAnonymousUserMenu(), actual);
    }

    @Test
    public void shouldExitMessage() {
        System.setOut(new PrintStream(outContent));
        String actual = "Thanks for your visit. Bye!";
        assertEquals(anonymousUserMenu.exit(), actual);
    }

    @Test
    public void methodAsksForChoiceOfUser() throws Exception {
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    anonymousUserMenu.defineOutput();
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


