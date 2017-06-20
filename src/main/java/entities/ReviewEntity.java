package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

/**
 * Created by carlmccann2 on 12/06/2017.
 */

@NamedQueries({
        @NamedQuery(name = "getAllNewestFirst", query="FROM ReviewEntity review ORDER BY review.created DESC"),
        @NamedQuery(name = "getReviewById", query="FROM ReviewEntity review WHERE review.id=:id")
})


@Entity
@Table(name="reviews")
public class ReviewEntity implements Serializable {

    private Integer review_id;
    private String review;
    private byte[] spicebag_photo;
    private Integer star_rating;
    private Timestamp created;
    private RestaurantEntity restaurantEntity;
    private UserEntity userEntity;

    private Set<CommentEntity> review_comments;
    private Set<LikeEntity> review_Likes;


    public ReviewEntity() {
    }

    public ReviewEntity(Integer review_id, String review, byte[] spicebag_photo, Integer star_rating, Timestamp created, RestaurantEntity restaurantEntity, UserEntity userEntity, Set<CommentEntity> review_comments, Set<LikeEntity> review_Likes) {
        this.review_id = review_id;
        this.review = review;
        this.spicebag_photo = spicebag_photo;
        this.star_rating = star_rating;
        this.created = created;
        this.restaurantEntity = restaurantEntity;
        this.userEntity = userEntity;
        this.review_comments = review_comments;
        this.review_Likes = review_Likes;
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "review_id=" + review_id +
                ", review='" + review + '\'' +
                ", spicebag_photo=" + Arrays.toString(spicebag_photo) +
                ", star_rating=" + star_rating +
                ", timestamp=" + created +
                ", restaurantEntity=" + restaurantEntity +
                ", userEntity=" + userEntity +
                ", review_comments=" + review_comments +
                ", review_Likes=" + review_Likes +
                '}';
    }

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="review_id")
    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    @Column(name="spicebag_photo") @Lob
    public byte[] getSpicebag_photo() {
        return spicebag_photo;
    }

    public void setSpicebag_photo(byte[] spicebag_photo) {
        this.spicebag_photo = spicebag_photo;
    }

    @Column(name="star_rating")
    public Integer getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(Integer star_rating) {
        this.star_rating = star_rating;
    }

    @Column(name="created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp timestamp) {
        this.created = timestamp;
    }


    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "restaurant_id", referencedColumnName="restaurant_id")
    public RestaurantEntity getRestaurantEntity() {
        return restaurantEntity;
    }

    public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
        this.restaurantEntity = restaurantEntity;
    }

    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name = "user_id", referencedColumnName="user_id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="review_id", referencedColumnName="review_id")
    public Set<CommentEntity> getReview_comments() {
        return review_comments;
    }

    public void setReview_comments(Set<CommentEntity> review_comments) {
        this.review_comments = review_comments;
    }

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="review_id", referencedColumnName="review_id")
    public Set<LikeEntity> getReview_Likes() {
        return review_Likes;
    }

    public void setReview_Likes(Set<LikeEntity> review_Likes) {
        this.review_Likes = review_Likes;
    }

    @Column(name="review")
    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
