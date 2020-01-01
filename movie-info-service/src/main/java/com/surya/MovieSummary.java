package com.surya;

public class MovieSummary {
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	private String title;
	private String overview;
	public MovieSummary(String title, String overview) {
		super();
		this.title = title;
		this.overview = overview;
	}
	public MovieSummary() {
		super();
	}

}
