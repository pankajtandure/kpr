package com.app.cca.kpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.cca.kpr.model.Customer;
import com.app.cca.kpr.model.CustomerWork;
import com.app.cca.kpr.response.Response;
import com.app.cca.kpr.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = service.getAllCustomers();
		
		return customerList;
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable Long id) {
		Customer customer = service.getCustomer(id);
		
		return customer;
	}
	
	/**
	@RequestMapping(value="/customers", method=RequestMethod.GET)
	public List<CustomerWork> getAllCustomers() {
		List<CustomerWork> customerList = service.getAllCustomers();
		
		return customerList;
	}
	
	@RequestMapping(value="/customer/{id}", method=RequestMethod.GET)
	public CustomerWork getCustomer(@PathVariable Long id) {
		CustomerWork customer = service.getCustomer(id);
		
		return customer;
	}
	**/
	@PostMapping("/customer")
	//@RequestMapping(value="/customer", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Response> createNewCustomer(@RequestBody CustomerWork customer) {
		
		Response response = service.createNewCustomer(customer);
		
		if(response.getErrors() != null) {
			return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	//@RequestMapping(value="/customer", method=RequestMethod.PUT)
	@PutMapping("/customer")
	@ResponseBody
	public ResponseEntity<Response> validateCustomer(@RequestBody CustomerWork customer) {
		
		Response response = service.validateCustomer(customer);
		
		if(response.getErrors() != null) {
			return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	//@RequestMapping(value="/customer/authorize", method=RequestMethod.PUT)
	@PutMapping("/customer/authorize")
	@ResponseBody
	public ResponseEntity<Response> authorizeCustomer(@RequestBody CustomerWork customer) {

		Response response = service.authorizeCustomer(customer);
		
		if(response.getErrors() != null) {
			return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	//@RequestMapping(value="/customer/{id}", method=RequestMethod.PUT)
	@PutMapping("/customer/{id}")
	@ResponseBody
	public ResponseEntity<Response> updateCustomerInformation(@RequestBody Customer customer, @PathVariable Long id) {
		
		Response response = service.updateCustomerInformation(customer);
		
		if(response.getErrors() != null) {
			return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
		
	//@RequestMapping(value="/customer/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/customer/{id}")
	@ResponseBody
	public ResponseEntity<Response> removeCustomer(@PathVariable Long id) {
		
		Response response = service.removeCustomer(id);
		
		if(response.getErrors() != null) {
			return new ResponseEntity<Response>(response, HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
}
