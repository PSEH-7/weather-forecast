package com.sapient.weather_forecast.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sapient.weather_forecast.model.Temperature;
import com.sapient.weather_forecast.model.Weather;
import com.sapient.weather_forecast.model.WeatherDescription;
import com.sapient.weather_forecast.model.WeatherForecast;
import com.sapient.weather_forecast.model.WeatherType;
import com.sapient.weather_forecast.util.Constants;

@Service
public class WeatherForecastService implements IWeatherForecast {
	
	private static final Logger LOG = LoggerFactory.getLogger(WeatherForecastService.class);
	
	@Autowired
	private RestTemplateBuilder restTemplateBuidler;

	@Override
	public WeatherForecast getWeatherForecast(final String city, final String country) {
		
		WeatherForecast weatherForecast = null;
		try {
			URI uri = new URI(Constants.WF_URL+"forecast"+"?q="+city+"&"+Constants.API_KEY);
		
			ResponseEntity<WeatherForecast> responseEntity = restTemplateBuidler.build()
									.getForEntity(uri, WeatherForecast.class);
			
			weatherForecast = responseEntity.getBody();
			
			weatherForecast = filterNextThreeForecast(weatherForecast);
			
			weatherForecast = addAdvise(weatherForecast);
			
		} catch (URISyntaxException e) {
			LOG.error("Error during fetching weather forecast", e);
		}
		
		return weatherForecast; 
	}

	private WeatherForecast addAdvise(WeatherForecast weatherForecast) {
		List<Weather> weathers = weatherForecast.getWeathers();
		
		
		
		weathers.stream().forEach(weather -> {
			String tempAdvice = "";
			Temperature temp = weather.getTemparature();
			if(temp.getMaxTemp()>40.0) {
				tempAdvice = "Use sunscreen lotion";
			}
			List<WeatherDescription> descriptions = weather.getWeatherDescription();
			addAdviseAsPerWeatherType(descriptions, tempAdvice);
		});
		
		return weatherForecast;
	}

	private void addAdviseAsPerWeatherType(List<WeatherDescription> descriptions, String tempAdvice) {
		descriptions.stream().forEach(descritpion -> {
			descritpion.getAdvice().add(tempAdvice);
			if(WeatherType.CLOUDS.getType().equalsIgnoreCase(descritpion.getMain())) {
				descritpion.getAdvice().add("Carry Umbrella");
			}
			else if(WeatherType.RAIN.getType().equalsIgnoreCase(descritpion.getMain())) {
				descritpion.getAdvice().add("Wait for sometime or Carry Umbrella");
			}
		});		
	}

	private WeatherForecast filterNextThreeForecast(WeatherForecast weatherForecast) {
		List<Weather> weathers = weatherForecast.getWeathers();
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, 3);
		Date threeDaysAfterDate = calendar.getTime();
		
		System.out.println("Date " + threeDaysAfterDate);
		
		List<Weather> recentWeathers = weathers.stream()
			.filter(weather -> weather.getWeatherDate().before(threeDaysAfterDate))
			.collect(Collectors.toList());
		
		weatherForecast.setWeathers(recentWeathers);
		return weatherForecast;
	}

}
