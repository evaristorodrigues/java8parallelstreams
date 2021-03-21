/**
 * 
 */
package br.com.java8.parallelstreams.models;

/**
 * @author evaristosrodrigues
 *
 */
public class Employee {
	private Integer id;
	private String name;
	private String grade;
	private Double salary;
	
	public Employee(Integer id, String name, String grade, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.salary = salary;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	
	
	
}
