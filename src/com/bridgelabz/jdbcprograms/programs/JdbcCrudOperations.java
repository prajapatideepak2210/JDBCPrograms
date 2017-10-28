package com.bridgelabz.jdbcprograms.programs;

import java.util.Scanner;
import com.bridgelabz.jdbcprograms.dao.JdbcOperations;;

public class JdbcCrudOperations {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		boolean check=true;
		
		do{
			System.out.println("Enter 1 to insert the data into table\nEnter 2 to "
					+ "update the data into table\nEnter 3 to delete the data from "
					+ "table\nEnter 4 to display all data\nEnter 5 to exit.");
			int choise=scanner.nextInt();
			switch (choise) {
			case 1:
				System.out.println("Enter the Employee id : ");
				int idEmployee=scanner.nextInt();
				System.out.println("Enter the Employee name : ");
				scanner.nextLine();
				String employeeName=scanner.nextLine();
				System.out.println("Enter the Employee age : ");
				int employeeAge=scanner.nextInt();
				System.out.println("Enter the Employee position : ");
				scanner.nextLine();
				String employeePosition=scanner.nextLine();
				JdbcOperations.insertData(idEmployee, employeeName, employeeAge, employeePosition);
				break;
			case 2:
				System.out.println("Enter the id : ");
				int id=scanner.nextInt();
				System.out.println("Enter what you want to update : ");
				String update=scanner.next();
				System.out.println("Enter value to update.");
				String valueForUpdate=scanner.next();
				JdbcOperations.update(id, update, valueForUpdate);
				break;
			case 3:
				System.out.println("Enter the id of Employee : ");
				int EmployeeId=scanner.nextInt();
				JdbcOperations.remove(EmployeeId);
				break;
			case 4:
				JdbcOperations.display();
				break;
			case 5:
				check=false;
				break;
			default:
				System.out.println("You have entred wrong choise, please enter write choise.");
				break;
			}
		}while(check);
	}
}
