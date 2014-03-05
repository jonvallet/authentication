package com.jonvallet.authentication;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by jvalletw on 4/03/14.
 */
public class Hasher {

    SecureRandom random = new SecureRandom();

    public String hashSha_2(String password) {

        MessageDigest sha_2;

        try {
            sha_2 = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        byte [] passBytes = password.getBytes();

        byte [] passHash = sha_2.digest(passBytes);


        return DatatypeConverter.printHexBinary(passHash).toUpperCase();
    }

    public String getRandomSalt(){
        String result = String.valueOf(random.nextLong());
        return result;
    }

    public String hashSha_2(String password, int reruns){
        String hash= password;
        for (int i = 0; i < reruns; i++){
            hash = hashSha_2(hash);
        }

        return hash;
    }
}
