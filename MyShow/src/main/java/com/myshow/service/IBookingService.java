package com.myshow.service;

import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public interface IBookingService {

	/**
	 * @param movie
	 * @param numberOfTickets
	 * @return
	 */
	public double bookShow(Movie movie,int numberOfTickets);
	
}
