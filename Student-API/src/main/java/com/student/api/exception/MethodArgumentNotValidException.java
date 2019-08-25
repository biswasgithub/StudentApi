package com.student.api.exception;

public class MethodArgumentNotValidException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MethodArgumentNotValidException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public Object getBindingResult() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
