package com.cognizant.ormlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.ormlearn.entity.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;

/**
 * SPRING DATA JPA SERVICE - Business Logic Layer
 * 
 * Demonstrates the Spring Data JPA approach where:
 * - Transaction management is handled by @Transactional annotation
 * - No manual session/transaction code needed
 * - Minimal boilerplate code
 * - Exception handling is automatic
 * - Resource management is automatic
 * 
 * Compare with HibernateEmployeeDAO to see the differences
 */
@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * Create/Add a new employee
	 * 
	 * Spring Data JPA handles:
	 * - Transaction creation and commit
	 * - Exception handling
	 * - Resource cleanup
	 */
	@Transactional
	public Employee addEmployee(Employee employee) {
		LOGGER.info("Adding employee: {}", employee.getEmployeeName());
		Employee savedEmployee = employeeRepository.save(employee);
		LOGGER.info("Employee added successfully with ID: {}", savedEmployee.getEmployeeId());
		return savedEmployee;
	}

	/**
	 * Retrieve all employees
	 * 
	 * One line of code vs Hibernate's manual session handling
	 */
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		LOGGER.info("Retrieving all employees");
		List<Employee> employees = employeeRepository.findAll();
		LOGGER.info("Retrieved {} employees", employees.size());
		return employees;
	}

	/**
	 * Retrieve employee by ID
	 */
	@Transactional(readOnly = true)
	public Employee getEmployeeById(Integer employeeId) {
		LOGGER.info("Retrieving employee with ID: {}", employeeId);
		return employeeRepository.findById(employeeId).orElse(null);
	}

	/**
	 * Update an existing employee
	 * 
	 * Using save() which performs update if entity already exists
	 */
	@Transactional
	public Employee updateEmployee(Employee employee) {
		LOGGER.info("Updating employee: {}", employee.getEmployeeId());
		Employee updatedEmployee = employeeRepository.save(employee);
		LOGGER.info("Employee updated successfully");
		return updatedEmployee;
	}

	/**
	 * Delete an employee by ID
	 */
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		LOGGER.info("Deleting employee with ID: {}", employeeId);
		employeeRepository.deleteById(employeeId);
		LOGGER.info("Employee deleted successfully");
	}

	/**
	 * Delete an employee
	 */
	@Transactional
	public void deleteEmployeeByEntity(Employee employee) {
		LOGGER.info("Deleting employee: {}", employee.getEmployeeName());
		employeeRepository.delete(employee);
		LOGGER.info("Employee deleted successfully");
	}

}
