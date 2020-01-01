package com.surya.ratingdataservice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRating {
	
	public UserRating() {
		super();
	}

	public UserRating(List<Rating> ratingList) {
		super();
		this.ratingList = ratingList;
	}

	private List<Rating> ratingList;

	public List<Rating> getRatingList() {
		return ratingList;
	}

	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}

}
