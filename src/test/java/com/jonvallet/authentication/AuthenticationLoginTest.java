package com.jonvallet.authentication;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.FileHandler;

/**
 * Created by jvalletw on 3/03/14.
 */
public class AuthenticationLoginTest {

    public static final String USER = "jon";
    public static final String PASSWORD = "08091978";
    public static final String USER_TEST_PROPERTIES = "user_test.properties";

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

    @Test
    public void testPreviousSavedUsersStillExistAfterRestore(){

        Users users = new Users();
        users.addUser(USER,PASSWORD);
        Persister persisterFirstInstance = new FilePersister(USER_TEST_PROPERTIES);

        persisterFirstInstance.persistUsers(users);

        Persister persisterSecondInstance = new FilePersister(USER_TEST_PROPERTIES);

        Users usersSecondInstance = persisterSecondInstance.loadUsers();

        Assert.assertTrue(usersSecondInstance.checkUserPassword(USER,PASSWORD));


    }

}
