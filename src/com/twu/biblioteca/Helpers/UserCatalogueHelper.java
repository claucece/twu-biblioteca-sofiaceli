package com.twu.biblioteca.Helpers;

import com.twu.biblioteca.models.ColorInventory;

public interface UserCatalogueHelper {

    String inStockColor = ColorInventory.getColor("BLUE");
    String notInStockColor = ColorInventory.getColor("RED");
    String resetStockColor = ColorInventory.getColor("RESET");

    String printSucessfulCheckout();

    String printUnsucessfulCheckout();

    String printSucessfulReturn();

    String printUnsucessfulReturn();
}
