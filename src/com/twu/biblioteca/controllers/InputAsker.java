package com.twu.biblioteca.controllers;

import java.io.PrintStream;
import java.util.Scanner;

public class InputAsker {

    private Scanner scanner;
    private PrintStream out;

    public InputAsker() {
        scanner =  new Scanner(System.in);
        out = new PrintStream(System.out);
    }

    public String ask() {
        out.println("Please, select a choice");
        String input = scanner.nextLine().toLowerCase();
        return input;
    }
}
