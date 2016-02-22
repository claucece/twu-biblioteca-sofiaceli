package com.twu.biblioteca;

public class Home {

    public String printWelcomeMessage() {
        String welcome = "Hello and welcome to 'Alexandros', the Library Management " +
                "System from The Bangalore Public Library!" +
                "\n" +
                "Keep reading to see the lists of books available";
        System.out.print(welcome);
        return welcome;
    }

    public String printHomeLogo() {
        String logo = "#     _   _   _   _   _   _   _   _   _   _  \n" +
                "#    / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ / \\ \n" +
                "#   ( A ( l ( e ( x ( a ( n ( d ( r ( o ( s )\n" +
                "#    \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ \\_/ ";
        System.out.println(logo);
        return logo;
    }

    public String printBreak() {
        String breakLine = "===================================================";
        System.out.println(breakLine);
        return breakLine;
    }

    public String selectFromMenu() {
        String menu = "Please, select an option from the menu below:";
        System.out.println(menu);
        return menu;
    }

}
