package edu.cs425.hw2.sqloperations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public void groupByDeptTable(List<Employee> employeeList) {
		System.out.println(
				"*******************************************************************************************************************************************************************");
		System.out.println(
				"The result of group by query(Select dept_id,count(*) as Cnt from employee group by dept_id)");
		System.out.println(
				"Dept_id" + "|" + "Cnt" + "|");
		
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (Employee employee : employeeList) {
			Integer key= employee.getDept_id();
			if (count.containsKey(key)) {
		        int getcnt =Integer.valueOf(count.get(key));
		        getcnt++;
		        count.put(key, getcnt);
		    }else{
		        count.put(key, 1);
		    }
		}
		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
		    System.out.println(entry.getKey() + " | " + entry.getValue() + " | ");
		}
	}

	public void leftOuterJoin(List<Employee> employeeList, List<Department> deptList) {
		
		Map<Integer, Employee> employeeMap=new HashMap<Integer, Employee>();
		
		System.out.println(
				"*******************************************************************************************************************************************************************");
		System.out.println(
				"The result of left outer join query(Select e.emp_id,e.emp_name,d.dept_name from employee e left join department d on e.dept_id=d.dept_id)");
		System.out.println(
				"*******************************************************************************************************************************************************************");
		System.out.println(
				"Employee_id" + "|" + "Employee_name" + "|" + "Dept_name" +"|");
		for (Employee employee : employeeList) {
			for (Department department : deptList) {
				if (employee.getDept_id() == department.getDept_Id()) {
					System.out.println(
							employee.getEmp_id() + " | " + employee.getEmp_name() +" | "+ department.getDept_name()  + "|");
					employeeMap.put(employee.getEmp_id(), employee);
				
				}
				

			}
		}
		
		for(Employee employee : employeeList)
		{
			int employeeId=employee.getEmp_id();
			if(!employeeMap.containsKey(employeeId)){
				//System.out.println("Uncommon employee id="+employeeId);
				System.out.println(
						employee.getEmp_id() + " | " + employee.getEmp_name() +" | "+ "null"  + "|");
			}
			
		}
		

		System.out.println(
				"*******************************************************************************************************************************************************************");

	}

}
