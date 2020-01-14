package com.mtc.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root","root");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		return connection;
	}

}
