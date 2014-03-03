package com.jonvallet.authentication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jvalletw on 3/03/14.
 */
public class Users {

    private Map<String, String> database = new HashMap<>();

    public void addUser(String username, String password) {
        database.put(username, password);
    }

    public boolean checkUserPassword(String username, String password) {

        String storedPassword = database.get(username);

        boolean userOk = (storedPassword!= null && storedPassword.equals(password));

        return userOk;
    }

}
