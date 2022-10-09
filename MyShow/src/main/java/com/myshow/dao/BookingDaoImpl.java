package com.myshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.myshow.model.Movie;
import com.myshow.util.DbConnection;
import com.myshow.util.Queries;

/**
 * @author BhargavRajJinka
 *
 */
public class BookingDaoImpl implements IBookingDao {

	/**
	 * @param movie
	 * @param numberOfTickets
	 * @return
	 */
	@Override
	public double bookShow(Movie movie, int numberOfTickets) {
		double price=0.0;
		//System.out.println(movie.getAvailableSeats());
		if(movie.getAvailableSeats()>numberOfTickets)
		{
			price=movie.getPrice()*numberOfTickets;
			int seats=movie.getAvailableSeats()-numberOfTickets;
			//System.out.println(seats);
			try (Connection connection = DbConnection.openConnection();
					PreparedStatement statement = connection.prepareStatement(Queries.UPDATESEATS);) {
				statement.setInt(1, seats);
				statement.setInt(2,movie.getMovieId());
				statement.execute();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			return price;
		}
			
		else
			return price;
		
	}

}
