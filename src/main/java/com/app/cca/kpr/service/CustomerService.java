package com.app.cca.kpr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.cca.kpr.model.Customer;
import com.app.cca.kpr.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;

	public List<Customer> getAllCustomers() {

//		CustomerProfile customer = new CustomerProfile("Pankaj", new Date(), "PANKAJ1234T", 1234567890,
//				"pankaj@demo.com", "ADD1", "ADD2", "ADD3", 411041);

		List<Customer> list = new ArrayList<>();
				
		repository.findAll().forEach(list::add);
		
		return list;
	}
	
	public Customer getCustomer(Long id) {
		Customer customer=null;
		List<Customer> list = new ArrayList<>();
		repository.findAll().forEach(list :: add);
		customer = list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
		return customer;
	}
	
	public void add(Customer customer) {
		repository.save(customer);
	}
	
	public void update(Customer customer) {
		System.out.println("in service ..............");
		repository.save(customer);
	}
	
	public void delete(Long id) {
		List<Customer> list = new ArrayList<>();
		repository.findAll().forEach(list :: add);
		Customer customer = list.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		repository.delete(customer);
	}
}
