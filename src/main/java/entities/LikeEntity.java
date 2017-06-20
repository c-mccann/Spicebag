package entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by carlmccann2 on 12/06/2017.
 */

@Entity
@Table(name="likes")
public class LikeEntity implements Serializable {
    private Integer like_id;
    private UserEntity userEntity;
    private ReviewEntity reviewEntity;


    public LikeEntity() {
    }

    public LikeEntity(UserEntity userEntity, ReviewEntity reviewEntity) {
        this.userEntity = userEntity;
        this.reviewEntity = reviewEntity;
    }


    @Override
    public String toString() {
        return "LikeEntity{" +
                "like_id=" + like_id +
                ", userEntity=" + userEntity +
                ", reviewEntity=" + reviewEntity +
                '}';
    }

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY) @Column(name="like_id")
    public Integer getLike_id() {
        return like_id;
    }

    public void setLike_id(Integer like_id) {
        this.like_id = like_id;
    }

    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="user_id", referencedColumnName="user_id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="review_id", referencedColumnName="review_id")
    public ReviewEntity getReviewEntity() {
        return reviewEntity;
    }

    public void setReviewEntity(ReviewEntity reviewEntity) {
        this.reviewEntity = reviewEntity;
    }
}
