package edu.cs425.hw2.main;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.cs425.hw2.csvreader.InputCsvParser;
import edu.cs425.hw2.model.Department;
import edu.cs425.hw2.model.Employee;
import edu.cs425.hw2.sqloperations.JoinOperation;

public class QueryDriverClass {
	
	private static List<Employee> employeeList=null;
	public static List<Department> deptList=null;

	public static void main(String[] args) {

		
		InputCsvParser csvParser= new InputCsvParser();
		employeeList=csvParser.getEmployeeCsvList();
		deptList=csvParser.getDepartmentCsvList();
		
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
					csvParser.displayEmployeeTable(employeeList);
					
					csvParser.displayDepartmentTable(deptList);
					
				break;
			case 2:
				System.out.println("Join operation selected");
				JoinOperation joinOperation=JoinOperation.getSingletonInstance();
				joinOperation.joinTwoTable(employeeList,deptList);
				
				break;
			case 3:
				System.out.println("Group by operation selected");
				
				JoinOperation groupbyOperation=JoinOperation.getSingletonInstance();
				groupbyOperation.groupByDeptTable(employeeList);
				
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
