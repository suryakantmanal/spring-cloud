package com.surya.ratingdataservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/ratings-data")
public class RatingDataResource {
	
	
	@RequestMapping("/users/{userId}")
	public UserRating getRatingByUser(@PathVariable("userId") String userId)
	{
		
		List<Rating> ratings = Arrays.asList(
				new Rating("5", 4),
				new Rating("6", 5)
				
				);
		
		return new UserRating(ratings);
	}
	
	
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId, 4);
	}
	
	

}
