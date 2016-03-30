package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.ColorList;

public interface UserCatalogueHelper {

    String inStockColor = ColorList.getColor("BLUE");
    String notInStockColor = ColorList.getColor("RED");
    String resetStockColor = ColorList.getColor("RESET");

    StringBuilder printSucessfulCheckout();

    StringBuilder printUnsucessfulCheckout();

    StringBuilder printSucessfulReturn();

    StringBuilder printUnsucessfulReturn();
}
