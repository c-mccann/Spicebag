package rest;

import ejb.ReviewService;
import entities.ReviewEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addReview(ReviewEntity reviewEntity){
        reviewService.addReview(reviewEntity);
    }
}
