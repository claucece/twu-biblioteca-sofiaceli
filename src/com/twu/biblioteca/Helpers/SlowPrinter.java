package com.twu.biblioteca.helpers;

public class SlowPrinter {

    private static boolean stopPrinter;

    private static synchronized void requestStop() {
        stopPrinter = true;
    }

    private static synchronized boolean stopRequested() {
        return stopPrinter;
    }

    public void printSlowly(String message, long millisPerChar) {
        while (!stopRequested()) {
        for (int i = 0; i < message.length(); i++) {
                System.out.print(message.charAt(i));
                try {
                    Thread.sleep(millisPerChar);
                    requestStop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
