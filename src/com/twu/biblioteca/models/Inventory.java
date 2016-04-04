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

    public List<Element> getList() {
        return elements;
    }

    public boolean isListEqualToInventory() {
        return Collections.disjoint(getList(), ListOfElements.VALUES) && !(getList().isEmpty());
    }

    public List<Element> returnInventoryOfElements() {
        if (isListEqualToInventory()) {
            addElement();
        } else if (getList().isEmpty()) {
            printError();
        }
        return elements;
    }

    public List<Element> addElement() {
        for (Element element : ListOfElements.VALUES) {
                elements.add(element);
            }
        return elements;
    }

    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("No available books!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
