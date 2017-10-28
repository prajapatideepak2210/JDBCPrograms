package com.bridgelabz.jdbcprograms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcOperations {
	private static String driverPath="com.mysql.jdbc.Driver";
	private static String connectionPath="jdbc:mysql://localhost:3306/DEEPAK?user=root&password=password";
	
	/**
	 * @param id
	 * @param name
	 * @param age
	 * @param position
	 * 
	 * @Description this function is usable for insert the data into table.
	 */
	public static void insertData(int id, String name, int age, String position)
	{
		Connection connection=null;
		Statement statement=null;
		String query="INSERT INTO Employee(idEmployee,EmployeeName,EmployeeAge,EmployeePosition) VALUES ('"+id+"','"+name+"','"+age+"','"+position+"')";
		try {
			Class.forName(driverPath);
			connection=DriverManager.getConnection(connectionPath);
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Data Inserted.");
			System.out.println("------------------------------------------");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement!=null)
			{
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @param id
	 * @param update
	 * @param valueForUpdate
	 * 
	 * @Description this will update the data of the table by one id which given by user.
	 */
	public static<T> void update(int id, String update, T valueForUpdate)
	{
		Connection connection=null;
		Statement statement=null;
		String query=null;
		if(update.equals("EmployeeName"))
			query="UPDATE Employee SET EmployeeName='"+valueForUpdate+"' WHERE idEmployee="+id;
		else if(update.equals("EmployeeAge"))
			query="UPDATE Employee SET EmployeeAge='"+valueForUpdate+"' WHERE idEmployee="+id;
		else if(update.equals("EmployeePosition"))
			query="UPDATE Employee SET EmployeePosition='"+valueForUpdate+"' WHERE idEmployee="+id;
		
		try {
			Class.forName(driverPath);
			connection=DriverManager.getConnection(connectionPath);
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("data updated.");
			System.out.println("------------------------------------------");
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement!=null)
			{
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @param id
	 * 
	 * @Description this function is usable for delete the data from the table.
	 */
	public static void remove(int id)
	{
		Connection connection=null;
		Statement statement=null;
		String query="DELETE FROM Employee WHERE idEmployee ="+id;
		try {
			Class.forName(driverPath);
			connection=DriverManager.getConnection(connectionPath);
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Column Deleted.");
			System.out.println("------------------------------------------");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement!=null)
			{
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * @param id
	 * 
	 * @Description it will display all data of given id from the table.
	 */
	public static void display()
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		String query="SELECT * FROM Employee";
		try {
			Class.forName(driverPath);
			connection=DriverManager.getConnection(connectionPath);
			statement=connection.createStatement();
			statement.execute(query);
			resultSet=statement.getResultSet();
			
			while(resultSet.next())
			{
				int id=resultSet.getInt("idEmployee");
				String name=resultSet.getString("EmployeeName");
				int age=resultSet.getInt("EmployeeAge");
				String position=resultSet.getString("EmployeePosition");
				System.out.println("Employee ID : "+id+", Name : "+name+", Age : "+age+", Position : "+position);
			}
			System.out.println("--------------------------------------------------------");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
			{
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement!=null)
			{
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
