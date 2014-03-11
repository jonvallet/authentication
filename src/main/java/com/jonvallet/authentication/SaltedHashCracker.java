package com.jonvallet.authentication;

import java.util.Date;

/**
 * Created by jvalletw on 5/03/14.
 */
public class SaltedHashCracker {


    public static void main (String [] argsv){

        Hasher hasher = new Hasher();

        String hashToBreak = "49C2D840522EA37576109CB6F69BFBC33723230A116FA1024557DBF6F6FF0EE9";
        String salt = "802863448282462273";
        System.out.println("Trying to crack: "+hashToBreak);

        Date date = new Date();

        int i = 0;
        String testUser;
        String calculatedHash;

        do{
            testUser = String.format("%08d", i);
            calculatedHash = hasher.hashSha_2(testUser+salt);
            i++;
        }while (!hashToBreak.equals(calculatedHash));
        
        Date date2 = new Date();
        date2.setTime(date2.getTime()-date.getTime());
        System.out.println("User found: "+testUser +" in " +date2.getTime()/1000+" seconds");

    }

}
