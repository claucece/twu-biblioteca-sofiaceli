package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.ColorModel.ColorList;
import com.twu.biblioteca.models.Inventory;

public interface ErrorPrinter {

    String errorColor = ColorList.getColor("RED");
    String resetErrorColor = ColorList.getColor("RESET");

    StringBuilder printError();

}
