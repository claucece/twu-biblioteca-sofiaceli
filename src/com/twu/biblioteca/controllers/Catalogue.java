package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.Element;
import com.twu.biblioteca.helpers.ErrorPrinter;
import com.twu.biblioteca.helpers.UserCatalogueHelper;
import com.twu.biblioteca.models.Inventory;
import com.twu.biblioteca.models.ElementsList;

public class Catalogue implements UserCatalogueHelper, ErrorPrinter {

    private Inventory inventory;

    public Catalogue(Inventory inventory) {
        this.inventory = inventory;
    }

    public String putInformationInColumns(Inventory inventory) {
        Column column = new Column();
        for (Element element : inventory.returnInventoryOfElements()) {
            String title = element.getTitle();
            String author = element.getAuthor();
            String published_year = element.getPublishedYear();
            String type = element.getType();
            String genre = element.getGenre();
            column.addLine(title, author, published_year, type, genre);
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
                printSucessfulCheckout(inventory);
                return true;
            } else if (title.equals("quit")) {
                return true;
            }
        }
        printUnsucessfulCheckout(inventory);
        return false;
    }

    public void addToInventory(Element element, Inventory inventory) {
        if (!(inventory.returnInventoryOfElements().contains(element))) {
            inventory.returnInventoryOfElements().add(element);
            printSucessfulReturn(inventory);
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
        printUnsucessfulReturn(inventory);
        return false;
    }

    @Override
    public StringBuilder printSucessfulCheckout(Inventory inventory) {
        StringBuilder successfullCheckOut = new StringBuilder("Thank you! Enjoy the " + inventory.getName());
        System.out.println(inStockColor + successfullCheckOut + resetStockColor);
        return successfullCheckOut;
    }

    @Override
    public StringBuilder printUnsucessfulCheckout(Inventory inventory) {
        StringBuilder error = new StringBuilder(inventory.getName() + " not found. Please, select a " + inventory.getName() + " from the list.");
        System.out.println(notInStockColor + error + resetStockColor);
        return error;
    }

    @Override
    public StringBuilder printSucessfulReturn(Inventory inventory) {
        StringBuilder successfullReturn = new StringBuilder("Thank you for returning the " + inventory.getName());
        System.out.println(inStockColor + successfullReturn + resetStockColor);
        return successfullReturn;
    }

    @Override
    public StringBuilder printUnsucessfulReturn(Inventory inventory) {
        StringBuilder error = new StringBuilder("That is not a valid " + inventory.getName() + " to return.");
        System.out.println(notInStockColor + error + resetStockColor);
        return error;
    }

    @Override
    public StringBuilder printError() {
        StringBuilder error = new StringBuilder("That is already in stock");
        System.out.println(errorColor + error + resetErrorColor);
        return error;
    }
}
