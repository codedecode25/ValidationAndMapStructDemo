package com.codedecode.employee.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.codedecode.employee.ValidatorGroups.CreateDetailsValidator;
import com.codedecode.employee.ValidatorGroups.UniqueEmailValidator;
import com.codedecode.employee.ValidatorGroups.UpdateDetailsValidator;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
	
	private int id;
	
	@NotBlank(message="Name cannot be blank for an employee", groups = {UpdateDetailsValidator.class})
	private String name;
	
	@Min(value=20, message="Minimum age should be 20", groups = {CreateDetailsValidator.class})
	@Max(value = 100, message="Max age should be 100", groups = {CreateDetailsValidator.class})
	private int age;
	
	@Email
	@NotBlank(message="Email cant be null", groups = {UpdateDetailsValidator.class})
	@UniqueEmailValidator(message = "Email must be unique", groups = {CreateDetailsValidator.class, UpdateDetailsValidator.class})
	private String emailAddress;
	
	
	private int projectId;
	

}
