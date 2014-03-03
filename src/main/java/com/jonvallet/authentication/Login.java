package com.jonvallet.authentication;

import javax.ws.rs.*;
import java.net.HttpURLConnection;

/**
 * Created by jvalletw on 28/02/14.
 */
@Path("/login")
public class Login {

    @GET
    public String login (){
        return "Service is up.";
    }

    @POST
    public void login(String user, String password){

        Users users = new FilePersister("no-hash-users.properties").loadUsers();

        if (users.checkUserPassword(user,password))

        throw new WebApplicationException(HttpURLConnection.HTTP_FORBIDDEN);
    }

}
