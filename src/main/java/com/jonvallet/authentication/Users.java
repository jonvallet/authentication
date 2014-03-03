package com.jonvallet.authentication;

import java.util.Properties;

/**
 * Created by jvalletw on 3/03/14.
 */
public class Users{

    public Properties users = new Properties();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean checkUserPassword(String username, String password) {

        String storedPassword = users.getProperty(username);

        boolean userOk = (storedPassword!= null && storedPassword.equals(password));

        return userOk;
    }

}
