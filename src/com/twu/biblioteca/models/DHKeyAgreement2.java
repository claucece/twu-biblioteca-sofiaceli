package com.twu.biblioteca.models;

import javax.crypto.spec.*;

import com.twu.biblioteca.controllers.DiffieHellmannProtocol;
import com.twu.biblioteca.helpers.InputAsker;

import java.io.PrintStream;
import java.util.Scanner;

public class DHKeyAgreement2 {

    static Scanner scanner = new Scanner(System.in);
    static PrintStream out = new PrintStream(System.out);



    public static void main(String argv[]) throws Exception {

        String mode = "USE_SKIP_DH_PARAMS";

        DiffieHellmannProtocol keyAgree = new DiffieHellmannProtocol();
        keyAgree.run(mode);


    }


}

