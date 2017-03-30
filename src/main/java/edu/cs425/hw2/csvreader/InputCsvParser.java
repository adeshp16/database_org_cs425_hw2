package edu.cs425.hw2.csvreader;

import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import edu.cs425.hw2.model.Department;
import edu.cs425.hw2.model.Employee;

public class InputCsvParser {
	
	private static  final String employee_id_column="emp_id";
	private static  final String employee_name_column="emp_name";
	private static  final String employee_dept_id_column="dept_id";
	private static  final String employee_address_column="emp_addr";
	
	private static  final String department_id_column="dept_id";
	private static  final String department_name_column="dept_name";
	
	private static final String EMPLOYEE_CSV_FILEPATH="./input/employee_input.csv";
	private static final String DEPARTMENT_CSV_FILEPATH="./input/department_input.csv";
	
	public List<Employee> getEmployeeCsvList()
	{

		
		ColumnPositionMappingStrategy<Employee> employeeStategyObj = new ColumnPositionMappingStrategy<Employee>();

		employeeStategyObj.setType(Employee.class);
		
		String[] employeeColumns= new String[]{employee_id_column,employee_name_column,employee_dept_id_column,employee_address_column};
		
		employeeStategyObj.setColumnMapping(employeeColumns);
		final CsvToBean<Employee> csvToBean= new CsvToBean<Employee>();
		List<Employee> employeeList=null;
		
		try{
			final Reader empReader = new FileReader(EMPLOYEE_CSV_FILEPATH);
			employeeList=csvToBean.parse(employeeStategyObj,empReader);
			
		}catch(RuntimeException r){
			//System.out.println("in runtime exception"+r.getMessage());
			System.out.println("Sorry there is some issue,Some value in the Employee csv is not correct, one of the below 2 points is the problem");
			System.out.println("1.either some department_id is not integer(If no dept_id assigned then put 0 as value in input file)");
			System.out.println("2.Employee_id is not integer value, every employee should have mandatory integer value assigned to it");
			System.out.println("Please try correcting employee_input.csv and try again, exiting the application");
			System.exit(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
/*		System.out.println("The input csv file content");
		System.out.println("*******************************************");
		System.out.println("Employee_id" + "| "+"Employee_name" + "| "+"Dept_Id" + "| "+"Address" + "| ");
		for(Employee employeeObj:employeeList)
		{
			System.out.println(employeeObj.getEmp_id()+"| "+employeeObj.getEmp_name()+"| "+employeeObj.getDept_id()+"| "+employeeObj.getEmp_addr()+"|");
		}
		System.out.println("*******************************************");*/
	
		return employeeList;
	}

	public List<Department> getDepartmentCsvList()
	{

		
		ColumnPositionMappingStrategy<Department> departmentStategyObj = new ColumnPositionMappingStrategy<Department>();

		departmentStategyObj.setType(Department.class);
		
		String[] departmentColumns= new String[]{department_id_column,department_name_column};
		
		departmentStategyObj.setColumnMapping(departmentColumns);
		final CsvToBean<Department> csvToBean= new CsvToBean<Department>();
		List<Department> departmentList=null;
		
		try{
			final Reader deptReader = new FileReader(DEPARTMENT_CSV_FILEPATH);
			departmentList=csvToBean.parse(departmentStategyObj,deptReader);
			
		} catch(RuntimeException r)
		{
			System.out.println("Sorry there is some issue,Some value in the Department_input csv is not correct,");
			System.out.println("Some department_id is not integer(every department row should have dept_id assigned)");
			System.out.println("Please try correcting department_input.csv and try again, exiting the application");
			System.exit(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/*System.out.println("The input csv file content");
		System.out.println("*******************************************");
		System.out.println("Departmenet_Id" + "| "+"Department_Name"+ "| ");
		for(Department departmentObj:departmentList)
		{
			System.out.println(departmentObj.getDept_Id()+"| "+departmentObj.getDept_name()+"| ");
		}
		System.out.println("*******************************************");*/
		
		return departmentList;
	
	}
	
	public void displayEmployeeTable(List<Employee> employeeList)
	{
		System.out.println("The Employee csv file content");
		System.out.println("*******************************************");
		System.out.println("Employee_id" + "| "+"Employee_name" + "| "+"Dept_Id" + "| "+"Address" + "| ");
		for(Employee employeeObj:employeeList)
		{
			System.out.println(employeeObj.getEmp_id()+"| "+employeeObj.getEmp_name()+"| "+employeeObj.getDept_id()+"| "+employeeObj.getEmp_addr()+"|");
		}
		System.out.println("*******************************************");
	
	}
	
	
	public void displayDepartmentTable(List<Department> departmentList)
	{
		System.out.println("The Department csv file content");
		System.out.println("*******************************************");
		System.out.println("Departmenet_Id" + "| "+"Department_Name"+ "| ");
		for(Department departmentObj:departmentList)
		{
			System.out.println(departmentObj.getDept_Id()+"| "+departmentObj.getDept_name()+"| ");
		}
		System.out.println("*******************************************");
	
	}
}
