package com.jonvallet.authentication;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.net.URISyntaxException;

/**
 * Created by jvalletw on 28/02/14.
 */
@Path("/login")
public class Login {

    public static final String FORBIDDEN_403 = "Forbidden 403.";
    public static final String LOGIN_SUCCESSFUL = "Login successful.";
    public static final int HASH_RERUNS = 1000000;

    @GET
    public String login (){
        System.out.println("Service is up");
        return "Service is up!.";
    }

    @POST
    @Path("/no-hash")
    public String login(@FormParam("user") String user,@FormParam("password") String password) throws URISyntaxException {


        Users users = new FilePersister("no-hash-users.properties").loadUsers();

        return getResponse(user, password, users);

    }

    @POST
    @Path("/sha2")
    public String login_sha2(@FormParam("user") String user,@FormParam("password") String password) throws URISyntaxException {

        Users users = new FilePersister("sha_2_user.properties").loadUsers();

        Hasher hasher = new Hasher();

        return getResponse(user, hasher.hashSha_2(password), users);

    }

    @POST
    @Path("/sha2-salted")
    public String login_sha2Salted(@FormParam("user") String user,@FormParam("password") String password) throws URISyntaxException {

        Users users = new FilePersister("sha_2_user_salted.properties").loadUsers();

        Hasher hasher = new Hasher();

        return getResponse(user, hasher.hashSha_2(password+users.getSalt(user)), users);

    }

    @POST
    @Path("/sha2-slow-salted")
    public String login_sha2SlowSalted(@FormParam("user") String user,@FormParam("password") String password) throws URISyntaxException {

        Users users = new FilePersister("sha_2_slow_user_salted.properties").loadUsers();

        Hasher hasher = new Hasher();

        return getResponse(user, hasher.hashSha_2(password+users.getSalt(user), Login.HASH_RERUNS), users);

    }


    private String getResponse(String user, String password, Users users) {

        if (!users.checkUserPassword(user,password)){
            return FORBIDDEN_403;
        }

        return LOGIN_SUCCESSFUL;
    }


}
