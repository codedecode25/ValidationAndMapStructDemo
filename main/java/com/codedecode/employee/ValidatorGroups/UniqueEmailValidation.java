package com.codedecode.employee.ValidatorGroups;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.codedecode.employee.repo.EmployeeRepo;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmailValidator, String> {
	
	@Autowired
	EmployeeRepo employeeRepo ;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(employeeRepo.findByEmailAddress(value).size() == 0)
			return true;
		return false;
	}

}
