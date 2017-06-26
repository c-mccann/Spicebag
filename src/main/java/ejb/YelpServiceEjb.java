package ejb;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.RestaurantEntity;
import yelpjsonobjects.Restaurant;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by carlmccann2 on 23/06/2017.
 */

@Stateless
@Local
public class YelpServiceEjb implements YelpService {
    @Override
    public List<RestaurantEntity> getTwentyNearesRestaurants(Double latitude, Double longitude) {
        System.out.println("YelpService.getTwentyNearestRestaurants");

//        String urlString = "https://api.yelp.com/v3/businesses/search?term=restaurants,chinese&latitude=53.350140&longitude=-6.266155";
        String urlString = "https://api.yelp.com/v3/businesses/search?term=restaurants,chinese&latitude=" + latitude.toString() +
                "&longitude=" + longitude.toString();
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestProperty("Authorization", "Bearer " + doPostForAccessToken().getAccess_token());
            connection.setRequestProperty("Authorization", "Bearer " + "h_DjmuNf6GhKjoyPHSIW-vuPr_WpdLmPnVWsxvpy6KkxP38T7Dn58lUH7cfSKj9YISeqDb4kiYmYXSsnVvcOr77IWtl1PWTwOYpI_VlVuZY124zTsy8iQ1EKVv43WXYx");
            connection.setRequestMethod("GET");


            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + urlString);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //print result
            String responseString = response.toString();
//            System.out.println("Response: " + responseString);


            ObjectMapper mapper = new ObjectMapper();

            // index of [ and ] remove the outer businesses info from the json to get  to the array of restaurants
            List<Restaurant> restaurants = Arrays.asList(mapper.readValue(responseString.substring(responseString.indexOf("["), responseString.lastIndexOf("]") + 1), Restaurant[].class));


            List<RestaurantEntity> restaurantEntities = Restaurant.convertListToEntities(restaurants);
            return restaurantEntities;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
