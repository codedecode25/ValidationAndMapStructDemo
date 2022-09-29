package com.codedecode.employee.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codedecode.employee.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	List<Employee> findByEmailAddress(String value);
	
	

}
