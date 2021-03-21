/**
 * 
 */
package br.com.java8.parallelstreams.examples;

import java.util.List;
import java.util.stream.IntStream;

import br.com.java8.parallelstreams.database.EmployeeDataBase;
import br.com.java8.parallelstreams.models.Employee;

/**
 * @author evaristosrodrigues
 *
 */
public class ParallelStreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		sb.append("https://stackoverflow.com/questions/20375176/should-i-always-use-a-parallel-stream-when-possible");
		sb.append("\n");
		sb.append("\n");
		sb.append("relatively simple formula to determine a chance of parallel speedup.");
		sb.append("\n");
		sb.append("\n");
		sb.append("NQ Model:");
		sb.append("\n");
		sb.append("where,");
		sb.append("\n");
		sb.append("N x Q > 10000");
		sb.append("\n");
		sb.append("N = number of data items");
		sb.append("\n");
		sb.append("Q = amount of work per item");
		sb.append("\n");
		
		System.out.println(sb.toString());
			

		parallelDataProcessing();		
		
		parallelDataProcessingThread();
		
		parallelStreamProcessing();
		
	}

	private static void parallelStreamProcessing() {
		long start;
		long end;
		//Populate objects
		List<Employee> employees = EmployeeDataBase.getEmployees();
		
		//Normal
		start = System.currentTimeMillis();
		Double salaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Normal stream execution time: "+(end -start)+ " AVG Salary:" +salaryWithStream);
		
		
		//Normal
		start = System.currentTimeMillis();
		Double salaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i -> i).average().getAsDouble();
		end = System.currentTimeMillis();
		System.out.println("Parallel stream execution time: "+(end -start)+ " AVG Salary:" +salaryWithParallelStream);
		
		System.out.println("=======================END==parallelStreamProcessing========================");

	}

	private static void parallelDataProcessingThread() {
		//Showing the thread name
		IntStream.range(1, 10).forEach(x -> {
			System.out.println("Normal Thread: "+Thread.currentThread().getName()+" : "+x);
		});
		
		IntStream.range(1, 10).parallel().forEach(x -> {
			System.out.println("Parallel Threads: "+Thread.currentThread().getName()+" : "+x);
		});
		
		System.out.println("=======================END==parallelDataProcessingThread========================");

	}

	private static void parallelDataProcessing() {
		long start = 0;
		long end = 0;
		
		// Parallel Data Processing
		start = System.currentTimeMillis();
		IntStream.range(1,1000000).forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Plain stream took time: "+(end -start));
		
		System.out.println("=================================================");
		
		start = System.currentTimeMillis();
		IntStream.range(1, 10000).parallel().forEach(System.out::println);
		end = System.currentTimeMillis();
		System.out.println("Parallel stream took time: "+(end -start));
		
		System.out.println("=======================END==parallelDataProcessing========================");

	}

}
