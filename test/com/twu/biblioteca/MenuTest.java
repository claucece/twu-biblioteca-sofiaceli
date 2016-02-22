package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static org.junit.Assert.*;

public class MenuTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu testMenu;
    Inventory inventory = new Inventory();
    List<String> bookList;

    @Before
    public void setUp() {
        testMenu = new Menu();
        bookList = new ArrayList<String>();
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        System.setOut(new PrintStream(outContent));
        String testWelcome = "Hello and welcome to 'Menu', the Library Management " +
                "System from The Bangalore Public Library!" +
                "Keep reading to see the lists of books available";
        testMenu.printWelcomeMessage();
        assertEquals(testWelcome, outContent.toString());
        }

    @Test
    public void shouldHaveAHeadingColumn() {
        System.setOut(new PrintStream(outContent));
        String actual = "Book_name Author_name Date_name " +
                "\n";
        assertEquals(testMenu.printHeader(), actual);
    }

    @Test
    public void shouldHaveBooks() {
        List<String> expected = new ArrayList<String>();
        expected.add("For whom the bell tolls, Ernest Hemmingway, 1930");
        expected.add("Waiting for Godot, Samuel Beckett, 1940");
        List<String> actual = testMenu.listBooks(bookList);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPrintAllBooks() {
        System.setOut(new PrintStream(outContent));
        String printedBookList = "For whom the bell tolls, Ernest Hemmingway, 1930" +
                "\nWaiting for Godot, Samuel Beckett, 1940" +
                "\n";
        testMenu.getBooks();
        assertEquals(printedBookList, outContent.toString());
    }

    }

    //@Test
    //public void shouldHaveTheInventoryOfBooks() {
    //    assertTrue(testMenu.getInventory() instanceof Object);
    //}

    //@Test
    //public void shouldHaveBooks() {
    //    Inventory expected = inventory;
    //    Inventory actual = testMenu.getInventory();
    //    assertEquals(expected, actual);
    //}


    //@Test
    //public void shouldContainBook() {
    //    assertTrue(testMenu.initializeInventory(inventory).);
    //}

