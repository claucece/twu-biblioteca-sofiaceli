package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.ColorInventory;

public interface ErrorPrinter {

    String errorColor = ColorInventory.getColor("RED");
    String resetErrorColor = ColorInventory.getColor("RESET");

    StringBuilder printError();

}
