package com.straitsbridge.challenge.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.straitsbridge.challenge.demo.beans.Employee;

@Repository
public interface EmployeeRepository  extends CrudRepository<Employee, Long>{
	
	

}
