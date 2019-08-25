package com.student.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentNotFoundException extends Exception{

	private static Logger logger=LoggerFactory.getLogger(StudentNotFoundException.class);
	
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message){
		super(message);
		logger.info("Inside StudentNotFoundException");
	}
		
}
