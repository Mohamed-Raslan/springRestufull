package com.mohamed.app.exceptions;

public class StudentNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public StudentNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

}
