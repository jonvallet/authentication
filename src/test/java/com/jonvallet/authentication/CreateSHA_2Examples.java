package com.jonvallet.authentication;

import org.junit.Test;

/**
 * Created by jvalletw on 4/03/14.
 */
public class CreateSHA_2Examples {

    @Test
    public void createSH2_examples(){

        Users users = new Users();
        Hasher hasher = new Hasher();

        users.addUser("jon",hasher.hashSha_2("08091978"));
        users.addUser("admin",hasher.hashSha_2("adminadmin"));
        users.addUser("tiger",hasher.hashSha_2("scott"));
        Persister persister = new FilePersister("sha_2_user.properties");
        persister.persistUsers(users);

    }


}
