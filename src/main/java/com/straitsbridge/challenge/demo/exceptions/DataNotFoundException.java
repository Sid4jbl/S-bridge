package com.straitsbridge.challenge.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@AllArgsConstructor
@Getter
@Setter
public class DataNotFoundException extends RuntimeException {
	private String message;
	public DataNotFoundException(String message) {
		super();
		this.message = message;
	}
	
	

}
