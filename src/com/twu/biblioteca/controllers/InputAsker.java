package com.twu.biblioteca.controllers;

import java.io.PrintStream;
import java.util.Scanner;

public interface InputAsker {

    Scanner scanner = new Scanner(System.in);
    PrintStream out = new PrintStream(System.out);

    public String ask();

}
