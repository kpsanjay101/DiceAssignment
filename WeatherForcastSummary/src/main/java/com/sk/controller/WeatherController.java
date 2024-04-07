package com.sk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.output.WeatherResponse;
import com.sk.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	
   @GetMapping("getWeatherSummary/{city}")
	public ResponseEntity<WeatherResponse> getWeatherSummaryByCityName(@PathVariable String city) {
		
		return new ResponseEntity<WeatherResponse>(weatherService.getWeatherResponce(city), HttpStatus.OK) ;
	
	}

	

}
