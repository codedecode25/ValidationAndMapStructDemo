package com.codedecode.employee.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codedecode.employee.dtos.EmployeeDTO;
import com.codedecode.employee.entities.Employee;
import com.codedecode.employee.populator.EmployeePopulator;
import com.codedecode.employee.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> getAllEMployees(){
	
		return employeeRepo.findAll();
	}
	
	public Employee saveEmployee(EmployeeDTO employeeDTO)
	{
		Employee e = EmployeePopulator.INSTANCE.populateEmployee(employeeDTO);
		e.setCreationDate(new Date());
		return employeeRepo.save(e);
	}
	

}
