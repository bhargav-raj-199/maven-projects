package com.myshow.dao;

import java.util.List;

import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public interface IMyShowDao {
	
	/**
	 * @param movie
	 */
	void addMovie(Movie movie);
	/**
	 * @param movieId
	 * @param language
	 * @return int
	 */
	int updateMovie(int movieId,String language);
	/**
	 * @param movieId
	 * @return
	 */
	int deleteMovie(int movieId);
	
	/**
	 * @param genre
	 * @return list of movie objects
	 */
	List<Movie> findMoviesByGenre(String genre);
	
	/**
	 * @param genre
	 * @param language
	 * @return list of movie objects
	 */
	List<Movie> findMoviesByGenreAndLan(String genre,String language);
	/**
	 * @param language
	 * @return list of movie objects
	 */
	List<Movie> findMoviesByLanguage(String language);
	/**
	 * @param title
	 * @return list of movie objects
	 */
	List<Movie> findMovieByNameStarting(String title);
	/**
	 * @param rating
	 * @return list of movie objects
	 */
	List<Movie> findMoviesByRating(int rating);
	
	/**
	 * @param movieId
	 * @return movie
	 */
	Movie findById(int movieId);
	/**
	 * @return list of movie objects
	 */
	List<Movie> findAllMovies();
	
	
}
