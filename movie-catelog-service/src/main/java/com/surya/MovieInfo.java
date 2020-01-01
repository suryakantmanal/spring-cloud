package com.surya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackCatelogItem")
	public CatelogItem getCatelogItem(Rating rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/"+ rating.getMovieId(), Movie.class);
		return new CatelogItem(movie.getMovieName(), movie.getOverview(), rating.getRating());
	}
	
	public CatelogItem getFallbackCatelogItem(Rating rating) {
		return new CatelogItem("No Title", "No Desc", 0);
		
	}

}
