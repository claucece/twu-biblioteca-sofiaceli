package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.models.BookModel.Book;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public interface Inventory extends ErrorPrinter {

    List<Element> getList();

    boolean isListEqualToInventory();

    List<Element> returnInventoryOfElements();

    List<Element> addElement();

    @Override
    StringBuilder printError();
}
