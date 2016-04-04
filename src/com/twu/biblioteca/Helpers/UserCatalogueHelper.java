package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.ColorModel.ColorList;
import com.twu.biblioteca.models.Inventory;

public interface UserCatalogueHelper {

    String inStockColor = ColorList.getColor("BLUE");
    String notInStockColor = ColorList.getColor("RED");
    String resetStockColor = ColorList.getColor("RESET");

    StringBuilder printSucessfulCheckout(Inventory inventory);

    StringBuilder printUnsucessfulCheckout(Inventory inventory);

    StringBuilder printSucessfulReturn(Inventory inventory);

    StringBuilder printUnsucessfulReturn(Inventory inventory);
}
