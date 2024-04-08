package com.sk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sk.output.WeatherResponse;
import com.sk.service.WeatherHourlyService;


@RestController
@RequestMapping("/weatherForeCast")
public class WeatherHourlyController {
	
	
	@Autowired
	private WeatherHourlyService weatherService;
	
	@GetMapping("/hourly/{cityName}")
	public ResponseEntity<WeatherResponse> getResponseFromApi(@PathVariable String cityName){
		
		return new ResponseEntity<WeatherResponse>(weatherService.callWeatherApiHourly(cityName),HttpStatus.OK);
	}

}
