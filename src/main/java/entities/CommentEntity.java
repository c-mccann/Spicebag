package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by carlmccann2 on 12/06/2017.
 */

@Entity
@Table(name="comments")
public class CommentEntity implements Serializable {
    private Integer comment_id;
    private String comment;
    private Timestamp created;
    private UserEntity userEntity;
    private ReviewEntity reviewEntity;


    public CommentEntity() {
    }

    public CommentEntity(String comment, Timestamp created, UserEntity userEntity, ReviewEntity reviewEntity) {
        this.comment = comment;
        this.created = created;
        this.userEntity = userEntity;
        this.reviewEntity = reviewEntity;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", comment='" + comment + '\'' +
                ", timestamp=" + created +
                ", userEntity=" + userEntity +
                ", reviewEntity=" + reviewEntity +
                '}';
    }

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY) @Column(name="comment_id")
    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    @Column(name="comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Column(name="created")
    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "user_id")
    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "review_id")
    public ReviewEntity getReviewEntity() {
        return reviewEntity;
    }

    public void setReviewEntity(ReviewEntity reviewEntity) {
        this.reviewEntity = reviewEntity;
    }
}
