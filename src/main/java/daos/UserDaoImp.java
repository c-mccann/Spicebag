package daos;

import entities.UserEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Created by carlmccann2 on 16/06/2017.
 */
@Stateless
@Local
public class UserDaoImp implements UserDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public UserEntity getUser(String username, String password) {
        Query query = em.createNamedQuery("getUser");
        query.setParameter("username", username);
        query.setParameter("password", password);
        return (UserEntity) query.getSingleResult();
    }

    @Override
    public void addUser(UserEntity user) {
        em.persist(user);
    }
}
