package com.twu.biblioteca.Helpers;

import com.twu.biblioteca.controllers.SlowPrinter;
import com.twu.biblioteca.models.ColorInventory;

public interface Separator {

    SlowPrinter printer = new SlowPrinter();
    String resetColor = ColorInventory.getColor("RESET");
    String color = ColorInventory.getColor("CYAN");

    String printSeparator();

}
