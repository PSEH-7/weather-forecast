package com.sapient.weather_forecast.service;

import com.sapient.weather_forecast.model.WeatherForecast;

public interface IWeatherForecast {
	
	WeatherForecast getWeatherForecast(final String city, final String country);

}
