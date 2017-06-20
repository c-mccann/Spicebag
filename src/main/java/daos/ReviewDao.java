package daos;

import entities.ReviewEntity;

import java.util.List;

/**
 * Created by carlmccann2 on 17/06/2017.
 */
public interface ReviewDao {
    List<ReviewEntity> getAllNewestFirst();
    ReviewEntity getReviewById(int id);
}
