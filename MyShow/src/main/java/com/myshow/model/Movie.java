package com.myshow.model;


import java.time.LocalDateTime;

/**
 * @author BhargavRajJinka
 *
 */
public class Movie {

	private Integer movieId;
	private String title;
	private String genre;
	private String language;
	private String location;
	private LocalDateTime releaseDate;
	private int rating;
	private int duration;
	private int availableSeats;
	private double price;
	
	
	/**
	 * 
	 */
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}




	/*
	 * public Movie(String title, String genre, String language, String location,
	 * LocalDateTime releaseDate, int rating, int duration,int availableSeats) {
	 * super(); this.title = title; this.genre = genre; this.language = language;
	 * this.location = location; this.releaseDate = releaseDate; this.rating =
	 * rating; this.duration = duration; this.availableSeats=availableSeats; }
	 */
	


	




	/*
	 * public Movie(Integer movieId, String title, String genre, String language,
	 * String location, LocalDateTime releaseDate, int rating, int duration) {
	 * super(); this.movieId = movieId; this.title = title; this.genre = genre;
	 * this.language = language; this.location = location; this.releaseDate =
	 * releaseDate; this.rating = rating; this.duration = duration; }
	 */




	/**
	 * @return
	 */
	public Integer getMovieId() {
		return movieId;
	}




	/**
	 * @param movieId
	 */
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}




	/**
	 * @return
	 */
	public String getTitle() {
		return title;
	}




	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}




	/**
	 * @return
	 */
	public String getGenre() {
		return genre;
	}




	/**
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}




	/**
	 * @return
	 */
	public String getLanguage() {
		return language;
	}




	/**
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}




	/**
	 * @return
	 */
	public String getLocation() {
		return location;
	}




	/**
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}




	/**
	 * @return
	 */
	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}




	/**
	 * @param releaseDate
	 */
	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}




	/**
	 * @return
	 */
	public int getRating() {
		return rating;
	}




	/**
	 * @param rating
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}




	/**
	 * @return
	 */
	public int getDuration() {
		return duration;
	}




	/**
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}




	/**
	 * @return
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}




	/**
	 * @param availableSeats
	 */
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}




	
	  /**
	 * @return
	 */
	public double getPrice() { return price; }
	  
	  
	  
	  
	  /**
	 * @param price
	 */
	public void setPrice(double price) { this.price = price; }
	 




	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", language=" + language
				+ ", location=" + location + ", releaseDate=" + releaseDate + ", rating=" + rating + ", duration="
				+ duration + ", availableSeats=" + availableSeats + "]";
	}


	
	
	
	
	
	
}
