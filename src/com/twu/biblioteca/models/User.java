package com.twu.biblioteca.models;

import java.io.PrintStream;
import java.util.Scanner;

public class User {

    private final String libraryNumber;
    private String hashPassword;
    private final String name;
    private final String emailAdress;
    private final String phoneNumber;

    static Scanner scanner = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);

    //@Override
    public static String ask() {
        out.println("Please, enter a new password");
        return scanner.nextLine().toLowerCase();
    }

    public static class Builder {
        private String libraryNumber;
        private String hashPassword;
        private String name = "user";
        private String emailAdress = "user@usermail.com";
        private String phoneNumber = "6038200";

        public Builder (String libraryNumber, String hashPassword) {
            this.libraryNumber = libraryNumber;
            this.hashPassword = hashPassword = ask();
        }

        public Builder name(String value) {
            name = value;
            return this;
        }

        public Builder emailAdress(String value) {
            emailAdress = value;
            return this;
        }

        public Builder phoneNumber(String value) {
            phoneNumber = value;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        libraryNumber = builder.libraryNumber;
        hashPassword = builder.hashPassword;
        name = builder.name;
        emailAdress = builder.emailAdress;
        phoneNumber = builder.phoneNumber;
    }


    public String getLibraryNumber() {
        return libraryNumber;
    }

    public int getHashPassword() {
        return hashPassword.hashCode();
    }

    public String getName() {
        return name;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
