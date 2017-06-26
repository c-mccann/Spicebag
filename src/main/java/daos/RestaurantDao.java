package daos;

import entities.RestaurantEntity;
import entities.ReviewEntity;

import java.util.List;

/**
 * Created by carlmccann2 on 17/06/2017.
 */
public interface RestaurantDao {
    void addRestaurant(RestaurantEntity restaurantEntity);
}
