package com.twu.biblioteca.views;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class MenuTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void shouldPrintMenuItems() {
        System.setOut(new PrintStream(outContent));
        String actual = "--> List books   --> List movies   --> Log in   --> Quit   " +
                "\n";
        assertEquals(menu.toLineColumn(), actual);
    }

}


