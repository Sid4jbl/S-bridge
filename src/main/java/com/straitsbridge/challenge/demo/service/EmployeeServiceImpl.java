package com.straitsbridge.challenge.demo.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.straitsbridge.challenge.demo.beans.Employee;
import com.straitsbridge.challenge.demo.exceptions.DataNotFoundException;
import com.straitsbridge.challenge.demo.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Optional<Employee> employeeObject =  employeeRepository.findById(employee.getEmployeeId());
		if(!employeeObject.isPresent()) {
			throw new DataNotFoundException("Data not found");
		}
		employee.setEmployeeId(employeeObject.get().getEmployeeId());
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Optional<Employee> employee =  employeeRepository.findById(employeeId);
		if(!employee.isPresent()) {
			throw new DataNotFoundException("Data not found");
		}
		return employee.get();
	}

	@Override
	public List<Employee> getAllEmployeebySalary() {
		// 2nd highest Salary List 
		List<Employee> epmloyeeList =  (List<Employee>) employeeRepository.findAll();
		List<Employee> newEmployeeList = epmloyeeList.stream().sorted(Comparator.comparingLong(Employee :: getSalary).reversed()).skip(1).collect(Collectors.toList());
	
		log.info("newEmployeeList:: "+newEmployeeList);
		if(newEmployeeList.isEmpty()) 
			throw new DataNotFoundException("Data not found");
		return newEmployeeList;
	}

	@Override
	// Save all employee from csv file
	public String saveAllEmplopee(List<Employee> employeeList) {
		for(Employee employee : employeeList) {
			employeeRepository.save(employee);
		}
		return "Success";
	}

}
