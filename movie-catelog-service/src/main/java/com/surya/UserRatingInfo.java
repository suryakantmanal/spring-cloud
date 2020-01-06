package com.surya;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {
	
	@Override
	public String toString() {
		return "UserRatingInfo [restTemplate=" + restTemplate + "]";
	}

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallbackUserRatings")
	public UserRating getUserRatings(String userId) {
		UserRating ratings = restTemplate.getForObject("http://movie-rating-service/ratings-data/users/"+ userId, UserRating.class);
		return ratings;
	}
	
	public UserRating getFallbackUserRatings(String userId) {
		UserRating userRating = new UserRating();
		userRating.setUserId(userId);
		userRating.setRatingList(Arrays.asList(new Rating("0", 0)));
		System.out.println("in fallback user rating");
		return userRating;
		
	}
}
