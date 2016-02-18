package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class BibliotecaTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca testBiblioteca;

    @Before
    public void setUp() {
        testBiblioteca = new Biblioteca();
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        System.setOut(new PrintStream(outContent));
        String testWelcome = "Hello and welcome to 'Biblioteca', the Library Management " +
                "System from The Bangalore Public Library!" +
                "Keep reading to see the lists of books available";
        testBiblioteca.printWelcomeMessage();
        assertEquals(testWelcome, outContent.toString());
        }

    }
