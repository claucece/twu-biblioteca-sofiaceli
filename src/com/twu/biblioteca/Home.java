package com.twu.biblioteca;

public class Home {

    private Menu menu;

    public String printWelcomeMessage() {
        String welcome = "Hello and welcome to 'Alexandros', the Library Management " +
                "System from The Bangalore Public Library!" +
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

    public Menu setMenu(Menu menu) {
        this.menu = menu;
        return menu;
    }

    public Menu getMenu() {
        return menu;
    }

}
