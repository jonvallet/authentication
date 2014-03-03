package com.jonvallet.authentication;

import java.io.*;
import java.util.Date;
import java.util.Map;

/**
 * Created by jvalletw on 3/03/14.
 */
public class FilePersister implements Persister {

    private String usersFile;

    public FilePersister (String fileName){
        usersFile = fileName;
    }

    @Override
    public void persistUsers(Users users) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(usersFile);
            users.users.store(fileOutputStream, "Users from "+new Date()+" saved.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Users loadUsers() {

        Users users = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(usersFile);
            users = new Users();
            users.users.load(fileInputStream);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
