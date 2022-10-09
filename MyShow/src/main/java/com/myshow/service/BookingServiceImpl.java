package com.myshow.service;

import com.myshow.dao.BookingDaoImpl;
import com.myshow.dao.IBookingDao;
import com.myshow.exceptions.SeatsNotAvailableException;
import com.myshow.model.Movie;

/**
 * @author BhargavRajJinka
 *
 */
public class BookingServiceImpl implements IBookingService {

	IBookingDao bookingDao = new BookingDaoImpl();

	/**
	 * @param movie
	 * @param numberOfTickets
	 * @return
	 */
	@Override
	public double bookShow(Movie movie, int numberOfTickets) {

		double price = bookingDao.bookShow(movie, numberOfTickets);

		if (price == 0.0)
			throw new SeatsNotAvailableException();
		else {
			System.out.println("Successfully booked" + numberOfTickets + "tickets");
			return price;
		}

		// System.out.println(price);
		//return price;

	}

}
