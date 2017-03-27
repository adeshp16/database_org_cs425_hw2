package edu.cs425.hw2.sqloperations;

import java.util.List;

import edu.cs425.hw2.model.Department;
import edu.cs425.hw2.model.Employee;

public class JoinOperation {

	private static JoinOperation singletonInstance = new JoinOperation();

	public void joinTwoTable(List<Employee> employeeList, List<Department> deptList) {

		
		System.out.println(
				"*******************************************************************************************************************************************************************");
		System.out.println(
				"The result of join query(Select e.emp_id,e.emp_name,e.dept_id,d.dept_name,e.emp_addr from employee e,department d where e.dept_id=d.dept_id)");
		System.out.println(
				"*******************************************************************************************************************************************************************");
		System.out.println(
				"Employee_id" + "|" + "Employee_name" + "|" + "Dept_id" + "|" + "Dept_name" + "|" + "Address" + "|");
		for (Employee employee : employeeList) {
			for (Department department : deptList) {
				if (employee.getDept_id() == department.getDept_Id()) {
					System.out.println(
							employee.getEmp_id() + " | " + employee.getEmp_name() + " | " + employee.getDept_id()
									+ " | " + department.getDept_name() + " | " + employee.getEmp_addr() + "|");
				}

			}
		}

		System.out.println(
				"*******************************************************************************************************************************************************************");
	}

	public static JoinOperation getSingletonInstance() {
		return singletonInstance;

	}

}
