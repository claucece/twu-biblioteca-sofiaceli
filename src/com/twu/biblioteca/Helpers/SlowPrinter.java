package com.twu.biblioteca.helpers;

public class SlowPrinter {

    //private static volatile boolean stopPrinter;

    public void printSlowly(String message, long millisPerChar) {
        //while (!stopPrinter) {
        for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
                try {
                    Thread.sleep(millisPerChar);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            //stopPrinter = false;
            //}
            //Thread.interrupted();
            //stopPrinter = true;
        }
    }
}
