package com.straitsbridge.challenge.demo.service;

import java.util.List;

import com.straitsbridge.challenge.demo.beans.Employee;

public interface IEmployeeService {
	
	public String saveAllEmplopee(List<Employee> employeeList);
	public Employee updateEmployee(Employee employee);
	public Employee getEmployee(Long employeeId);
	public List<Employee> getAllEmployeebySalary();
	

}
