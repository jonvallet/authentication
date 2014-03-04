package com.jonvallet.authentication;

import org.junit.Test;

/**
 * Created by jvalletw on 4/03/14.
 */
public class CreateSHA_2_Salted_Examples {

    @Test
    public void createSH2_examples(){

        Users users = new Users();
        Hasher hasher = new Hasher();


        addUsersSalted("jon","08091978", users, hasher);
        addUsersSalted("admin","adminadmin", users, hasher);
        addUsersSalted("tiger","scott", users, hasher);
        addUsersSalted("system","oraclepass", users, hasher);
        addUsersSalted("sys","oraclepass", users, hasher);
        Persister persister = new FilePersister("sha_2_user_salted.properties");
        persister.persistUsers(users);

    }

    private void addUsersSalted(String user, String password, Users users, Hasher hasher) {
        String salt = hasher.getRandomSalt();
        users.addUser(user, hasher.hashSha_2(password+salt));
        users.addSalt(user,salt);
    }


}
