package rest;

import ejb.YelpService;
import entities.RestaurantEntity;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by carlmccann2 on 23/06/2017.
 */

@Path("/yelp")
public class YelpRest {
    @EJB
    YelpService yelpService;


    @GET @Produces(MediaType.APPLICATION_JSON) @Path("/{latitude}/{longitude}")
    public List<RestaurantEntity> getTwentyNearestRestaurants(@PathParam("latitude") Double latitude, @PathParam("longitude") Double longitude){
        return yelpService.getTwentyNearesRestaurants(latitude, longitude);
    }
}
