package rest;

import ejb.UserService;
import entities.UserEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by carlmccann2 on 16/06/2017.
 */
@Path("user")
public class UserRest {
    @EJB
    UserService userService;

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/{username}/{password}")
    public UserEntity getUser(@PathParam("username") String username, @PathParam("password") String password){
        return userService.getUser(username, password);
    }

    @POST @Consumes(MediaType.APPLICATION_JSON) @Path("/add")
    public void addUser(UserEntity user){
        userService.addUser(user);
    }
}
