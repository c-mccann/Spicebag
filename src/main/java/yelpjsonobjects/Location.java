package yelpjsonobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by carlmccann2 on 23/06/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    private String address1, city, zip_code;

    public Location() {
    }

    public Location(String address1, String city, String zip_code) {
        this.address1 = address1;
        this.city = city;
        this.zip_code = zip_code;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @Override
    public String toString() {
        return "Location{" +
                "address1='" + address1 + '\'' +
                ", city='" + city + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }
}
