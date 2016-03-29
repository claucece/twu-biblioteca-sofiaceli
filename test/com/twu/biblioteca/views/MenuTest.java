package com.twu.biblioteca.views;

import com.twu.biblioteca.controllers.Catalogue;
import com.twu.biblioteca.models.Inventory;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;


import java.io.*;

import static org.junit.Assert.*;

public class MenuTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu menu;
    private Catalogue catalogue;
    Inventory inventory;

    @Before
    public void setUp() {
        menu = new Menu();
        inventory = inventory.valueOf();
        catalogue = new Catalogue(inventory);
    }

    @Test
    public void shouldPrintMenuItems() {
        System.setOut(new PrintStream(outContent));
        String actual = "--> List books   --> Quit   " +
                "\n";
        assertEquals(menu.printMenu(), actual);
    }

}


