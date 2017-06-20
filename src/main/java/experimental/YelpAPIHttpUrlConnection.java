package experimental;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


/**
 * Created by carlmccann2 on 26/05/2017.
 *
 * https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
 */
public class YelpAPIHttpUrlConnection {


    public static void main(String[] args) {
        YelpAPIHttpUrlConnection yelpAPIHttpUrlConnection = new YelpAPIHttpUrlConnection();


        yelpAPIHttpUrlConnection.twentyNearestChineseRestaurantsGet();
    }

    public void twentyNearestChineseRestaurantsGet(){
        System.out.println("Testing 2 - Send HTTP GET request");

        String urlString = "https://api.yelp.com/v3/businesses/search?term=restaurants,chinese&latitude=53.350140&longitude=-6.266155";
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
            System.out.println("Response: " + responseString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public YelpApiAuthenticationResponse doPostForAccessToken(){
        System.out.println("Testing 1 - Send HTTP POST request for authentication credentials");
//        https://stackoverflow.com/questions/40574892/how-to-send-post-request-with-x-www-form-urlencoded-body
        String urlString = "https://api.yelp.com/oauth2/token";
        String urlParameters  = "grant_type=client_credentials&client_id=Ygx1JTJcuda5Y64IKMXYYw&client_secret=n7dBRZdXiCDfvxYpH9yAinp4fPQ9Y7JooAh2MZQb4Hq9yoqeOreAOvln8CvLpnHg";
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;
        URL url = null;

        try {
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("charset", "utf-8");
            connection.setRequestProperty("Content-Length", Integer.toString(postDataLength ));
            connection.setUseCaches(false);
            try(DataOutputStream wr = new DataOutputStream(connection.getOutputStream())) {
                wr.write( postData );
            }
//            https://stackoverflow.com/questions/5769717/how-can-i-get-an-http-response-body-as-a-string-in-java
            InputStream in = connection.getInputStream();
            String encoding = connection.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = IOUtils.toString(in, encoding);

            ObjectMapper mapper = new ObjectMapper();
            YelpApiAuthenticationResponse response = mapper.readValue(body, YelpApiAuthenticationResponse.class);
            System.out.println(response.toString());

            return response;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
