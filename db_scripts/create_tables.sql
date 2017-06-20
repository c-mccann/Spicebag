DROP DATABASE spicebag;
CREATE SCHEMA IF NOT EXISTS spicebag DEFAULT CHARACTER SET utf8;
USE spicebag;



CREATE TABLE IF NOT EXISTS spicebag.users (
  user_id           INT NOT NULL AUTO_INCREMENT,
  first_name        VARCHAR(20) NULL,
  last_name         VARCHAR(20) NULL,
  username          VARCHAR(20) NOT NULL,
  email             VARCHAR(40) NOT NULL,
  password          Varchar(30) NOT NULL,

  PRIMARY KEY(user_id)
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS spicebag.restaurants (
  restaurant_id     INT NOT NULL AUTO_INCREMENT,

  name              VARCHAR(30) NOT NULL,
  address           VARCHAR(50) NOT NULL,
  latitude          DECIMAL(9,6) NOT NULL,
  longitude         DECIMAL(9,6) NOT NULL,
  phone_number      VARCHAR(10) NOT NULL,

  PRIMARY KEY(restaurant_id)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS spicebag.reviews (
  review_id         INT NOT NULL AUTO_INCREMENT,
  spicebag_photo    BLOB NOT NULL,
  star_rating       INT NOT NULL,
  created           DATETIME NOT NULL,
  restaurant_id     INT NOT NULL,
  user_id           INT NOT NULL,
  review            VARCHAR(1500) NOT NULL,

  CONSTRAINT restaurant_id_in_reviews_fk
  FOREIGN KEY (restaurant_id) REFERENCES restaurants(restaurant_id),
  CONSTRAINT user_id_in_reviews_fk
  FOREIGN KEY(user_id) REFERENCES users(user_id),

  PRIMARY KEY(review_id)
)
  ENGINE = InnoDB;








CREATE TABLE IF NOT EXISTS spicebag.comments (
  comment_id        INT NOT NULL AUTO_INCREMENT,
  user_id           INT NOT NULL,
  review_id         INT NOT NULL,
  comment           VARCHAR(200) NOT NULL,
  created           DATETIME NOT NULL,

  CONSTRAINT user_id_in_comments_fk
  FOREIGN KEY(user_id) REFERENCES users(user_id),
  CONSTRAINT review_id_in_comments_fk
  FOREIGN KEY(review_id) REFERENCES reviews(review_id),


  PRIMARY KEY(comment_id)
)
  ENGINE = InnoDB;



CREATE TABLE IF NOT EXISTS spicebag.likes (
  like_id     INT NOT NULL AUTO_INCREMENT,
  user_id     INT NOT NULL,
  review_id   INT NOT NULL,

  CONSTRAINT user_id_in_likes_fk
  FOREIGN KEY(user_id) REFERENCES users(user_id),
  CONSTRAINT review_id_in_likes_fk
  FOREIGN KEY(review_id) REFERENCES reviews(review_id),

  PRIMARY KEY(like_id)
)
  ENGINE = InnoDB;