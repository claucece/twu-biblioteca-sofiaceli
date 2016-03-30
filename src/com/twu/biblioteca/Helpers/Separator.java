package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.ColorInventory;

public interface Separator {

    SlowPrinter printer = new SlowPrinter();
    String resetColor = ColorInventory.getColor("RESET");
    String color = ColorInventory.getColor("CYAN");

    String printSeparator();

}
