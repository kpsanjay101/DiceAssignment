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
import com.sk.service.WeatherSummaryService;

@Service
public class WeatherSummaryServiceImpl implements WeatherSummaryService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/{cityName}/summary/" ;
	
	private static final String apiKey = "43699c5f9cmsha408e9c962b1587p1eefa1jsn22200577ea89";

	private static final String apiHost = "forecast9.p.rapidapi.com";
	
	
	
	@Override
	public WeatherResponse callRapidApiByCityName(String city) {
		String URL = url.replace("{cityName}", city);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", apiKey);
		headers.set("X-RapidAPI-Host", apiHost);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		try {
			
			
			ResponseEntity<WeatherResponse> response = restTemplate.exchange(URL,HttpMethod.GET,entity,WeatherResponse.class);
			System.out.println("response{} "+response.getBody());
			return response.getBody();
			
		}
		catch (Exception e) {
			
			throw new RestTemplateNotFoundException("RestTemplate not fount");
			
		}
		
	}
	
	
	
	

}

/*
 * Request request = new Request.Builder()
	.url("https://forecast9.p.rapidapi.com/rapidapi/forecast/Berlin/summary/")
	.get()
	.addHeader("X-RapidAPI-Key", "43699c5f9cmsha408e9c962b1587p1eefa1jsn22200577ea89")
	.addHeader("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
	.build();

*/
