package com.jonvallet.authentication;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
    public boolean login(String user, String password){
        return false;
    }

}
