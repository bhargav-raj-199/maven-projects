package com.myshow.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.myshow.model.Movie;
import com.myshow.util.DbConnection;
import com.myshow.util.MovieMapper;
import com.myshow.util.Queries;
import com.myshow.util.IRowMapper;//C:\Users\BhargavRajJinka\training\junitDemos\MyShow\doc\

/**
 * @author BhargavRajJinka
 *
 */
public class MyShowDaoImpl implements IMyShowDao {

	
	IRowMapper mapper = new MovieMapper();
	/**
	 * @param movie
	 */
	@Override
	public void addMovie(Movie movie) {

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.INSERTQUERY);) {
			statement.setString(1, movie.getTitle());
			statement.setString(2, movie.getGenre());
			statement.setString(3, movie.getLanguage());
			statement.setString(4, movie.getLocation());
			statement.setTimestamp(5, Timestamp.valueOf(movie.getReleaseDate()));
			statement.setInt(6, movie.getRating());
			statement.setInt(7, movie.getDuration());
			statement.setInt(8, movie.getAvailableSeats());
			statement.setDouble(9, movie.getPrice());
			boolean check = statement.execute();
			if (check)
				System.out.println("movie not added");
			else
				System.out.println("movie added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param movieId
	 * @param language
	 * @return int value
	 */
	@Override
	public int updateMovie(int movieId, String language) {
		int check=0;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.UPDATEQUERY);) {
			statement.setInt(2, movieId);
			statement.setString(1, language);
			check= statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	/**
	 * @param movieId
	 * @return int value
	 */
	@Override
	public int deleteMovie(int movieId) {
		int check=0;

		ResultSet resultSet = null;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.DELETEQUERY);) {

			statement.setInt(1, movieId);
			check= statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

		return check;
	}

	/**
	 * @param genre
	 * @return list of movie objects
	 */
	@Override
	public List<Movie> findMoviesByGenre(String genre) {

		List<Movie> moviesList = new ArrayList<>();
		ResultSet resultSet = null;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYGENRE);) {

			statement.setString(1, genre);
			resultSet = statement.executeQuery();
			
			moviesList = mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

		return moviesList;
	}

	/**
	 * @param genre
	 * @param language
	 * @return list of movie objects
	 */
	@Override
	public List<Movie> findMoviesByGenreAndLan(String genre, String language) {
		List<Movie> moviesList = new ArrayList<>();
		ResultSet resultSet = null;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYLANGUAGEANDGENRE);) {

			statement.setString(1, language);
			statement.setString(2, genre);
			resultSet = statement.executeQuery();
			moviesList = mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

		return moviesList;
	}

	/**
	 * @param language
	 * @return list of movie objects
	 */
	@Override
	public List<Movie> findMoviesByLanguage(String language) {

		List<Movie> moviesList = new ArrayList<>();
		ResultSet resultSet = null;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYLANGUAGE);) {

			statement.setString(1, language);
			resultSet = statement.executeQuery();
			moviesList = mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}

		return moviesList;
	}

	/**
	 * @param title
	 * @return list of movie objects
	 */
	@Override
	public List<Movie> findMovieByNameStarting(String title) {

		List<Movie> moviesList = new ArrayList<>();
		ResultSet resultSet = null;
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYNAMESTARTING);) {
			statement.setString(1, "%" + title + "%");
			resultSet = statement.executeQuery();
			moviesList = mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return moviesList;
	}

	/**
	 * @param rating
	 * @return list of movie objects
	 */
	@Override
	public List<Movie> findMoviesByRating(int rating) {
		List<Movie> moviesList = new ArrayList<>();
		ResultSet resultSet = null;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYRATING);) {

			statement.setInt(1, rating);
			resultSet = statement.executeQuery();
			moviesList = mapper.mapRow(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return moviesList;
	}

	/**
	 * @param movieId
	 * @return movie object
	 */
	@Override
	public Movie findById(int movieId) {

		ResultSet resultSet = null;

		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYBYID);) {

			statement.setInt(1, movieId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Movie movie=new Movie();
				movie.setMovieId(resultSet.getInt(1));
				movie.setTitle(resultSet.getString(2));
				movie.setGenre(resultSet.getString(3));
				movie.setLanguage(resultSet.getString(4));;
				movie.setLocation(resultSet.getString(5));;
				movie.setReleaseDate(resultSet.getTimestamp(6).toLocalDateTime());
				movie.setRating(resultSet.getInt(7));
				movie.setDuration(resultSet.getInt(8));
				movie.setAvailableSeats(resultSet.getInt(9));
				movie.setPrice(resultSet.getInt(10));
				
				
				return movie;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return null;
	}

	/**
	 * @return list of movie objects
	 */
	public List<Movie> findAllMovies() {
		List<Movie> moviesList = new ArrayList<>();
		try (Connection connection = DbConnection.openConnection();
				PreparedStatement statement = connection.prepareStatement(Queries.QUERYFORALL);
				ResultSet resultSet = statement.executeQuery();) {

			
			moviesList = mapper.mapRow(resultSet);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return moviesList;
	}

}
