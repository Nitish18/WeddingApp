package events;

import java.util.ArrayList;

public class Movie {
	private String title, thumbnailUrl;
	private int year,day,month;
	

	public Movie() {
	}

	public Movie(String name, String thumbnailUrl, int year, int day,
			int month) {
		this.title = name;
		this.thumbnailUrl = thumbnailUrl;
		this.year = year;
		this.day = day;
		this.month = month;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	
	
	

	
}
