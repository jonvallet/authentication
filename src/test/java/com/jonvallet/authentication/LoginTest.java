package com.jonvallet.authentication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jvalletw on 4/03/14.
 */
public class LoginTest {

    @Test
         public void testNoHashLogin() throws Exception{

        String response = new Login().login("jon", "08091978");

        Assert.assertEquals(Login.LOGIN_SUCCESSFUL, response);

    }

    @Test
    public void testSha2Hash() throws Exception{

        String response = new Login().login_sha2("jon", "08474517");

        Assert.assertEquals(Login.LOGIN_SUCCESSFUL, response);

    }

    @Test
    public void testSha2HashSalted() throws Exception{

        String response = new Login().login_sha2Salted("jon", "08699771");

        Assert.assertEquals(Login.LOGIN_SUCCESSFUL, response);

    }

    @Test
    public void testSha2SlowHashSalted() throws Exception{

        String response = new Login().login_sha2SlowSalted("jon", "08699771");

        Assert.assertEquals(Login.LOGIN_SUCCESSFUL, response);

    }

}
