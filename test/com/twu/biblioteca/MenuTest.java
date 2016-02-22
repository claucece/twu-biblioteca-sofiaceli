package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MenuTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu testMenu;
    private Inventory inventory;
    //List<String> bookList;

    @Before
    public void setUp() {
        testMenu = new Menu();
        //bookList = new ArrayList<String>();
        inventory = new Inventory();
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
        String actual = "Book_name Author_name Published_Year " +
                "\n";
        assertEquals(testMenu.printHeader(), actual);
    }

    @Test
    public void shouldPrintBookInformationInColumns() {
        System.setOut(new PrintStream(outContent));
        String actual = "For whom the bells toll Ernest Hemingway 1980 " +
                "\n";
        assertEquals(testMenu.printBookInformation(), actual);
    }


}

    //@Test
    //public void shouldPrintAllBooks() {
    //    System.setOut(new PrintStream(outContent));
    //    String printedBookList = "For whom the bell tolls, Ernest Hemmingway, 1930" +
    //            "\nWaiting for Godot, Samuel Beckett, 1940" +
    //            "\n";
    //    testMenu.getBooks();
    //    assertEquals(printedBookList, outContent.toString());
    //}

    //}

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

