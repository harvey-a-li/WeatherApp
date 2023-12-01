package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.*;
import java.util.*;
public class MainActivity extends AppCompatActivity{
    private TextView temp1, temp2, temp3, temp4, temp5, temp6, temp7;
    private TextView wind1, wind2, wind3, wind4, wind5, wind6, wind7;
    private TextView hum1, hum2, hum3, hum4, hum5, hum6, hum7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp1 = findViewById(R.id.day1Temp);
        temp2 = findViewById(R.id.day2Temp);
        temp3 = findViewById(R.id.day3Temp);
        temp4 = findViewById(R.id.day4Temp);
        temp5 = findViewById(R.id.day5Temp);
        temp6 = findViewById(R.id.day6Temp);
        temp7 = findViewById(R.id.day7Temp);

        wind1 = findViewById(R.id.day1Wind);
        wind2 = findViewById(R.id.day2Wind);
        wind3 = findViewById(R.id.day3Wind);
        wind4 = findViewById(R.id.day4Wind);
        wind5 = findViewById(R.id.day5Wind);
        wind6 = findViewById(R.id.day6Wind);
        wind7 = findViewById(R.id.day7Wind);

        hum1 = findViewById(R.id.day1Humidity);
        hum2 = findViewById(R.id.day2Humidity);
        hum3 = findViewById(R.id.day3Humidity);
        hum4 = findViewById(R.id.day4Humidity);
        hum5 = findViewById(R.id.day5Humidity);
        hum6 = findViewById(R.id.day6Humidity);
        hum7 = findViewById(R.id.day7Humidity);

        new APITask().execute();

    }
    class APITask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            APIManager.API();
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            displayData();
        }
    }

    void displayData(){
        String temperature = String.format("%.1f", APIManager.avgTemp.get(0));
        temp1.setText(temperature + "°F");
        temperature = String.format("%.1f", APIManager.avgTemp.get(1));
        temp2.setText(temperature + "°F");
        temperature = String.format("%.1f", APIManager.avgTemp.get(2));
        temp3.setText(temperature + "°F");
        temperature = String.format("%.1f", APIManager.avgTemp.get(3));
        temp4.setText(temperature + "°F");
        temperature = String.format("%.1f", APIManager.avgTemp.get(4));
        temp5.setText(temperature + "°F");
        temperature = String.format("%.1f", APIManager.avgTemp.get(5));
        temp6.setText(temperature + "°F");
        temperature = String.format("%.1f", APIManager.avgTemp.get(6));
        temp7.setText(temperature + "°F");

        String windSpeed = String.format("%.1f",APIManager.avgWindSpeed.get(0));
        wind1.setText(windSpeed + " mph");
        windSpeed = String.format("%.1f",APIManager.avgWindSpeed.get(1));
        wind2.setText(windSpeed + " mph");
        windSpeed = String.format("%.1f",APIManager.avgWindSpeed.get(2));
        wind3.setText(windSpeed + " mph");
        windSpeed = String.format("%.1f",APIManager.avgWindSpeed.get(3));
        wind4.setText(windSpeed + " mph");
        windSpeed = String.format("%.1f",APIManager.avgWindSpeed.get(4));
        wind5.setText(windSpeed + " mph");
        windSpeed = String.format("%.1f",APIManager.avgWindSpeed.get(5));
        wind6.setText(windSpeed + " mph");
        windSpeed = String.format("%.1f",APIManager.avgWindSpeed.get(6));
        wind7.setText(windSpeed + " mph");

        String humidity = String.format("%.1f",APIManager.avgHumility.get(0));
        hum1.setText(humidity + "%");
        humidity = String.format("%.1f",APIManager.avgHumility.get(1));
        hum2.setText(humidity + "%");
        humidity = String.format("%.1f",APIManager.avgHumility.get(2));
        hum3.setText(humidity + "%");
        humidity = String.format("%.1f",APIManager.avgHumility.get(3));
        hum4.setText(humidity + "%");
        humidity = String.format("%.1f",APIManager.avgHumility.get(4));
        hum5.setText(humidity + "%");
        humidity = String.format("%.1f",APIManager.avgHumility.get(5));
        hum6.setText(humidity + "%");
        humidity = String.format("%.1f",APIManager.avgHumility.get(6));
        hum7.setText(humidity + "%");

    }
}