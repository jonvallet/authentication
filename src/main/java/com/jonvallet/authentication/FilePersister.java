package com.jonvallet.authentication;

import java.io.*;
import java.util.Date;
import java.util.Map;

/**
 * Created by jvalletw on 3/03/14.
 */
public class FilePersister implements Persister {

    private final String FILE_NAME = "users.properties";

    @Override
    public void persistUsers(Users users) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            users.users.store(fileOutputStream, "Users from "+new Date()+" saved.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Users loadUsers() {

        Users users = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            users = new Users();
            users.users.load(fileInputStream);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
