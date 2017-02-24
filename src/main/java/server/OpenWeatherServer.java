package server;

import com.google.gson.*;
import model.Main;
import model.Weather;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import sun.misc.IOUtils;

import javax.print.DocFlavor;
import javax.xml.ws.Response;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

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

        //StringBuffer result = new StringBuffer();
        StringBuilder result = new StringBuilder();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line); // JsonSimple Object
        }
        System.out.println(result);

        String json = result.toString();

        Gson gson = new Gson();
        Weather page = gson.fromJson(json, Weather.class);

        Main weather = new Main();

        System.out.println(weather.getPressure());
        //System.out.println(weather.getPressure());

    }
}

