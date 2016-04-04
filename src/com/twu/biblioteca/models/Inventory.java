package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.helpers.ErrorPrinter;
import java.util.List;

public interface Inventory extends ErrorPrinter {

    List<Element> getList();

    boolean isListEqualToInventory();

    List<Element> returnInventoryOfElements();

    List<Element> addElement();

    @Override
    StringBuilder printError();
}
