package com.jonvallet.authentication;

import java.util.Date;

/**
 * Created by jvalletw on 5/03/14.
 */
public class SaltedHashCracker extends Thread {



    private int start;
    private int jump;
    private String hash;
    private String salt;

    public SaltedHashCracker(int start, int jump, String hash, String salt){
        this.start = start;
        this.jump = jump;
        this.hash = hash;
        this.salt = salt;
    }

    public void run (){
        Hasher hasher = new Hasher();

        Date date = new Date();

        String testUser = null;
        String calculatedHash;

        for (int i = start; i < 100000000; i = i + jump ){
            testUser = String.format("%08d", i);
            calculatedHash = hasher.hashSha_2(testUser+salt);
            if (hash.equals(calculatedHash)){
                Date date2 = new Date();
                date2.setTime(date2.getTime()-date.getTime());
                System.out.println("User found: "+testUser +" in " +date2.getTime()/1000+" seconds");
                break;
            }
        }



    }

    public static void main (String [] argsv){

        String hashToBreak = "49C2D840522EA37576109CB6F69BFBC33723230A116FA1024557DBF6F6FF0EE9";
        String salt = "802863448282462273";

        System.out.println("Trying to crack: "+hashToBreak);

        int threads = 1;

        for (int i = 0; i < threads; i++){
            new SaltedHashCracker(i, threads, hashToBreak, salt).start();
        }

    }

}
