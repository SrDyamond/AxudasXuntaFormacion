package com.fp.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/xunta_galicia_axudas";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "3270Clb20616!";
	
	
	
	private Connection connection;
	Connection conn = null;

	// connect database
	public Connection connect() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
				System.out.println("Database Connected");
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Database Error");
			}
		}
		return connection;
	}
	
	public void disconnect() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
