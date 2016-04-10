package com.twu.biblioteca.helpers;

import com.twu.biblioteca.models.color.ColorList;
import com.twu.biblioteca.models.Inventory;

import static com.twu.biblioteca.helpers.Separator.printer;

public class UserMessagesHelper {

    private String inStockColor = ColorList.getColor("BLUE");
    private String notInStockColor = ColorList.getColor("RED");
    private String resetStockColor = ColorList.getColor("RESET");


    public void printSucessfulCheckout(Inventory inventory) {
        StringBuilder successfullCheckOut = new StringBuilder("Thank you! Enjoy the " + inventory.getName());
        System.out.println(inStockColor + successfullCheckOut + resetStockColor);
    }

    public void printUnsucessfulCheckout(Inventory inventory) {
        StringBuilder error = new StringBuilder(inventory.getName() + " not found. Please, select a " + inventory.getName() + " from the list.");
        System.out.println(notInStockColor + error + resetStockColor);
    }

    public void printSucessfulReturn(Inventory inventory) {
        StringBuilder successfullReturn = new StringBuilder("Thank you for returning the " + inventory.getName());
        System.out.println(inStockColor + successfullReturn + resetStockColor);
    }

    public void printUnsucessfulReturn(Inventory inventory) {
        StringBuilder error = new StringBuilder("That is not a valid " + inventory.getName() + " to return.");
        System.out.println(notInStockColor + error + resetStockColor);
    }

    public boolean printSucessfulSessionCreation() {
        String successfulSession = "You're allowed to the great Library!. May you find the knowledge you seek. \n" +
                "User authenticated. New session created. \n";
        printer.printSlowly(successfulSession, 40);
        return true;
    }

    public boolean printUnSucessfulSessionCreation() {
        String unsuccessfulSession = "    You're not allowed to the great Library! \n" +
                "    User not authenticated. New session not created. \n";
        printer.printSlowly(unsuccessfulSession, 40);
        return false;
    }
}
