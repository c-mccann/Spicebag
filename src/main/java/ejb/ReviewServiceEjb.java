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
        System.out.println("ReviewService.getAllNewestFirst");
        return reviewDao.getAllNewestFirst();
    }

    @Override
    public ReviewEntity getReviewById(int id) {
        System.out.println("ReviewService.getReviewById");
        return reviewDao.getReviewById(id);
    }

    @Override
    public void addReview(ReviewEntity reviewEntity) {
        System.out.println("ReviewService.addReview");
        reviewDao.addReview(reviewEntity);
    }
}
