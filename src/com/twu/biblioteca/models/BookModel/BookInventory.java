package com.twu.biblioteca.models.bookModel;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.ListOfElements;

import java.util.LinkedList;
import java.util.List;

public class BookInventory extends Inventory {

    private static List<Element> books;
    private String name = "book";

    public BookInventory() {
        books = new LinkedList<Element>();
        for (Element element : ListOfElements.VALUES) {
            if (element.getClass() == Book.class) {
                books.add(element);
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Element> getList() {
        return books;
    }

    @Override
    public List<Element> returnInventoryOfElements() {
        if (isListEqualToInventory()) {
            addElement();
        } else if (getList().isEmpty()) {
            printError();
        }
        return books;
    }

    @Override
    public List<Element> addElement() {
        for (Element book : ListOfElements.VALUES) {
            if (book.getClass() == Book.class) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("No available books!");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
