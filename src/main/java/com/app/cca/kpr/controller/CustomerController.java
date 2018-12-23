package com.app.cca.kpr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.cca.kpr.model.Customer;
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
	
	@RequestMapping(value="/customers/{id}", method=RequestMethod.GET)
	public Customer getCustomer(@PathVariable Long id) {
		Customer customer = service.getCustomer(id);
		
		return customer;
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.POST)
	public void add(@RequestBody Customer customer) {
		service.add(customer);
	}
	
	@RequestMapping(value="/customers/{id}", method=RequestMethod.PUT)
	public void update(@RequestBody Customer customer, @PathVariable Long id) {
		System.out.println("in controller..............");
		service.update(customer);
	}
	
	@RequestMapping(value="/customers/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
