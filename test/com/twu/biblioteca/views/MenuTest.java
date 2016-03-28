package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.controllers.InputAsker;
import com.twu.biblioteca.models.Inventory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.io.*;

import static org.junit.Assert.*;

public class MenuTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu testMenu;
    private Catalogue catalogue;
    Inventory inventory;

    @Before
    public void setUp() {
        testMenu = new Menu();
        inventory = new Inventory();
        catalogue = new Catalogue(inventory);
    }

    @Test
    public void shouldPrintMenuItems() {
        System.setOut(new PrintStream(outContent));
        String actual = "--> List books   --> Search books   --> Quit   " +
                "\n";
        assertEquals(testMenu.printMenu(), actual);
    }

    @Test
    public void shouldQuitWhenAsked() {
        InputAsker asker = mock(InputAsker.class);
        when(asker.ask()).thenReturn("quit");
        assertEquals(testMenu.defineOuput(asker), "Thanks for your visit. Bye!");
    }

}


