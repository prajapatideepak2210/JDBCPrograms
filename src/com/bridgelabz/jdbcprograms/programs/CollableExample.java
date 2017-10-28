package com.bridgelabz.jdbcprograms.programs;

import java.sql.*;


public class CollableExample {
private static Connection connection;

	/*	private static String connectionPath="jdbc:mysql://localhost:3306/DEEPAK?user=root&password=password";*/
	public static void main(String[] args) throws ClassNotFoundException {
		
		
		CallableStatement collableStatement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/DEEPAK","root","password");
			collableStatement=connection.prepareCall("{call INSERTR1(?,?,?)}");
			collableStatement.setInt(1,13);
			collableStatement.setString(2,"Akash");
			collableStatement.setInt(3,24);
			collableStatement.execute();
			System.out.println("Insertion completed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
