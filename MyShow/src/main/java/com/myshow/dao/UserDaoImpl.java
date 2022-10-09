package com.myshow.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.myshow.model.User;
import com.myshow.util.DbConnection;
import com.myshow.util.PasswordGenerator;
import com.myshow.util.Queries;

/**
 * @author BhargavRajJinka
 *
 */
public class UserDaoImpl implements IUserDao {

	
	/**
	 * @param user
	 * @return
	 */
	@Override
	public String addUser(User user) {
		int result=0;
		String password=PasswordGenerator.generatePassword();
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.ADDUSER);){
			
			statement.setString(1, user.getUsername());
			statement.setString(2, password);
			statement.setString(3, user.getName());
			statement.setString(4, user.getCity());
			statement.setString(5, user.getEmail());
			statement.setLong(6, user.getMobile());
			statement.setString(7, user.getType());
			
			result=statement.executeUpdate();
			if(result==1)
				System.out.println("user added successfully");
			else
				System.out.println("user not added");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return password;
	}

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public User findByUsername(String username, String password) {
		ResultSet resultSet=null;
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.LOGIN);){
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				User user=new User();
				user.setUserId(resultSet.getInt(1));
				user.setUsername(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setName(resultSet.getString(4));
				user.setCity(resultSet.getString(5));
				user.setEmail(resultSet.getString(6));
				user.setMobile(resultSet.getLong(7));
				user.setType(resultSet.getString(8));
				return user;
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	@Override
	public int changePassword(String username,String password) {
		int check=0;
		try(Connection connection=DbConnection.openConnection();
				PreparedStatement statement=connection.prepareStatement(Queries.CHANGEPASS);){
			
			
			statement.setString(2,username);
			statement.setString(1, password);
			check=statement.executeUpdate();
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return check;
		
		}
	}

