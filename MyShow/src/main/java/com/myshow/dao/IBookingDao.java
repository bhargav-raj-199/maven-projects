package com.myshow.dao;

import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public interface IBookingDao {

	/**
	 * @param movie
	 * @param numberOfTickets
	 * @return double
	 */
	public double bookShow(Movie movie,int numberOfTickets);
	
}
