package com.surya;

import java.util.List;

public class UserRating {
	
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "UserRating [userId=" + userId + ", ratingList=" + ratingList + "]";
	}

	public UserRating(String userId, List<Rating> ratingList) {
		super();
		this.userId = userId;
		this.ratingList = ratingList;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

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
