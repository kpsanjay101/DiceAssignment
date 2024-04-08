package com.sk.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.sk.exception.RestTemplateNotFoundException;
import com.sk.output.WeatherResponse;
import com.sk.service.WeatherHourlyService;

@Service
public class WeatherHourlyServiceImpl implements WeatherHourlyService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{cityName}/hourly/" ;
	
	private static final String apiKey = "cecbc7805amsh100139110f6b416p1b374ejsnf2178ee56f41";

	private static final String apiHost = "forecast9.p.rapidapi.com";
	

	@Override
	public WeatherResponse callWeatherApiHourly(String city) {
		
       String URL = url.replace("{cityName}", city);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", apiKey);
		headers.set("X-RapidAPI-Host", apiHost);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		try {
			
			ResponseEntity<WeatherResponse> response = restTemplate.exchange(URL,HttpMethod.GET,entity,WeatherResponse.class);
			if(response == null) {
				throw new RestTemplateNotFoundException("RestTemplate is not Exchange");
			}
			
			System.out.println("response{} "+response.getBody());
			return response.getBody();
			
		}
		catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
			
		} 
	}

}


