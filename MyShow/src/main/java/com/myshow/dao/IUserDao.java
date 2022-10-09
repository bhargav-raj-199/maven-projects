package com.myshow.dao;

import com.myshow.model.User;

/**
 * @author BhargavRajJinka
 *
 */
public interface IUserDao {
	/**
	 * @param user
	 * @return String
	 */
	String addUser(User user);
	/**
	 * @param username
	 * @param password
	 * @return int value
	 */
	int changePassword(String username, String password);
	/**
	 * @param username
	 * @param password
	 * @return user object
	 */
	User findByUsername(String username, String password);
	
}
