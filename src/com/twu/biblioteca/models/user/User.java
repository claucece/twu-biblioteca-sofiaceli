package com.twu.biblioteca.models.user;

import com.twu.biblioteca.anotations.*;

import java.io.PrintStream;
import java.util.Scanner;


public class User {

    @Format (message = "Should have this format: '000-0000'")
    public final String libraryNumber;

    public String hashPassword;

    @NotNull (message = "Could not be assigned null")
    @Size(message = "Invalid size")
    public final String name;

    @Email(message = "Should have this format: 'name@servicemail.com'")
    public final String emailAdress;

    @Phone(message = "Should have this format: '000-000'")
    public final String phoneNumber;

    static Scanner scanner = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);

    public static String ask() {
        out.println("Please, enter a new password:");
        return scanner.toString().toLowerCase();
    }

    public static class Builder {
        private String libraryNumber;
        private String hashPassword;
        private String name = "user";
        private String emailAdress = "user@usermail.com";
        private String phoneNumber = "6038200";

        public Builder libraryNumber(String value) {
            libraryNumber = value;
            return this;
        }

        public Builder password(String value) {
            hashPassword = ask();
            return this;
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
