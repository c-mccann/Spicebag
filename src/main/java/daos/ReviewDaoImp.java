package daos;

import entities.ReviewEntity;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by carlmccann2 on 17/06/2017.
 */
@Stateless
@Local
public class ReviewDaoImp implements ReviewDao {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<ReviewEntity> getAllNewestFirst() {
        Query query = em.createNamedQuery("getAllNewestFirst");
        return query.getResultList();
    }

    @Override
    public ReviewEntity getReviewById(int id) {
        Query query = em.createNamedQuery("getReviewById");
        query.setParameter("id", id);
        return (ReviewEntity) query.getSingleResult();
    }

    @Override
    public void addReview(ReviewEntity reviewEntity) {
        em.persist(reviewEntity);
    }
}
