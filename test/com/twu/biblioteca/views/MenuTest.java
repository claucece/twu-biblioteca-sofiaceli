package com.twu.biblioteca.views;

import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.ListOfBooks;
import com.twu.biblioteca.views.Menu;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;
import static org.junit.Assert.*;

public class MenuTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu testMenu;
    private Scanner input;
    Inventory inventory;
    //private ListOfBooks listOfBooks;

    @Before
    public void setUp() {
        testMenu = new Menu();
        input = new Scanner(System.in);
        inventory = new Inventory();
        //listOfBooks = new ListOfBooks();
    }

    @Test
    public void shouldPrintMenuItems() {
        System.setOut(new PrintStream(outContent));
        String actual = "--> List books   --> Search books   --> Quit   " +
                "\n";
        assertEquals(testMenu.printMenu(), actual);
    }

    @Test
    public void shouldPrintAHeader() {
        System.setOut(new PrintStream(outContent));
        String actual = "Book_name Author_name Published_Year " +
                "\n";
        assertEquals(testMenu.printHeader(), actual);
    }

    @Test
    public void getsIntegerWhenWithinBoundsOfOneToTen() throws Exception {
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask(anyString())).thenReturn(3);

        assertEquals(getBoundIntegerFromUser(asker), 3);
    }

    @Test
    public void asksForNewIntegerWhenOutsideBoundsOfOneToTen() throws Exception {
        IntegerAsker asker = mock(IntegerAsker.class);
        when(asker.ask("Give a number between 1 and 10")).thenReturn(99);
        when(asker.ask("Wrong number, try again.")).thenReturn(3);

        getBoundIntegerFromUser(asker);

        verify(asker).ask("Wrong number, try again.");
    }

    //@Test
    //public void shouldProcessUserInput() {
    //    String input = "list books";
    //    assertEquals("list books", testMenu.getInputFromUser(
    //            new Scanner(input)));
    //}

    //@Test
    //public void shouldQuitWhenChosen() {
    //    String expected = "Thanks for your visit. Bye!";
    //    String input = "quit";
    //    Scanner scanner = new Scanner(System.in);
    //    String actual = testMenu.getInputFromUser(scanner);
    //    assertEquals(expected, actual);
    //}

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


