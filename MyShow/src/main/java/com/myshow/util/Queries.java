package com.myshow.util;

/**
 * @author BhargavRajJinka
 *
 */
public class Queries {

	public static final String INSERTQUERY="insert into Movies(title,genre,language,location,releaseDate,rating,duration,availableSeats,price) values (?,?,?,?,?,?,?,?,?)";
	public static final String QUERYBYID="select *from Movies where movieId=?";
	public static final String QUERYBYLANGUAGE="select *from Movies where language=?";
	public static final String QUERYBYLANGUAGEANDGENRE="select *from Movies where language=? and genre=?";
	public static final String QUERYBYGENRE="select *from Movies where genre=?";
	public static final String UPDATEQUERY="update Movies set language=? where movieId=?";
	public static final String DELETEQUERY="delete from Movies where movieId=?";
	public static final String QUERYBYNAMESTARTING="select *from Movies where title like ?";
	public static final String QUERYBYRATING="select *from Movies where rating=?";
	public static final String QUERYFORALL="select *from Movies";	
	public static final String LOGIN="select *from users where username=? and password=?";
	public static final String ADDUSER="insert into users(username,password,name,city,email,mobile,type)values(?,?,?,?,?,?,?)";
	public static final String CHANGEPASS="update users set password=? where username=?";
	public static final String UPDATESEATS="update Movies set availableSeats=? where movieId=?";
	//public static final String QUERYBYTITLE="select *from Movies where title";
	
}

