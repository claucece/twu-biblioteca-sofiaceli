package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.colorModel.ColorList;

public interface ErrorPrinter {

    String errorColor = ColorList.getColor("RED");
    String resetErrorColor = ColorList.getColor("RESET");

    StringBuilder printError();

}
