package com.myshow.service;

import com.myshow.model.User;

/**
 * @author BhargavRajJinka
 *
 */
public interface IUserService {

	/**
	 * @param user
	 * @return
	 */
	String register(User user);
	/**
	 * @param username
	 * @param password
	 * @param type
	 * @return
	 */
	User login(String username,String password,String type);
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	int changePassword(String username, String password);
	
}
