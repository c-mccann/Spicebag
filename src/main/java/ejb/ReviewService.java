package ejb;

import entities.ReviewEntity;

import java.util.List;

/**
 * Created by carlmccann2 on 17/06/2017.
 */
public interface ReviewService {
    List<ReviewEntity> getAllNewestFirst();
    ReviewEntity getReviewById(int id);
    void addReview(ReviewEntity reviewEntity);
}
