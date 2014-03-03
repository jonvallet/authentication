package com.jonvallet.authentication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jvalletw on 3/03/14.
 */
public class AuthenticationLoginTest {

    public static final String USER = "jon";
    public static final String PASSWORD = "08091978";

    @Test
    public void testCheckUserPasswordCorrectReturnsTrue(){

        Users users = new Users();
        users.addUser(USER, PASSWORD);

        Assert.assertTrue(users.checkUserPassword(USER, PASSWORD));


    }

    @Test
    public void testCheckUserPasswordIncorrectReturnsFalse(){

        Users users = new Users();
        users.addUser(USER, PASSWORD);

        Assert.assertFalse(users.checkUserPassword("lol", PASSWORD));
        Assert.assertFalse(users.checkUserPassword(USER, "lol"));

    }

}
