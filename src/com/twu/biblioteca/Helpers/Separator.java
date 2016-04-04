package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.ColorModel.ColorList;

public interface Separator {

    SlowPrinter printer = new SlowPrinter();
    String resetColor = ColorList.getColor("RESET");
    String color = ColorList.getColor("CYAN");
    StringBuilder breakLine = new StringBuilder("===================================================");

    String printSeparator();

}
