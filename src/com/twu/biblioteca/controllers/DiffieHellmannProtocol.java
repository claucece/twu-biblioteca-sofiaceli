package com.twu.biblioteca.controllers;

import com.twu.biblioteca.helpers.InputAsker;
import com.twu.biblioteca.models.user.User;

import javax.crypto.*;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class DiffieHellmannProtocol implements InputAsker{

    String mode;
    int aliceLen;
    KeyAgreement userKeyAgree;
    KeyAgreement bibliotecaKeyAgree;
    DHParameterSpec dhSkipParamSpec1;
    X509EncodedKeySpec x509KeySpec;
    byte[] cleartext;
    byte[] ciphertext;

    DHParameterSpec dhSkipParamSpec = new DHParameterSpec(skip1024Modulus,
            skip1024Base);

    private static final byte skip1024ModulusBytes[] = {
            (byte)0xF4, (byte)0x88, (byte)0xFD, (byte)0x58,
            (byte)0x4E, (byte)0x49, (byte)0xDB, (byte)0xCD,
            (byte)0x20, (byte)0xB4, (byte)0x9D, (byte)0xE4,
            (byte)0x91, (byte)0x07, (byte)0x36, (byte)0x6B,
            (byte)0x33, (byte)0x6C, (byte)0x38, (byte)0x0D,
            (byte)0x45, (byte)0x1D, (byte)0x0F, (byte)0x7C,
            (byte)0x88, (byte)0xB3, (byte)0x1C, (byte)0x7C,
            (byte)0x5B, (byte)0x2D, (byte)0x8E, (byte)0xF6,
            (byte)0xF3, (byte)0xC9, (byte)0x23, (byte)0xC0,
            (byte)0x43, (byte)0xF0, (byte)0xA5, (byte)0x5B,
            (byte)0x18, (byte)0x8D, (byte)0x8E, (byte)0xBB,
            (byte)0x55, (byte)0x8C, (byte)0xB8, (byte)0x5D,
            (byte)0x38, (byte)0xD3, (byte)0x34, (byte)0xFD,
            (byte)0x7C, (byte)0x17, (byte)0x57, (byte)0x43,
            (byte)0xA3, (byte)0x1D, (byte)0x18, (byte)0x6C,
            (byte)0xDE, (byte)0x33, (byte)0x21, (byte)0x2C,
            (byte)0xB5, (byte)0x2A, (byte)0xFF, (byte)0x3C,
            (byte)0xE1, (byte)0xB1, (byte)0x29, (byte)0x40,
            (byte)0x18, (byte)0x11, (byte)0x8D, (byte)0x7C,
            (byte)0x84, (byte)0xA7, (byte)0x0A, (byte)0x72,
            (byte)0xD6, (byte)0x86, (byte)0xC4, (byte)0x03,
            (byte)0x19, (byte)0xC8, (byte)0x07, (byte)0x29,
            (byte)0x7A, (byte)0xCA, (byte)0x95, (byte)0x0C,
            (byte)0xD9, (byte)0x96, (byte)0x9F, (byte)0xAB,
            (byte)0xD0, (byte)0x0A, (byte)0x50, (byte)0x9B,
            (byte)0x02, (byte)0x46, (byte)0xD3, (byte)0x08,
            (byte)0x3D, (byte)0x66, (byte)0xA4, (byte)0x5D,
            (byte)0x41, (byte)0x9F, (byte)0x9C, (byte)0x7C,
            (byte)0xBD, (byte)0x89, (byte)0x4B, (byte)0x22,
            (byte)0x19, (byte)0x26, (byte)0xBA, (byte)0xAB,
            (byte)0xA2, (byte)0x5E, (byte)0xC3, (byte)0x55,
            (byte)0xE9, (byte)0x2F, (byte)0x78, (byte)0xC7
    };

    private static final BigInteger skip1024Modulus
            = new BigInteger(1, skip1024ModulusBytes);

    private static final BigInteger skip1024Base = BigInteger.valueOf(2);


    public KeyPair generateUserKeyPair() throws Exception {
        System.out.println("ALICE: Generate DH keypair ...");
        KeyPairGenerator userKpairGen = KeyPairGenerator.getInstance("DH");
        userKpairGen.initialize(dhSkipParamSpec);
        KeyPair userKpair = userKpairGen.generateKeyPair();
        initializeUserAgreement(userKpair);
        return userKpair;
    }

    public KeyPair generateBibliotecaKeyPair(PublicKey userPubKey) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, ShortBufferException {
        dhSkipParamSpec1 = ((DHPublicKey) userPubKey).getParams();
        System.out.println("BIBLIOTECA: Generate DH keypair ...");
        KeyPairGenerator bibliotecaKpairGen = KeyPairGenerator.getInstance("DH");
        bibliotecaKpairGen.initialize(dhSkipParamSpec1);
        KeyPair bibliotecaKpair = bibliotecaKpairGen.generateKeyPair();
        initializeBibliotecaAgreement(bibliotecaKpair);
        return bibliotecaKpair;
    }

    public KeyAgreement initializeUserAgreement(KeyPair userKeys) throws Exception {
        System.out.println("USER: Initialization ...");
        userKeyAgree = KeyAgreement.getInstance("DH");
        userKeyAgree.init(userKeys.getPrivate());
        userEncondesAndSendsToBiblioteca(userKeys);
        return userKeyAgree;
    }

    public KeyAgreement initializeBibliotecaAgreement(KeyPair bibliotecaKeys) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, InvalidKeySpecException, ShortBufferException {
        System.out.println("BIBLIOTECA: Initialization ...");
        bibliotecaKeyAgree = KeyAgreement.getInstance("DH");
        bibliotecaKeyAgree.init(bibliotecaKeys.getPrivate());
        bibliotecaEncondesAndSendsToUser(bibliotecaKeys);
        return bibliotecaKeyAgree;
    }

    public byte[] userEncondesAndSendsToBiblioteca(KeyPair userKeys) throws Exception {
        byte[] userPubKeyEnc = userKeys.getPublic().getEncoded();
        instantiatesUserPubKey(userPubKeyEnc);
        return userPubKeyEnc;
    }

    public byte[] bibliotecaEncondesAndSendsToUser(KeyPair bibliotecaKeys) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, ShortBufferException {
        byte[] bibliotecaPubKeyEnc = bibliotecaKeys.getPublic().getEncoded();
        instantiatesBibliotecaPubKey(bibliotecaPubKeyEnc);
        return bibliotecaPubKeyEnc;
    }

    public PublicKey instantiatesUserPubKey(byte[] userPubKeyEnc) throws Exception {
        KeyFactory bibliotecaKeyFac = KeyFactory.getInstance("DH");
        x509KeySpec = new X509EncodedKeySpec(userPubKeyEnc);
        PublicKey userPubKey = bibliotecaKeyFac.generatePublic(x509KeySpec);
        generateBibliotecaKeyPair(userPubKey);
        executePhase1OnBiblioteca(userPubKey);
        SecretKey bibliotecaDesKey = bibliotecaKeyAgree.generateSecret("DES");
        SecretKey userDesKey = userKeyAgree.generateSecret("DES");
        System.out.println(bibliotecaEncryptsUsingDES(bibliotecaDesKey));
        System.out.println(userDecryptsUsingDES(userDesKey));
        //System.out.println(toHexString(generateSecretUserKey()));
        //System.out.println(toHexString(generateSecretBibliotecaKey()));
        return userPubKey;
    }

    public PublicKey instantiatesBibliotecaPubKey(byte[] bibliotecaPubKeyEnc) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeySpecException, InvalidKeyException, ShortBufferException {
        KeyFactory userKeyFac = KeyFactory.getInstance("DH");
        x509KeySpec = new X509EncodedKeySpec(bibliotecaPubKeyEnc);
        PublicKey bibliotecaPubKey = userKeyFac.generatePublic(x509KeySpec);
        executePhase1OnUser(bibliotecaPubKey);
        return bibliotecaPubKey;
    }

    public Key executePhase1OnUser(PublicKey key) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        System.out.println("USER: Execute PHASE1 ...");
        return userKeyAgree.doPhase(key, true);
    }

    public Key executePhase1OnBiblioteca(PublicKey key) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        System.out.println("BIBLIOTECA: Execute PHASE1 ...");
        return bibliotecaKeyAgree.doPhase(key, true);
    }

    public byte[] generateSecretUserKey() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException {
        byte[] aliceSharedSecret = userKeyAgree.generateSecret();
        aliceLen = aliceSharedSecret.length;
        return aliceSharedSecret;
    }

    public byte[] generateSecretBibliotecaKey() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, ShortBufferException {
        byte[] bobSharedSecret = bibliotecaKeyAgree.generateSecret();
        return bobSharedSecret;
    }

    public byte[] bibliotecaEncryptsUsingDES(SecretKey bibliotecaSecretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher bibliotecaCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        bibliotecaCipher.init(Cipher.ENCRYPT_MODE, bibliotecaSecretKey);
        String password = null;
        User user = new User.Builder().libraryNumber("001-0001").password(password).name("user").emailAdress("user@usermail.com").phoneNumber("603-200").build();
        cleartext = Integer.toString(user.getHashPassword()).getBytes();
        System.out.println(user.getHashPassword());
        ciphertext = bibliotecaCipher.doFinal(cleartext);
        return ciphertext;
    }

    public Cipher userDecryptsUsingDES(SecretKey userSecretKey) throws Exception {
        Cipher userCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        userCipher.init(Cipher.DECRYPT_MODE, userSecretKey);
        byte[] recovered = userCipher.doFinal(ciphertext);
        if (!java.util.Arrays.equals(cleartext, recovered))
            throw new Exception("DES in CBC mode recovered text is " +
                    "different from cleartext");
        System.out.println("DES in ECB mode recovered text is " +
                "same as cleartext");
        return userCipher;
    }

    public void run(String mode) throws Exception {
        generateUserKeyPair();
    }

    @Override
    public String ask() {
        out.println("Please, enter a new password");
        return scanner.nextLine().toLowerCase();
    }
}
