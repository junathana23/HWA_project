package com.qa.shoegle.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoegleJDBC {
	
	
	Connection conn = null;
	Statement stmt;
	
	
	final String DB_URL = "jdbc:mysql://localhost:3306/shoegle";
	
	final String USER = "root";
	final String PASS = "dimejipusha1998";
	
	
	
	public Connection connect() {
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		    stmt = conn.createStatement();
		} 
		catch (SQLException e) {  // If you can't connect, print an SQL exception error
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
