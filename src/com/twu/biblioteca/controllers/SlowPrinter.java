package com.twu.biblioteca.controllers;

public class SlowPrinter {

    public String slowPrint(String message, long millisPerChar) {
        for (int i = 0; i < message.length(); i++ ) {
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(millisPerChar);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return message;
    }
}
