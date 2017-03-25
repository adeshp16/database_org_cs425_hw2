package edu.cs425.hw2.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.cs425.hw2.csvreader.InputCsvParser;
import edu.cs425.hw2.model.Department;
import edu.cs425.hw2.model.Employee;

public class QueryDiverClass {

	public static void main(String[] args) {

		
		while(true)
		{
		System.out.println("*************************************************************************");
		System.out.println("SQL query operations");
		System.out.println("1. Display both tables(Employee & Department)");
		System.out.println("2. Join operation");
		System.out.println("3. Group By operation");
		System.out.println("4. IN operation");
		System.out.println("5. Exit");
		System.out.println("*************************************************************************");
		
		System.out.println("Please enter your choice..");
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		try {
			int userChoice= scanner.nextInt();
			if(userChoice<1 || userChoice>5)
			{
				throw new Exception();
			}
			switch(userChoice)
			{
			case 1:
				System.out.println("Display both tables option selected");
					InputCsvParser csvParser= new InputCsvParser();
					List<Employee> employeeList=csvParser.getEmployeeCsvList();
					csvParser.displayEmployeeTable(employeeList);
					
					List<Department> deptList=csvParser.getDepartmentCsvList();
					csvParser.displayDepartmentTable(deptList);
					
				break;
			case 2:
				System.out.println("Join operation selected");
				break;
			case 3:
				System.out.println("Group by operation selected");
				break;
			case 4:
				System.out.println("IN operation selected");
				break;
			case 5:
				System.out.println("Thank you! Exiting the application, good bye.");
				System.exit(1);
			}
			
		} catch (InputMismatchException  e) {
			System.out.println(" The option selected is wrong, Please enter any of the option from (1,2,3,4 or 5)");
		} catch (Exception e) {
			System.out.println("The option selected is wrong, You can only enter values between (1,2,3,4 or 5)");
		}
			
		}
	}

}
