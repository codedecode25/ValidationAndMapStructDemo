package com.codedecode.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.employee.ValidatorGroups.CreateDetailsValidator;
import com.codedecode.employee.ValidatorGroups.UpdateDetailsValidator;
import com.codedecode.employee.dtos.EmployeeDTO;
import com.codedecode.employee.entities.Employee;
import com.codedecode.employee.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service; 
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> listOfEMployees = new ArrayList<>();
		listOfEMployees.addAll(service.getAllEMployees());
		
		return new ResponseEntity<>(listOfEMployees, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@Validated(CreateDetailsValidator.class) @RequestBody EmployeeDTO empDto){
		return new ResponseEntity<Employee>(service.saveEmployee(empDto), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@Validated(UpdateDetailsValidator.class) @RequestBody EmployeeDTO empDto){
		return new ResponseEntity<Employee>(service.saveEmployee(empDto), HttpStatus.CREATED);
		
	}
	
	
	

}
