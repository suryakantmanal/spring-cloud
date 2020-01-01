package com.surya;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catelog")
public class MovieCatelogResource {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	MovieInfo movieInfo;
	
	@Autowired
	UserRatingInfo userRatingInfo;
	

	@RequestMapping("/{userId}")
	//@HystrixCommand(fallbackMethod = "getFallbackCatelog")
	public List<CatelogItem> getCatelog(@PathVariable("userId") String userId)
	{
		//Get all rating 
		UserRating ratings = userRatingInfo.getUserRatings(userId);
		return ratings.getRatingList().stream().map(rating -> movieInfo.getCatelogItem(rating)
		).collect(Collectors.toList());
	}

	
//	public List<CatelogItem> getFallbackCatelog(@PathVariable("userId") String userId)
//	{
//		return Arrays.asList(new CatelogItem("TestTitle", "TestDesc", 3));
//		
//	}
}
