package rest;

import ejb.RestaurantService;
import entities.RestaurantEntity;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by carlmccann2 on 26/06/2017.
 */
@Path("/restaurants")
public class RestaurantRest {
    @EJB
    RestaurantService restaurantService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRestaurant(RestaurantEntity restaurantEntity){
        restaurantService.addRestaurant(restaurantEntity);
    }
}
