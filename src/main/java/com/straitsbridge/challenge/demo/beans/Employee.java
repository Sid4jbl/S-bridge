package com.straitsbridge.challenge.demo.beans;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GeneratorType;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@CsvBindByName(column = "EMPID")
	private Long employeeId;
	@CsvBindByName(column = "ENAME")
	private String employeeName;
	@CsvBindByName(column = "HIREDDATE")
	private LocalDateTime hiredDate;
	@CsvBindByName(column = "SAL")
	private Long salary;
	@CsvBindByName(column = "DEPTID")
	private Integer departmentId;
	

}
