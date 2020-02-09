package com.sapient.weather_forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class WeatherForecastApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(WeatherForecastApplication.class, args);
        System.out.println( "Weather Forecast Application Running " );
    }
}
