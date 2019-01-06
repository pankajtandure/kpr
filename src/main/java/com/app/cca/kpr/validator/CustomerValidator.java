package com.app.cca.kpr.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.cca.kpr.model.Customer;

public class CustomerValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Customer customer = (Customer) target;
		System.out.println("In Customer Validator ..........................");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, customer.getName(), "Name is not correct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, customer.getPancard(), "Pan card is not correct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, customer.getBirthdate().toString(), "Birth date is not correct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, customer.getContactno()+"", "Contact number is not correct");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, customer.getEmail(), "Email id is not correct");
		checkLocality(errors, customer.getLocality(), "Locality is not correct");
		
		System.out.println("Customer validator ====== "+errors);
	}
	
	public void checkLocality(Errors errors, String locality, String errorMessage) {
		
		if(locality !=null && !"".equals(locality.trim())) {
			errors.reject("locality", errorMessage);
		}
	}

}
