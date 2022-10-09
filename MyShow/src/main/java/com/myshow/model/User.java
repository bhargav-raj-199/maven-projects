package com.myshow.model;

/**
 * @author BhargavRajJinka
 *
 */
public class User {
	 private String username;
	 private String name;
	 private long mobile;
	 private String email;
	 private String city;
	 private Integer userId;
	 private String password;
	 private String type;
	 
	 
	 
	
	
	/**
	 * @param username
	 * @param name
	 * @param mobile
	 * @param email
	 * @param city
	 * @param userId
	 * @param password
	 * @param type
	 */
	public User(String username, String name, long mobile, String email, String city, Integer userId, String password,
			String type) {
		super();
		this.username = username;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.city = city;
		this.userId = userId;
		this.password = password;
		this.type = type;
	}
	/**
	 * @return
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return
	 */
	public long getMobile() {
		return mobile;
	}
	/**
	 * @param mobile
	 */
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * @param userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", mobile=" + mobile + ", email=" + email + ", city="
				+ city + ", userId=" + userId + ", password=" + password + ", type=" + type + "]";
	}
	
	
	 
	 
}
