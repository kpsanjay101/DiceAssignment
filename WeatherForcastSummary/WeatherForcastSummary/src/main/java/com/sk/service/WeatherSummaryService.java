package com.sk.service;

import com.sk.output.WeatherResponse;

public interface WeatherSummaryService {
	
	public WeatherResponse callRapidApiByCityName(String city);

}
