package rest;

import ejb.ReviewService;
import entities.ReviewEntity;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by carlmccann2 on 17/06/2017.
 */
@Path("/reviews")
public class ReviewRest {
    @EJB
    ReviewService reviewService;

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/getAllNewestFirst")
    public List<ReviewEntity> getAllNewestFirst(){
        return reviewService.getAllNewestFirst();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) @Path("/{id}")
    public ReviewEntity getReviewById(@PathParam("id") int id){
        return reviewService.getReviewById(id);
    }
}
