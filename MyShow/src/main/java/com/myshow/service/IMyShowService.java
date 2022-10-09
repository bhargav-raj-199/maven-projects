package com.myshow.service;

import java.util.List;

import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public interface IMyShowService {

	/**
	 * @param movie
	 */
	void addMovie(Movie movie);
	/**
	 * @param movieId
	 * @param language
	 * @return
	 */
	int updateMovie(int movieId,String language);
	/**
	 * @param movieId
	 * @return
	 */
	int deleteMovie(int movieId);
	
	/**
	 * @param genre
	 * @return
	 */
	List<Movie> getMoviesByGenre(String genre);
	
	/**
	 * @param genre
	 * @param language
	 * @return
	 */
	List<Movie> getMoviesByGenreAndLan(String genre,String language);
	/**
	 * @param language
	 * @return
	 */
	List<Movie> getMoviesByLanguage(String language);
	/**
	 * @param title
	 * @return
	 */
	List<Movie> getMovieByNameStarting(String title);
	/**
	 * @param rating
	 * @return
	 */
	List<Movie> getMoviesByRating(int rating);
	
	/**
	 * @param movieId
	 * @return
	 */
	Movie getById(int movieId);
	/**
	 * @return
	 */
	List<Movie> getAllMovies();
	
}
