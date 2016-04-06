package com.twu.biblioteca.helpers;

import java.io.PrintStream;
import java.util.Scanner;

public interface InputAsker {

    Scanner scanner = new Scanner(System.in);
    PrintStream out = new PrintStream(System.out);

    String ask();

}
