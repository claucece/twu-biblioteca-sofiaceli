package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.models.color.ColorList;

public class Home implements Separator {

    public String printWelcomeMessage() {
        String welcomeMessage = "Hello and welcome to 'Alexandros', the Library Management " +
                "System from The Bangalore Public Library!" +
                "\n" +
                "Keep reading to see the lists of books available";
        String color = ColorList.getColor("BOLD");
        System.out.print(color + welcomeMessage + resetColor);
        return welcomeMessage;
    }

    public String printHomeLogo() {
        String logo = "#     _   _   _   _   _   _   _   _   _   _  \n" +
                "#    / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n" +
                "#   ( A ( l ( e ( x ( a ( n ( d ( r ( o ( s )\n" +
                "#    \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ";
        System.out.println(logo);
        printSeparator();
        return logo;
    }

    public void selectFromMenu() {
        String menu = "Please, select an option from the menu below:";
        System.out.println(menu);
        printSeparator();
    }

    @Override
    public String printSeparator() {
        String breakLine = "===================================================";
        System.out.println(color + breakLine + resetColor);
        return breakLine;
    }
}
