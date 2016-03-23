package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.models.Inventory;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.io.*;
import java.util.Scanner;
import static org.junit.Assert.*;

public class MenuTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu testMenu;
    Catalogue catalogue;
    Inventory inventory;

    @Before
    public void setUp() {
        testMenu = new Menu();
        catalogue = new Catalogue();
        inventory = new Inventory();
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
    public void shouldQuitWhenAsked() {
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask()).thenReturn("quit");
        assertEquals(testMenu.setScene(asker), "Thanks for your visit. Bye!");
    }

    @Test
    public void shouldProcessUserInput() {
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask()).thenReturn("list books");
        assertEquals(testMenu.setScene(asker), catalogue.getBookInformation(inventory));
    }

//    @Test
//    public void shouldPrintErrorWhenNotChosen() {
//        String expected = "Select a valid option!";
//        String input = "lo";
//        String actual = testMenu.setScene(input);
//        assertEquals(expected, actual);
//    }
//

}


