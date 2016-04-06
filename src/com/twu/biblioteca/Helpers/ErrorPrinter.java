package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.color.ColorList;

public interface ErrorPrinter {

    String errorColor = ColorList.getColor("RED");
    String resetErrorColor = ColorList.getColor("RESET");

    StringBuilder printError();

}
