package ejb;

import entities.RestaurantEntity;

import java.util.List;

/**
 * Created by carlmccann2 on 23/06/2017.
 */
public interface YelpService {
    List<RestaurantEntity> getTwentyNearesRestaurants(Double latitude, Double longitude);

}
