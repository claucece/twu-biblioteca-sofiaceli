package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;
import static org.junit.Assert.*;

public class MenuTest {

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu testMenu;
    private Scanner input;
    private ListOfBooks listOfBooks;

//    @Before
//    public void setUp() {
//        testMenu = new Menu();
//        input = new Scanner(System.in);
//        listOfBooks = new ListOfBooks();
//    }
//
//    @Test
//    public void shouldPrintMenuItems() {
//        System.setOut(new PrintStream(outContent));
//        String actual = "--> List books   --> Search books   --> Quit   " +
//                "\n";
//        assertEquals(testMenu.printMenu(), actual);
//    }
//
//    @Test
//    public void shouldPrintAHeader() {
//        System.setOut(new PrintStream(outContent));
//        String actual = "Book_name Author_name Published_Year " +
//                "\n";
//        assertEquals(testMenu.printHeader(), actual);
//    }
//
//    @Test
//    public void shouldProcessUserInput() {
//        String input = "list books";
//        assertEquals("list books", testMenu.getInputFromUser(
//                new Scanner(input)));
//    }
//
//    @Test
//    public void shouldReturnListOfBooksWhenChosen() {
//        String expected = listOfBooks.printBookInformation();
//        String input = "list books";
//        String actual = testMenu.setScene(input);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldQuitWhenChosen() {
//        String expected = "Thanks for your visit. Bye!";
//        String input = "quit";
//        String actual = testMenu.setScene(input);
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldPrintErrorWhenNotChosen() {
//        String expected = "Select a valid option!";
//        String input = "lo";
//        String actual = testMenu.setScene(input);
//        assertEquals(expected, actual);
//    }
//



    //@Test
    //public void shouldReturnBookList() {
    //    String input = "list books";
    //    assertEquals(testMenu.getInputFromUser(new Scanner(input)), );
    //}

}


