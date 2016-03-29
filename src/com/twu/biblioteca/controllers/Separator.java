package com.twu.biblioteca.controllers;

import com.twu.biblioteca.models.ColorInventory;

public interface Separator {

    SlowPrinter printer = new SlowPrinter();
    String resetColor = ColorInventory.getColor("RESET");
    String color = ColorInventory.getColor("CYAN");

    String printSeparator();

}
