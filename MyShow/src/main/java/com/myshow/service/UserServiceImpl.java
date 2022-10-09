package com.myshow.service;

import com.myshow.dao.IUserDao;
import com.myshow.dao.UserDaoImpl;
import com.myshow.exceptions.InvalidUserException;
import com.myshow.exceptions.UsernameNotFoundException;
import com.myshow.model.User;

/**
 * @author BhargavRajJinka
 *
 */
public class UserServiceImpl implements IUserService{

	
	IUserDao userDao=new UserDaoImpl();
	/**
	 * @param user
	 * @return
	 */
	@Override
	public String register(User user) {

		String password=userDao.addUser(user);
		return password;
	}

	/**
	 * @param username
	 * @param password
	 * @param type
	 * @return
	 */
	@Override
	public User login(String username, String password,String type) {

		User user=userDao.findByUsername(username, password);
		if(user!=null && user.getType().equals(type))
			return user;
		else
			throw new InvalidUserException("Invalid User");
		
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public int changePassword(String username,String password) {

		int check=userDao.changePassword(username,password);
		if(check==0)
			throw new UsernameNotFoundException("password not updated");
		else
		    return check;
	}
	

}
