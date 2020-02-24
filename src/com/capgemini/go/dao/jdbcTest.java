package com.capgemini.go.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class jdbcTest {
	static Connection connection;
	static {
		try {
			DriverManager.deregisterDriver(new oracle.jdbc.driver.OracleDriver());
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	public static Connection myconnection()throws SQLException{
		if(connection==null)
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abhinav2310");
		return connection;
	}

}
