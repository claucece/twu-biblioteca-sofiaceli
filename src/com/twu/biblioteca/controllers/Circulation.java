package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.UserMessagesHelper;
import com.twu.biblioteca.models.ElementsList;
import com.twu.biblioteca.models.Inventory;

public class Circulation implements ErrorPrinter {

    private Inventory inventory;
    private UserMessagesHelper userMessages;

    public Circulation(Inventory inventory) {
        this.inventory = inventory;
        userMessages = new UserMessagesHelper();
    }

    public String putInformationInColumns(Inventory inventory) {
        Column column = new Column();
        for (Element element : inventory.returnInventoryOfElements()) {
            String title = element.getTitle();
            String author = element.getAuthor();
            String published_year = element.getPublishedYear();
            String type = element.getType();
            String genre = element.getGenre();
            String rating = element.getRating();
            column.addLine(title, author, published_year, type, genre, rating);
        }
        return column.toString();
    }

    public boolean removeFromInventory(Element element, Inventory inventory) {
        return inventory.returnInventoryOfElements().remove(element);
    }

    public boolean isACheckout(String title, Inventory inventory) {
        for (Element element : inventory.returnInventoryOfElements()) {
            if (element.getTitle().matches(title.toLowerCase())) {
                removeFromInventory(element, inventory);
                userMessages.printSucessfulCheckout(inventory);
                return true;
            } else if (title.equals("quit")) {
                return true;
            }
        }
        userMessages.printUnsucessfulCheckout(inventory);
        return false;
    }

    public void addToInventory(Element element, Inventory inventory) {
        if (!(inventory.returnInventoryOfElements().contains(element))) {
            inventory.returnInventoryOfElements().add(element);
            userMessages.printSucessfulReturn(inventory);
        } else {
            printError();
        }
    }

    public boolean isAReturn(String title, Inventory inventory) {
        for (Element element : ElementsList.VALUES) {
            String elementToReturn = element.getTitle();
            if (elementToReturn.matches(title.toLowerCase())) {
                addToInventory(element, inventory);
                return true;
            } else if (title.equals("quit")) {
                return true;
            }
        }
        userMessages.printUnsucessfulReturn(inventory);
        return false;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("That is already in stock");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
