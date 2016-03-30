package com.twu.biblioteca.views;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class HomeTest {

    private ByteArrayOutputStream outContent;
    private Home home;

    @Before
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        home = new Home();
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        System.setOut(new PrintStream(outContent));
        String testWelcome = "\u001B[1mHello and welcome to 'Alexandros', the Library Management " +
                "System from The Bangalore Public Library!" +
                "\n" +
                "Keep reading to see the lists of books available\u001B[0m";
        home.printWelcomeMessage();
        assertEquals(testWelcome, outContent.toString());
    }

}