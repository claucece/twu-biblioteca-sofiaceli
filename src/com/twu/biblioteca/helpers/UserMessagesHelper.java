package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.color.ColorList;
import com.twu.biblioteca.models.Inventory;

import static com.twu.biblioteca.helpers.Separator.printer;

public class UserMessagesHelper {

    String inStockColor = ColorList.getColor("BLUE");
    String notInStockColor = ColorList.getColor("RED");
    String resetStockColor = ColorList.getColor("RESET");
    String newLine = "\n";


    public StringBuilder printSucessfulCheckout(Inventory inventory) {
        StringBuilder successfullCheckOut = new StringBuilder("Thank you! Enjoy the " + inventory.getName());
        System.out.println(inStockColor + successfullCheckOut + resetStockColor);
        return successfullCheckOut;
    }

    public StringBuilder printUnsucessfulCheckout(Inventory inventory) {
        StringBuilder error = new StringBuilder(inventory.getName() + " not found. Please, select a " + inventory.getName() + " from the list.");
        System.out.println(notInStockColor + error + resetStockColor);
        return error;
    }

    public StringBuilder printSucessfulReturn(Inventory inventory) {
        StringBuilder successfullReturn = new StringBuilder("Thank you for returning the " + inventory.getName());
        System.out.println(inStockColor + successfullReturn + resetStockColor);
        return successfullReturn;
    }

    public StringBuilder printUnsucessfulReturn(Inventory inventory) {
        StringBuilder error = new StringBuilder("That is not a valid " + inventory.getName() + " to return.");
        System.out.println(notInStockColor + error + resetStockColor);
        return error;
    }

    public boolean printSucessfulSessionCreation() {
        String successfulSession = "User authenticated. New session created.";
        printer.printSlowly(successfulSession, 40);
        System.out.println(newLine);
        return true;
    }

    public boolean printUnSucessfulSessionCreation() {
        String unsuccessfulSession = "User not authenticated. New session not created.";
        printer.printSlowly(unsuccessfulSession, 40);
        System.out.println(newLine);
        return false;
    }
}
