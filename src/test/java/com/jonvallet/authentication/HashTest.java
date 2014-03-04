package com.jonvallet.authentication;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jvalletw on 4/03/14.
 */
public class HashTest {

    public static final String PASSWORD = "08091978";

    @Test
    public void testSHA_2(){
        String expectedValue = "8545e8eab7e254b6ffee56baf211a35e5fc1749fba035ae313394f7ce8c85a7a";
        String actualValue = new Hasher().hashSha_2(PASSWORD);

        Assert.assertEquals(expectedValue.toUpperCase(), actualValue.toUpperCase());

    }

}
