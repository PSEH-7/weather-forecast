package com.sapient.weather_forecast.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.weather_forecast.model.WeatherForecast;
import com.sapient.weather_forecast.service.IWeatherForecast;

@RestController
@RequestMapping(value="/weatherforecast")
public class WeatherForecastController {

	@Autowired
	private IWeatherForecast wfService;
	
	@GetMapping(produces = "application/json")
	public @ResponseBody WeatherForecast getWeather(@RequestParam(name="city") String city, 
			@RequestParam(name="country") String country) throws URISyntaxException {
		
		WeatherForecast weatherForecast = wfService.getWeatherForecast(city, country);
				
		System.out.println("Weather " + weatherForecast);
		
		return weatherForecast;
		
		
	}
	
}
