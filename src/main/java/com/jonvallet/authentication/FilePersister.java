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
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(usersFile);

            users = new Users();
            if (inputStream != null){
                users.users.load(inputStream);
                inputStream.close();
            }else {
                FileInputStream fileInputStream = new FileInputStream(usersFile);
                users.users.load(fileInputStream);
                fileInputStream.close();
            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
