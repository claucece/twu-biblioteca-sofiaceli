package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.models.color.ColorList;

public class Home implements Separator {

    public String printWelcomeMessage() {
        String welcomeMessage = "Hello and welcome to 'Pnakotus', the Library Management " +
                "System from The Bangalore Public Library! \n" +
                "Keep reading to see the lists of elements available.";
        String color = ColorList.getColor("BOLD");
        System.out.print(color + welcomeMessage + resetColor);
        return welcomeMessage;
    }

    public String printHomeLogo() {
        String logo = "#     _   _   _   _   _   _   _   _    \n" +
                "#    / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n" +
                "#   ( p ( n ( a ( k ( o ( t ( u ( s )\n" +
                "#    \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ";
        System.out.println(logo);
        printSeparator();
        return logo;
    }

    @Override
    public String printSeparator() {
        String separator = color + breakLine + resetColor;
        System.out.println(color + breakLine + resetColor);
        return separator;
    }
}
