package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.entity.Employee;

/**
 * SPRING DATA JPA REPOSITORY - Repository Layer
 * 
 * Extends JpaRepository<Entity, PrimaryKeyType> to inherit CRUD operations:
 * - save(employee)
 * - findAll()
 * - findById(id)
 * - update (via save)
 * - delete(employee)
 * - deleteById(id)
 * 
 * No implementation needed - Spring Data JPA provides it automatically
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Custom query methods can be added here if needed
	// Example: List<Employee> findByDesignation(String designation);
}
