package com.twu.biblioteca.models;

import javax.crypto.spec.*;

import com.twu.biblioteca.controllers.DiffieHellmannProtocol;

/**
 * This program executes the Diffie-Hellman key agreement protocol
 * between 2 parties: Alice and Bob.
 *
 * By default, preconfigured parameters (1024-bit prime modulus and base
 * generator used by SKIP) are used.
 * If this program is called with the "-gen" option, a new set of
 * parameters is created.
 */

public class DHKeyAgreement2 {

    public static void main(String argv[]) throws Exception {
        // try {
        String mode = "USE_SKIP_DH_PARAMS";

        DiffieHellmannProtocol keyAgree = new DiffieHellmannProtocol();
        keyAgree.run(mode);
    }
}

