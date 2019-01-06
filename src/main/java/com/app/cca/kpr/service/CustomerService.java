package com.app.cca.kpr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.cca.kpr.model.Customer;
import com.app.cca.kpr.model.CustomerWork;
import com.app.cca.kpr.repository.CustomerRepository;
import com.app.cca.kpr.repository.CustomerWorkRepository;
import com.app.cca.kpr.response.Response;
import com.app.cca.kpr.validator.CustomerValidator;

@Service
public class CustomerService {

	@Autowired
	private CustomerWorkRepository workRepository;
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerService() {
		
	}
	
	public List<Customer> getAllCustomers() {

//		CustomerProfile customer = new CustomerProfile("Pankaj", new Date(), "PANKAJ1234T", 1234567890,
//				"pankaj@demo.com", "ADD1", "ADD2", "ADD3", 411041);

		List<Customer> finalList = new ArrayList<>();
		List<Customer> masterList = new ArrayList<>();
				
		workRepository.findAll().forEach(finalList::add);
		customerRepository.findAll().forEach(masterList :: add);
		masterList.removeAll(finalList);
		finalList.addAll(masterList);
		
		//Comparator<Customer> byName = (Customer o1, Customer o2)->o1.getId().compareTo(o2.getId());
		finalList.sort((Customer o1, Customer o2)->o1.getId().compareTo(o2.getId()));
		
		return finalList;
	}
	
	public Customer getCustomer(Long id) {
		Customer customer=null;
		List<Customer> list = new ArrayList<>();
		customerRepository.findAll().forEach(list :: add);
		customer = list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return customer;
	}
	
	public Response createNewCustomer(CustomerWork customer) {
		customer.setStatus("UnAuthorized");
		
		Response response = null;
		
		Validator validator = new CustomerValidator();
		BindException errors=null;
		String[] errorArr = null;
		
		System.out.println("In customer service ............" + customer);
		if(customer != null) {			

			ValidationUtils.invokeValidator(validator, customer, errors);
			
			System.out.println("In customer service 2 ............");
			
			response = new Response();
			
			if(errors != null && errors.hasErrors())
			{	
				System.out.println("In customer service 3 ............");
				
				for (ObjectError error : errors.getAllErrors()) 
				{					
					errorArr = error.getCodes();
				}
				
				response.setErrors(errorArr);
			}
		}
		
		workRepository.save(customer);
	
		return response;
	}
	
	public Response validateCustomer(CustomerWork customerWork) {
		customerWork.setStatus("Validated");
		
		Response response = null;
		
		Validator validator = new CustomerValidator();
		BindException errors=null;
		String[] errorArr = null;
		
		if(customerWork != null) {			

			ValidationUtils.invokeValidator(validator, customerWork, errors);

			response = new Response();
			
			if(errors != null && errors.hasErrors())
			{	
				for (ObjectError error : errors.getAllErrors()) 
				{					
					errorArr = error.getCodes();
				}
				
				response.setErrors(errorArr);
			}
		}
		
		workRepository.save(customerWork);
		
		return response;
	}
	
	public Response authorizeCustomer(CustomerWork customerWork) {
		customerWork.setStatus("Authorized");
		
		Response response = null;
		
		Validator validator = new CustomerValidator();
		BindException errors=null;
		String[] errorArr = null;
		
		if(customerWork != null) {			

			ValidationUtils.invokeValidator(validator, customerWork, errors);

			response = new Response();
			
			if(errors != null && errors.hasErrors())
			{	
				for (ObjectError error : errors.getAllErrors()) 
				{					
					errorArr = error.getCodes();
				}
				
				response.setErrors(errorArr);
			}
		}
		
		workRepository.save(customerWork);
		
		Customer customer=Customer.getCustomer(customerWork);
		
		customerRepository.save(customer);
		
		return response;
	}
	
	public Response updateCustomerInformation(Customer customer) {
		
		Response response = null;
		
		Validator validator = new CustomerValidator();
		BindException errors=null;
		String[] errorArr = null;
		
		
		if(customer != null) {			

			ValidationUtils.invokeValidator(validator, customer, errors);

			response = new Response();
			
			if(errors != null && errors.hasErrors())
			{	
				for (ObjectError error : errors.getAllErrors()) 
				{					
					errorArr = error.getCodes();
				}
				
				response.setErrors(errorArr);
			}
		}
		
		customerRepository.save(customer);
		
		return response;
	}
	
	public Response removeCustomer(Long id) {
		
		List<Customer> list = new ArrayList<>();
		String[] errorArr = new String[1];
		Response response=null;
		
		customerRepository.findAll().forEach(list :: add);
		
		if(list != null && list.size() == 0) {
				
			errorArr[0] = "INVALID_CUSTOMER";
			response = new Response();
			
			response.setErrors(errorArr);
		}
		
		Customer customer = list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		customerRepository.delete(customer);
		
		return response;
	}
	
	public void setCustomerRepository(CustomerRepository repository) {
		this.customerRepository=repository;
	}
	
	public void setCustomeWorkRepository(CustomerWorkRepository workRepository) {
		this.workRepository=workRepository;
	}
	
	/**
	 public static void main(String args[])
	  {
	     ArrayList<Customer> al1 = new ArrayList<Customer>();
	     ArrayList<Customer> al2 = new ArrayList<Customer>();
	     
			Customer customer1 = new Customer("Pankaj", "M",  new Date(), "PANKAJ1234T", 1234567890,
			"pankaj@demo.com", "ADD1", "ADD2", "ADD3", 411041);
			customer1.setId(new Long(1));

	  }
	  **/
}
