package com.sapient.weather_forecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
	
	@JsonProperty(value="temp_min")
	private Double minTemp;
	
	@JsonProperty(value="temp_max")
	private Double maxTemp;

	public Double getMinTemp() {
		return minTemp;
	}

	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}

	public Double getMaxTemp() {
		return maxTemp;
	}

	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}

	@Override
	public String toString() {
		return "Temperature [minTemp=" + minTemp + ", maxTemp=" + maxTemp + "]";
	}
	
}
