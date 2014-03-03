package com.jonvallet.authentication;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

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
    public Response login(@FormParam("user") String user,@FormParam("password") String password) throws URISyntaxException {

        System.out.println("Trying to check user :"+user);

        Users users = new FilePersister("no-hash-users.properties").loadUsers();


        if (!users.checkUserPassword(user,password)){
            return Response.status(Response.Status.FORBIDDEN).entity("Forbidden 403").build();
        }

        return Response.ok("Login successfull").build();

    }

}
