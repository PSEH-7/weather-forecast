package com.sapient.weather_forecast.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Weather {

	@JsonProperty(value ="main")
	private Temperature temparature;
	
	@JsonProperty(value ="weather")
	private List<WeatherDescription> weatherDescription;
	
	@JsonProperty(value ="dt_txt")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date weatherDate;

	public Temperature getTemparature() {
		return temparature;
	}

	public void setTemparature(Temperature temparature) {
		this.temparature = temparature;
	}

	public List<WeatherDescription> getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(List<WeatherDescription> weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public Date getWeatherDate() {
		return weatherDate;
	}

	public void setWeatherDate(Date weatherDate) {
		this.weatherDate = weatherDate;
	}

	@Override
	public String toString() {
		return "Weather [temparature=" + temparature + ", weatherDescription=" + weatherDescription + ", weatherDate="
				+ weatherDate + "]";
	}
	
}
