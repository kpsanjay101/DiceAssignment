package com.sk.serviceImpl;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sk.output.ForeCast;
import com.sk.output.Location;
import com.sk.output.WeatherResponse;
import com.sk.service.WeatherService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public WeatherResponse getWeatherResponce(String cityName) {
		
		OkHttpClient client = new OkHttpClient();
		
		String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/Mumbai/summary/";
		String rapidUrl = url.replace("{city}", cityName);
		
		System.out.println("Your URL is : "+url);
	
		
        Request request = new okhttp3.Request.Builder()
                .url(rapidUrl)
                .addHeader("X-RapidAPI-Key", "9527f56283msh7e3176343a8c659p1c9352jsn609f796f6dfa")
                .addHeader("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
                .build();
        System.out.println(request);
        Response response = null;
        
        System.out.println("Line2");
       
		try {
			response = client.newCall(request).execute();
			if (!response.isSuccessful()) {
		        // Handle unsuccessful response (e.g., log error, throw exception)
		        throw new IOException("Unexpected HTTP response: " + response);
		    }
			System.out.println(response);
			System.out.println("Line3");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Line4");
			e1.printStackTrace();
		}
         ResponseBody responseBody = null;
		responseBody = response.body();
		System.out.println("Lin5");
            // Now you can deserialize responseBody if needed
		Location location = null;
		ForeCast forcast = null;
		
	
           try { 
        	   
        	 String jsonString = responseBody.string();
             ObjectMapper objectMapper = new ObjectMapper();
             System.out.println("Line7");
             WeatherResponse weatherResponse = objectMapper.readValue(jsonString, WeatherResponse.class);    
             System.out.println(weatherResponse);
             location = weatherResponse.getLocaion();
             forcast = weatherResponse.getForCast();
             return weatherResponse;
        } catch (Exception e) {
        	System.out.println("Line8");
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY);
        }finally {
            // Ensure to close the response body to release resources
            if (responseBody != null) {
                responseBody.close();
            }
        }
       
//        return weatherResponse; 
        
	}

} 
        
        
//url("https://forecast9.p.rapidapi.com/rapidapi/forecast/Mumbai/summary/")
//.get()
//.addHeader("X-RapidAPI-Key", "9527f56283msh7e3176343a8c659p1c9352jsn609f796f6dfa")
//.addHeader("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
//.build();

