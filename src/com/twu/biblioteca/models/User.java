package com.twu.biblioteca.models;

import com.twu.biblioteca.helpers.InputAsker;

public class User implements InputAsker{

    //public static String password;
    private final String libraryNumber;
    private final String hashPassword;
    private final String name;
    private final String emailAdress;
    private final String phoneNumber;

    @Override
    public String ask() {
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
            this.hashPassword = hashPassword;
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

    public String getHashPassword() {
        return hashPassword;
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
