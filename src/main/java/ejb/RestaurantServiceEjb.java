package ejb;

import daos.RestaurantDao;
import entities.RestaurantEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * Created by carlmccann2 on 26/06/2017.
 */

@Stateless
@Local
public class RestaurantServiceEjb implements RestaurantService {
    @EJB
    RestaurantDao restaurantDao;
    @Override
    public void addRestaurant(RestaurantEntity restaurantEntity) {
        System.out.println("RestaurantService.addRestaurant");
        restaurantDao.addRestaurant(restaurantEntity);
    }
}
