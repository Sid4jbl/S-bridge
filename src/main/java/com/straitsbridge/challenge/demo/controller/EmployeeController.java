package com.straitsbridge.challenge.demo.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.straitsbridge.challenge.demo.beans.Employee;
import com.straitsbridge.challenge.demo.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	
	@PostMapping("/upload-csv")
	 public String uploadCSVFile(@RequestParam("employee") MultipartFile file) {
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<Employee> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Employee.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            // convert `CsvToBean` object to list of employee
            List<Employee> empoyeeCsvList = csvToBean.parse();
            log.info("empoyeeCsvList"+empoyeeCsvList);
            return employeeService.saveAllEmplopee(empoyeeCsvList);
            
		
	}
		catch(Exception e ) {
			log.error("Exception occured :: "+e.getLocalizedMessage());
		}
		return "Uploaded successfully";
		}
	
	@PostMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity(employeeService.updateEmployee(employee),HttpStatus.OK);
	}
	
	@GetMapping("/get/{employeeId}")
	public ResponseEntity<Employee> geteEmployee(@PathVariable("employeeId") Long employeeId) {
		return new ResponseEntity(employeeService.getEmployee(employeeId),HttpStatus.OK);
	}
	
	
	@GetMapping("/get/all")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		return new ResponseEntity(employeeService.getAllEmployeebySalary(),HttpStatus.OK);
	}


}
