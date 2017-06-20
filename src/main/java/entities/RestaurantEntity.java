package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by carlmccann2 on 12/06/2017.
 */

@Entity
@Table(name="restaurants")
public class RestaurantEntity implements Serializable{

    private Integer restaurant_id;
    private String name;
    private String address;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String phone_number;

    private Set<ReviewEntity> restaurant_reviews;


    public RestaurantEntity() {
    }

    public RestaurantEntity(String name, String address, BigDecimal latitude, BigDecimal longitude, String phone_number, Set<ReviewEntity> restaurant_reviews) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone_number = phone_number;
        this.restaurant_reviews = restaurant_reviews;
    }

    @Override
    public String toString() {
        return "RestaurantEntity{" +
                "restaurant_id=" + restaurant_id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", phone_number='" + phone_number + '\'' +
                ", restaurant_reviews=" + restaurant_reviews +
                '}';
    }

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="restaurant_id")
    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name="latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Column(name="longitude")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Column(name="phone_number")
    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="restaurant_id", referencedColumnName="restaurant_id")
    public Set<ReviewEntity> getRestaurant_reviews() {
        return restaurant_reviews;
    }

    public void setRestaurant_reviews(Set<ReviewEntity> restaurant_reviews) {
        this.restaurant_reviews = restaurant_reviews;
    }
}
