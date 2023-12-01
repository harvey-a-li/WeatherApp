package com.example.weatherapp;

import org.json.JSONArray;
import org.json.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import javax.net.ssl.HttpsURLConnection;

public class APIManager{
    static int response;
    static ArrayList<Double> avgTemp;
    static ArrayList<Double> avgHumility;
    static ArrayList<Double> avgWindSpeed;
    static void API(){
        try{
            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=30.28&longitude=-97.76&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m&temperature_unit=fahrenheit&wind_speed_unit=mph");
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            response = connection.getResponseCode();

            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = reader.readLine();

            JSONObject jsonObject = new JSONObject(line);
            JSONObject hourly = jsonObject.getJSONObject("hourly");
            JSONArray temp = hourly.getJSONArray("temperature_2m");
            JSONArray humidity = hourly.getJSONArray("relative_humidity_2m");
            JSONArray windSpeed = hourly.getJSONArray("wind_speed_10m");
            avgTemp = new ArrayList<>();
            avgHumility = new ArrayList<>();
            avgWindSpeed = new ArrayList<>();

            for(int i = 0; i < temp.length();){
                double sum = 0;
                for(int h = 0; h < 24; h++){
                    double hour = temp.getDouble(i);
                    sum += hour;
                    i++;
                }
                avgTemp.add(sum/24);
            }

            for(int i = 0; i < temp.length();){
                double sum = 0;
                for(int h = 0; h < 24; h++){
                    double hour = humidity.getDouble(i);
                    sum += hour;
                    i++;
                }
                avgHumility.add(sum/24);
            }

            for(int i = 0; i < temp.length();){
                double sum = 0;
                for(int h = 0; h < 24; h++){
                    double hour = windSpeed.getDouble(i);
                    sum += hour;
                    i++;
                }
                avgWindSpeed.add(sum/24);
            }
        }

        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
