package entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by carlmccann2 on 12/06/2017.
 */

@NamedQueries({
        @NamedQuery(name = "getUser", query = "from UserEntity user where user.username=:username and user.password=:password")
})


@Entity
@Table(name="users")
public class UserEntity implements Serializable {
    private Integer user_id;
    private String first_name;
    private String last_name;
    private String username;
    private String email;
    private String password;

    private Set<ReviewEntity> user_reviews;
    private Set<CommentEntity> user_comments;
    private Set<LikeEntity> user_likes;

    public UserEntity() {
    }

    public UserEntity(String first_name, String last_name, String username, String email, String password, Set<ReviewEntity> user_reviews, Set<CommentEntity> user_comments, Set<LikeEntity> user_likes) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.user_reviews = user_reviews;
        this.user_comments = user_comments;
        this.user_likes = user_likes;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "user_id=" + user_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", user_reviews=" + user_reviews +
                ", user_comments=" + user_comments +
                ", user_likes=" + user_likes +
                '}';
    }

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY) @Column(name="user_id")
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    @Column(name="first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @Column(name="last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Column(name="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="user_id")
    public Set<ReviewEntity> getUser_reviews() {
        return user_reviews;
    }

    public void setUser_reviews(Set<ReviewEntity> user_reviews) {
        this.user_reviews = user_reviews;
    }

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="user_id")
    public Set<CommentEntity> getUser_comments() {
        return user_comments;
    }

    public void setUser_comments(Set<CommentEntity> user_comments) {
        this.user_comments = user_comments;
    }

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName="user_id")
    public Set<LikeEntity> getUser_likes() {
        return user_likes;
    }

    public void setUser_likes(Set<LikeEntity> user_likes) {
        this.user_likes = user_likes;
    }
}
