package com.myshow.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public class MovieMapper implements IRowMapper {
	
	/**
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public List<Movie> mapRow(ResultSet rs) throws SQLException {
		List<Movie> movies=new ArrayList<>();
		while (rs.next()) {
			Movie movie = new Movie();
			movie.setMovieId(rs.getInt(1));

			movie.setTitle(rs.getString(2));
			movie.setGenre(rs.getString(3));
			movie.setLanguage(rs.getString(4));
			movie.setLocation(rs.getString(5));
			movie.setReleaseDate(rs.getTimestamp(6).toLocalDateTime());
			movie.setRating(rs.getInt(7));
			movie.setDuration(rs.getInt(8));
			movie.setAvailableSeats(rs.getInt(9));
			movie.setPrice(rs.getDouble(10));
			movies.add(movie);
		}
		return movies;
			
		}
		
	}


