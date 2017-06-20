package experimental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by carlmccann2 on 26/05/2017.
 *
 * https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 */
public class ZomatoAPIHttpUrlConnection {


    public static void main(String[] args) {
        ZomatoAPIHttpUrlConnection zomatoAPIHttpUrlConnection = new ZomatoAPIHttpUrlConnection();

        System.out.println("Testing 1 - Send HTTP GET request");

        try {
            zomatoAPIHttpUrlConnection.sendGet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendGet() throws IOException {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        String urlString = "https://developers.zomato.com/api/v2.1/search?q=Dublin&start=0&cuisines=25";
        URL url = new URL(urlString);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        conn.setRequestProperty("user-key", "d0764d297dd537c4c85289b240c0330f");
        conn.setRequestProperty("Accept", "application/json");


        int responseCode = conn.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + urlString);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        String responseString = response.toString();
        System.out.println("Response: " + responseString);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<Restaurant> restaurants = new ArrayList<>();

        String restaurantsArrayString =
                responseString.substring(responseString.indexOf("["), responseString.length() - 1);


        restaurants.addAll(chineseRestaurantResponseParser(restaurantsArrayString));




        double noOfResults  = new Double(responseString.split(",")[0].split(":")[1]);
        if(noOfResults > 100) noOfResults = 100;

        int noOfRequests = (int) Math.round(noOfResults / 20);



        for (int i = 1; i < noOfRequests; i++) {
            System.out.println(urlString.indexOf("&start"));
            String newUrl = urlString.substring(0, urlString.indexOf("&start")) + "&start=" + (i * 20) + "&cuisines=25";
            if(i == noOfRequests - 1){
                newUrl += "&count=" + ((int) (noOfResults % 20));
            }

            url = new URL(newUrl);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            conn.setRequestProperty("user-key", "d0764d297dd537c4c85289b240c0330f");
            conn.setRequestProperty("Accept", "application/json");


            responseCode = conn.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + newUrl);
            System.out.println("Response Code : " + responseCode);

            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            restaurantsArrayString =
                    responseString.substring(responseString.indexOf("["), responseString.length() - 1);

            System.out.println(responseString);

            restaurants.addAll(chineseRestaurantResponseParser(restaurantsArrayString));

        }



        for(Restaurant r: restaurants){
            System.out.println(r.getName());
        }

    }

    public List<Restaurant> chineseRestaurantResponseParser(String restaurantsArrayString){
        List<Restaurant> restaurants = new ArrayList<>();

        String[] objs = restaurantsArrayString.split("\\{");

        for (int i = 1; i < objs.length; i += 5) {
            Restaurant restaurant = new Restaurant();

            String[] blockOne = objs[i + 2].split(":");
            String[] blockTwo = objs[i + 3].split(":");
            String[] blockThree = objs[i + 4].split(":");

            String id = blockOne[3].split(",")[0];
            String name = blockOne[4].split(",")[0];

            String address = "";
            List<String> addressList = new ArrayList(Arrays.asList(blockTwo[1].split(",")));
            addressList.remove(addressList.size() - 1);

            for (String s: addressList) {
                address += s;
            }

            String locality = blockTwo[2].split(",")[0];
            String city = blockTwo[3].split(",")[0];
            String cityId = blockTwo[4].split(",")[0];
            String latitude = blockTwo[5].split(",")[0];
            String longitude = blockTwo[6].split(",")[0];
            String zipCode = blockTwo[7].split(",")[0];

            restaurant.setId(new Integer(id.substring(1, id.length() - 1)));
            restaurant.setName(name.substring(1, name.length() - 1));
            restaurant.setAddress(address.substring(1, address.length() - 1));
            restaurant.setLocality(locality.substring(1, locality.length() - 1));
            restaurant.setCity(city.substring(1, city.length() - 1));
            restaurant.setCityId(new Integer(cityId));
            restaurant.setLatitude(new Double(latitude.substring(1, latitude.length() - 1)));
            restaurant.setLongitude(new Double(longitude.substring(1, longitude.length() - 1)));
            restaurant.setZipCode(zipCode.substring(1, zipCode.length() - 1));

            restaurants.add(restaurant);
        }
        return restaurants;
    }
}
