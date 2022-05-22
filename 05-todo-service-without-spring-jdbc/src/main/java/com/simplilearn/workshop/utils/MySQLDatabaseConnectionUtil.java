package com.simplilearn.workshop.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDatabaseConnectionUtil {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		//load a driver
		Class.forName(driverClassName);
		//establish the connection
		String url ="jdbc:mysql://localhost:3306/studentdb?useSSL=false";
		String user = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

}
