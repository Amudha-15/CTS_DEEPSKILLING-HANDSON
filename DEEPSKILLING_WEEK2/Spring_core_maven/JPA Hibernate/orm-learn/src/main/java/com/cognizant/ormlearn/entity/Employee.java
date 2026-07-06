package com.cognizant.ormlearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer employeeId;

	@Column(name = "emp_name")
	private String employeeName;

	@Column(name = "emp_salary")
	private Double salary;

	@Column(name = "emp_designation")
	private String designation;

	public Employee() {
		super();
	}

	public Employee(String employeeName, Double salary, String designation) {
		super();
		this.employeeName = employeeName;
		this.salary = salary;
		this.designation = designation;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
				+ ", designation=" + designation + "]";
	}

}
