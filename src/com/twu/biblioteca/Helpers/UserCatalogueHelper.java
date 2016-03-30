package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.ColorInventory;

public interface UserCatalogueHelper {

    String inStockColor = ColorInventory.getColor("BLUE");
    String notInStockColor = ColorInventory.getColor("RED");
    String resetStockColor = ColorInventory.getColor("RESET");

    StringBuilder printSucessfulCheckout();

    StringBuilder printUnsucessfulCheckout();

    StringBuilder printSucessfulReturn();

    StringBuilder printUnsucessfulReturn();
}
