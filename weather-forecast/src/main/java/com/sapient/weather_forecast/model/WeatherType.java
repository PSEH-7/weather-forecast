package com.sapient.weather_forecast.model;

public enum WeatherType {
	
	CLOUDS("Clouds"),
	
	RAIN("Rain");
	
	private String type;

	private WeatherType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}
