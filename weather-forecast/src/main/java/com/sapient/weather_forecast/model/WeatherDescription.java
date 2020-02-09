package com.sapient.weather_forecast.model;

import java.util.ArrayList;
import java.util.List;

public class WeatherDescription {

	private Integer id;
	
	private String main;
	
	private List<String> advices = new ArrayList<String>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public List<String> getAdvice() {
		return advices;
	}

	public void setAdvice(List<String> advices) {
		this.advices = advices;
	}

	@Override
	public String toString() {
		return "WeatherDescription [id=" + id + ", main=" + main + ", advice=" + advices + "]";
	}
		
}
