package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class HomeTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Home home;

    @Before
    public void setUp() {
        home = new Home();
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        System.setOut(new PrintStream(outContent));
        String testWelcome = "Hello and welcome to 'Alexandros', the Library Management " +
                "System from The Bangalore Public Library!" +
                "\n" +
                "Keep reading to see the lists of books available";
        home.printWelcomeMessage();
        String welcome = testWelcome;
        assertEquals(welcome, outContent.toString());
    }

    @Test
    public void shouldPrintHomeLogo() {
        System.setOut(new PrintStream(outContent));
        String logo = "#     _   _   _   _   _   _   _   _   _   _  \n" +
                "#    / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n" +
                "#   ( A ( l ( e ( x ( a ( n ( d ( r ( o ( s )\n" +
                "#    \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ " +
                "\n";
        home.printHomeLogo();
        assertEquals(logo, outContent.toString());
    }
}