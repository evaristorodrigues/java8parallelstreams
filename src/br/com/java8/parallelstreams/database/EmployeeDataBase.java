/**
 * 
 */
package br.com.java8.parallelstreams.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.java8.parallelstreams.models.Employee;

/**
 * @author evaristosrodrigues
 *
 */
public class EmployeeDataBase {
	

	public static List<Employee> getEmployees(){
		List<Employee> employees = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			employees.add(new Employee(i, "employee"+i, "A", Double.valueOf(new Random().nextInt(1000*100))));
		}
		
		return employees;
	}


}
