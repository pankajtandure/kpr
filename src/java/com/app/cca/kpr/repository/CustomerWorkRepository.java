package com.app.cca.kpr.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.cca.kpr.model.CustomerWork;

@Repository
public interface CustomerWorkRepository extends CrudRepository<CustomerWork, Long>{

}
 	