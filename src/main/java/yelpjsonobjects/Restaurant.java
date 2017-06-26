package yelpjsonobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import entities.RestaurantEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by carlmccann2 on 26/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {

    private String name;
    private Location location;
    private Coordinates coordinates;
    private String phone;


    public Restaurant() {
    }

    public Restaurant(String name, Location location, Coordinates coordinates, String phone) {
        this.name = name;
        this.location = location;
        this.coordinates = coordinates;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", coordinates=" + coordinates +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static List<RestaurantEntity> convertListToEntities(List<Restaurant> restaurants){
        List<RestaurantEntity> returnList = new ArrayList<>();

        for(Restaurant r: restaurants){
            String address = r.getLocation().getAddress1() + " " + r.getLocation().getCity() + " " + r.getLocation().getZip_code();
            RestaurantEntity restaurantEntity = new RestaurantEntity(r.getName(),
                    address,
                    BigDecimal.valueOf(r.getCoordinates().getLatitude()),
                    BigDecimal.valueOf(r.getCoordinates().getLongitude()),
                    r.getPhone());

            returnList.add(restaurantEntity);

        }
        return returnList;
    }
}
