package com.app.cca.kpr.validator;

import org.springframework.validation.Errors;

import com.app.cca.kpr.model.Customer;

public class ValidationUtils {
	
	public static void rejectIfEmptyOrWhiteSpace(Errors errors, String errorMessage, Customer obj) {
		
		if(obj !=null && obj.getName() != null && !"".equals(obj.getName().trim())) {
			errors.reject("Error.Name", errorMessage);
		}
	}

}
