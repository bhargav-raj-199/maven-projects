package com.myshow.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author BhargavRajJinka
 *
 */
public class DbConnection {




		
		static Connection connection;
		public static Connection openConnection() {
			String url="jdbc:mysql://localhost:3306/moviesdb";
			String username="root";
			String password="root";
			//boolean check;
			try {
				connection=DriverManager.getConnection(url,username,password);
				/*
				 * Statement st=connection.createStatement(); boolean check=st.
				 * execute("create table Movies(movieId int primary key auto_increment,title varchar(20),genre varchar(20),language varchar(20),location varchar(20),releaseDate timestamp,rating int,duration int"
				 * ); if(check) System.out.println("table not created"); else
				 * System.out.println("table created");
				 */
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		public void closeConnection() {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
