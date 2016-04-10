package com.twu.biblioteca.views;

import com.twu.biblioteca.helpers.Separator;
import com.twu.biblioteca.models.color.ColorList;

public class Home implements Separator {

    public String printWelcomeMessage() {
        String welcomeMessage = "Hello and welcome to 'Alexandros', the Library Management " +
                "System from The Bangalore Public Library! \n" +
                "In reality, this is the library from the lost city of Pnakotus \n" +
                "created by the Great Race of Yith. May knowledge be always by their side \n" +
                "for their mind is older than its bodily form!\n" +
                "We accept you, stanger, to dive into the knowledge of this library.\n" +
                "Keep reading to see the lists of elements available";
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
