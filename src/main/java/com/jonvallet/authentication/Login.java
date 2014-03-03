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
        System.out.println("Service is up");
        return "Service is up!.";
    }

    @POST
    @Path("/no-hash")
    public void login(@FormParam("user") String user,@FormParam("password") String password){

        System.out.println("Trying to check user :"+user);

        Users users = new FilePersister("no-hash-users.properties").loadUsers();

        if (!users.checkUserPassword(user,password)){
            throw new WebApplicationException(HttpURLConnection.HTTP_FORBIDDEN);
        }



    }

}
