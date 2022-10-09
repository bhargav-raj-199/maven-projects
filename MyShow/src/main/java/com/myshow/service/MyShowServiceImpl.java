package com.myshow.service;

import java.util.List;

import java.util.stream.Collectors;

import com.myshow.dao.IMyShowDao;
import com.myshow.dao.MyShowDaoImpl;
import com.myshow.exceptions.IdNotFoundException;
import com.myshow.exceptions.MovieNotFoundException;
import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public class MyShowServiceImpl implements IMyShowService {

	IMyShowDao myShowDao =new MyShowDaoImpl();
	
	/**
	 * @param movie
	 */
	@Override
	public void addMovie(Movie movie) {
		
		myShowDao.addMovie(movie);
			
	}

	/**
	 * @param movieId
	 * @param language
	 * @return
	 */
	@Override
	public int updateMovie(int movieId, String language) {
		int check = myShowDao.updateMovie(movieId, language);

		if (check==0)
			throw new IdNotFoundException("ID NOT FOUND");
		else {
			System.out.println("SUCCESSFULLY UPDATED");
			return check;
		}

	}

	/**
	 * @param movieId
	 * @return
	 */
	@Override
	public int deleteMovie(int movieId) {
		int check=myShowDao.deleteMovie(movieId);
		
		  if(check==0) 
			  throw new IdNotFoundException("ID NOT FOUND"); 
		  else {
		  System.out.println("SUCCESSFULLY DELETED"); 
		  return check; 
		  }
		 
	}

	/**
	 * @param genre
	 * @return
	 */
	@Override
	public List<Movie> getMoviesByGenre(String genre) {
		
		List<Movie> movies=myShowDao.findMoviesByGenre(genre);
		if(movies.isEmpty())
			throw new MovieNotFoundException("NO MOVIES WITH REQUESTED GENRE");
			
		else 
			return movies.stream().sorted((movie1,movie2)->movie1.getTitle().toUpperCase().compareTo(movie2.getTitle().toUpperCase())).collect(Collectors.toList());
	}

	/**
	 * @param genre
	 * @param language
	 * @return
	 */
	@Override
	public List<Movie> getMoviesByGenreAndLan(String genre, String language) {
		List<Movie> movies=myShowDao.findMoviesByGenreAndLan(genre,language);
		if(movies.isEmpty())
			throw new MovieNotFoundException("NO MOVIES WITH REQUESTED GENRE AND LANGUAGE");
			
		else 
			return movies.stream().sorted((movie1,movie2)->movie1.getTitle().toUpperCase().compareTo(movie2.getTitle().toUpperCase())).collect(Collectors.toList());
	}

	/**
	 * @param language
	 * @return
	 */
	@Override
	public List<Movie> getMoviesByLanguage(String language) {
		List<Movie> movies=myShowDao.findMoviesByLanguage(language);
		if(movies.isEmpty())
			throw new MovieNotFoundException("NO MOVIES WITH REQUESTED LANGUAGE");
			
		else 
			return movies.stream().sorted((movie1,movie2)->movie1.getTitle().toUpperCase().compareTo(movie2.getTitle().toUpperCase())).collect(Collectors.toList());
	}

	/**
	 * @param title
	 * @return
	 */
	@Override
	public List<Movie> getMovieByNameStarting(String title) {
		List<Movie> movies=myShowDao.findMovieByNameStarting(title);
		if(movies.isEmpty())
			throw new MovieNotFoundException("NO MOVIES WITH REQUESTED TITLE");
			
		else 
			return movies.stream().sorted((movie1,movie2)->movie1.getTitle().toUpperCase().compareTo(movie2.getTitle().toUpperCase())).collect(Collectors.toList());
	}

	/**
	 * @param rating
	 * @return
	 */
	@Override
	public List<Movie> getMoviesByRating(int rating) {
		List<Movie> movies=myShowDao.findMoviesByRating(rating);
		if(movies.isEmpty())
			throw new MovieNotFoundException("NO MOVIES WITH REQUESTED RATING");
		else 
			return movies.stream().sorted((movie1,movie2)->movie1.getTitle().toUpperCase().compareTo(movie2.getTitle().toUpperCase())).collect(Collectors.toList());
	}

	/**
	 * @param movieId
	 * @return
	 */
	@Override
	public Movie getById(int movieId) {
		Movie movie=myShowDao.findById(movieId);
		if(movie==null)
			throw new IdNotFoundException("ID NOT FOUND");
		else
			return movie;
	}

	/**
	 * @return
	 */
	@Override
	public List<Movie> getAllMovies() {
		return myShowDao.findAllMovies().stream().sorted((movie1,movie2)->movie1.getTitle().toUpperCase().compareTo(movie2.getTitle().toUpperCase())).collect(Collectors.toList());
		
	}


	
}
