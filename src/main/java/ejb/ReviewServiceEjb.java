package ejb;

import daos.ReviewDao;
import entities.ReviewEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by carlmccann2 on 17/06/2017.
 */

@Stateless
@Local
public class ReviewServiceEjb implements ReviewService {
    @EJB
    ReviewDao reviewDao;

    @Override
    public List<ReviewEntity> getAllNewestFirst() {
        return reviewDao.getAllNewestFirst();
    }

    @Override
    public ReviewEntity getReviewById(int id) {
        return reviewDao.getReviewById(id);
    }
}
