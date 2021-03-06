package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.helpers.ErrorPrinter;

import java.util.Collections;
import java.util.List;

public abstract class Inventory implements ErrorPrinter {

    private String name = "inventory";
    private static List<Element> elements;

    public String getName() {
        return name;
    }

    protected List<Element> getList() {
        return elements;
    }

    public boolean isListEqualToInventory() {
        return Collections.disjoint(getList(), ElementsList.VALUES) && !(getList().isEmpty());
    }

    public List<Element> returnInventoryOfElements() {
        if (isListEqualToInventory()) {
            addElement();
        } else if (getList().isEmpty()) {
            printError();
        }
        return elements;
    }

    protected List<Element> addElement() {
        return elements;
    }

}
