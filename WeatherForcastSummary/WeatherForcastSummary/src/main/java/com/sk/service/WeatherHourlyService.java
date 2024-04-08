package com.sk.service;

import com.sk.output.WeatherResponse;

public interface WeatherHourlyService {
	
	public WeatherResponse callWeatherApiHourly(String city);

}
