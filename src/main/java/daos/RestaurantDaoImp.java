package daos;

import entities.RestaurantEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by carlmccann2 on 26/06/2017.
 */

@Stateless
@Local
public class RestaurantDaoImp implements RestaurantDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public void addRestaurant(RestaurantEntity restaurantEntity) {
        em.persist(restaurantEntity);

        Query q = em.createNamedQuery("postRestaurantCheck").setParameter("name", restaurantEntity.getName());

        List<RestaurantEntity> existingRestaurants;
        try {
             existingRestaurants = q.getResultList();
            if (existingRestaurants.size() > 0){
                em.persist(restaurantEntity);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
