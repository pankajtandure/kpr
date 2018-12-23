package com.app.cca.kpr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.cca.kpr.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
 	