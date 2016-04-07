package com.twu.biblioteca.models;

import com.twu.biblioteca.models.user.User;
import com.twu.biblioteca.models.user.UserList;

import java.io.PrintStream;
import java.util.Scanner;

public class DHKeyAgreement2 {

    static Scanner scanner = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);



    public static void main(String argv[]) throws Exception {

        String mode = "USE_SKIP_DH_PARAMS";

        //DiffieHellmannProtocol keyAgree = new DiffieHellmannProtocol();
        //keyAgree.handlePassword(mode);
        for (User user : UserList.VALUES) {
            user.getHashPassword();
        }
        //User user = new User.Builder().libraryNumber("001-0001").password("lo").name("user").emailAdress("user@usermail.com").phoneNumber("603-200").build();
        //user.getHashPassword();


    }


}

