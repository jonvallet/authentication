package com.jonvallet.authentication;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by jvalletw on 4/03/14.
 */
public class Hasher {

    public String hashSha_2(String password) {

        MessageDigest sha_2;

        try {
            sha_2 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        byte [] passBytes = password.getBytes();

        byte [] passHash = sha_2.digest(passBytes);


        return DatatypeConverter.printHexBinary(passHash);
    }
}
