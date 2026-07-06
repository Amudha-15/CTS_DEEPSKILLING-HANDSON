package com.cognizant.ormlearn.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.ormlearn.entity.Employee;

/**
 * HIBERNATE APPROACH - Traditional ORM Implementation
 * 
 * This class demonstrates the traditional Hibernate approach where:
 * - Manual session management is required
 * - Transaction handling is explicit (begin, commit, rollback)
 * - Exception handling is developer's responsibility
 * - More boilerplate code is needed
 * 
 * NOTE: This is NOT used in Spring Data JPA applications.
 * Provided here for educational comparison purposes only.
 */
public class HibernateEmployeeDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(HibernateEmployeeDAO.class);

	private SessionFactory sessionFactory;

	public HibernateEmployeeDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Create/Add a new employee in the database
	 * 
	 * Shows: Manual session creation, transaction management, exception handling,
	 * and resource cleanup
	 */
	public Integer addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer employeeID = null;

		try {
			// Explicitly begin transaction
			tx = session.beginTransaction();

			// Save the employee object
			employeeID = (Integer) session.save(employee);

			// Explicitly commit the transaction
			tx.commit();

			LOGGER.info("Employee added successfully with ID: {}", employeeID);

		} catch (HibernateException e) {
			// Manual rollback on exception
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("Failed to add employee", e);
			e.printStackTrace();

		} finally {
			// Manual resource cleanup
			session.close();
		}

		return employeeID;
	}

	/**
	 * Retrieve all employees from the database
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		Session session = sessionFactory.openSession();
		List<Employee> employees = null;

		try {
			// Manual query execution
			employees = session.createQuery("FROM Employee").list();
			LOGGER.info("Retrieved {} employees", employees.size());

		} catch (HibernateException e) {
			LOGGER.error("Failed to retrieve employees", e);
			e.printStackTrace();

		} finally {
			session.close();
		}

		return employees;
	}

	/**
	 * Retrieve an employee by ID
	 */
	public Employee getEmployeeById(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Employee employee = null;

		try {
			employee = session.get(Employee.class, employeeId);
			LOGGER.info("Employee retrieved: {}", employee);

		} catch (HibernateException e) {
			LOGGER.error("Failed to retrieve employee", e);
			e.printStackTrace();

		} finally {
			session.close();
		}

		return employee;
	}

	/**
	 * Update an existing employee
	 */
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			session.update(employee);
			tx.commit();
			LOGGER.info("Employee updated successfully");

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("Failed to update employee", e);
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

	/**
	 * Delete an employee by ID
	 */
	public void deleteEmployee(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Employee employee = session.get(Employee.class, employeeId);
			if (employee != null) {
				session.delete(employee);
				tx.commit();
				LOGGER.info("Employee deleted successfully");
			}

		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			LOGGER.error("Failed to delete employee", e);
			e.printStackTrace();

		} finally {
			session.close();
		}
	}

}
