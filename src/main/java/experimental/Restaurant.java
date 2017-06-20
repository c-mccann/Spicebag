package experimental;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by carlmccann2 on 26/05/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant {

    private Integer id;
    private String name;
    private String address;
    private String locality;
    private String city;
    private String zipCode;
    private Integer cityId;
    private Double latitude;
    private Double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipcode) {
        this.zipCode = zipcode;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "experimental.Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", cityId=" + cityId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
