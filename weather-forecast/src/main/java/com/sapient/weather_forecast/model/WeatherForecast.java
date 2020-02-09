package com.sapient.weather_forecast.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecast {

	private City city;
	
	@JsonProperty(value="list")
	private List<Weather> weathers;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Weather> getWeathers() {
		return weathers;
	}

	public void setWeathers(List<Weather> weathers) {
		this.weathers = weathers;
	}

	@Override
	public String toString() {
		return "WeatherForecast [city=" + city + ", weathers=" + weathers + "]";
	}
	
	
	
}
