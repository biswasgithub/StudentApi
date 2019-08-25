package com.student.api.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ExceptionController.class);

	/*
	 * @ExceptionHandler(Exception.class) public final ResponseEntity<Object>
	 * handleAllException(Exception ex, WebRequest request) {
	 * logger.info("Inside handleAllException() method"); ErrorResponse error = new
	 * ErrorResponse(new Date(), "Server error", request.getDescription(false));
	 * return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR); }
	 */

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(new Date(), "Server error", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NoRecordsFoundException.class)
	public final ResponseEntity<Object> handleNoRecordsFoundException(NoRecordsFoundException ex, WebRequest request) {
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(new Date(), "Students records not found", details);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex,
			WebRequest request) {
		logger.info("Inside handleStudentNotFoundException() method");
		List<String> details=new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse(new Date(), "Requested sudent details not found", details);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}

	/*
	 * protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) {
	 * 
	 * Map<String, Object> body = new LinkedHashMap<>(); body.put("timestamp", new
	 * Date()); body.put("status", status.value());
	 * 
	 * //Get all errors List<String> errors = ex.getBindingResult() .getAllErrors()
	 * .stream() .map(x -> x.getDefaultMessage()) .collect(Collectors.toList());
	 * 
	 * body.put("errors", errors);
	 * 
	 * return new ResponseEntity<>(body, headers, status);
	 * 
	 * }
	 */

	//@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details=ex.getBindingResult() .getAllErrors().stream() .map(x -> x.getDefaultMessage()) .collect(Collectors.toList());
		//details.add(ex.getMessage());
		ErrorResponse error = new ErrorResponse(new Date(), "Validation failed", details);
		return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
	}

}
