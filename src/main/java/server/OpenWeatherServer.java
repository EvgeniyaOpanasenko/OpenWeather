package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import model.Main;
import model.Weather;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * Created by Lisa on 2/13/2017.
 */
public class OpenWeatherServer {

    static final Logger logger = Logger.getLogger(OpenWeatherServer.class);

    public static void main(String[] args) throws Exception {

        final String USER_AGENT = "Opera/15.0";// statistics?

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Kyiv,ua&APPID=54bc4d8bf9a017e8233a54124a55fcce";

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);
        HttpResponse response = client.execute(request);

        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();

        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);

            System.out.println(result);


            /*Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(result);

            System.out.println(json);*/

            // TODO just testing different possibilities
           /* Object obj= JSONValue.parse(resAsAString);
            JSONObject jsonObject = (JSONObject) obj;


           *//* Main mainObj = (Main) jsonObject.get("main");
            System.out.println(mainObj.toString());;*//*
            //String country = (String) jsonObject.get("country");
            Main temp_min = (Main) jsonObject.get("main");
            //long temp_max = (Long) jsonObject.get("temp_max");
            System.out.println(temp_min.getTemp());*/
        }

// to post methods
    /*  String postUrl = "http://api.openweathermap.org/data/2.5/weather?q=Kyiv,ua&APPID=54bc4d8bf9a017e8233a54124a55fcce";
        Gson gson = new Gson();
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(postUrl);
        StringEntity postingString =
        new StringEntity(gson.toJson(Clouds.class));//gson.tojson() converts your pojo to json
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse  response = httpClient.execute(post)*/
        ;

    }
}