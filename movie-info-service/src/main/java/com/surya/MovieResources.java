package com.surya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/movies")
public class MovieResources {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${api.key}")
	private String apiKey;
	
	@RequestMapping("/{movieId}")
	//@HystrixCommand(fallbackMethod = "getFallbackMovieInfo")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId)
	{
		
		MovieSummary movieSumm = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +apiKey, MovieSummary.class);
		
		return new Movie(movieId, movieSumm.getTitle(), movieSumm.getOverview());
		
	}
	
//	public Movie getFallbackMovieInfo(@PathVariable("movieId") String movieId)
//	{
//		return new Movie("0", "No Movie");
//	}

}
