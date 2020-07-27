package com.mohamed.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mohamed.app.exceptions.StudentNotFound;
import com.mohamed.app.response.CustomerResponse;
import com.mohamed.app.response.InstructorResponce;

@ControllerAdvice
public class ControllerAdv {

	
	@ExceptionHandler
	public ResponseEntity<CustomerResponse> geterrorMessage(StudentNotFound exc) {

		CustomerResponse error = new CustomerResponse();
		error.setState(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<CustomerResponse>(error, HttpStatus.NOT_FOUND);

	}
	
//	@ExceptionHandler
//	public ResponseEntity<CustomerResponse> atherExc(Exception exc) {
//
//		CustomerResponse error = new CustomerResponse();
//		error.setState(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		return new ResponseEntity<CustomerResponse>(error, HttpStatus.BAD_REQUEST);
//
//	}
	
	@ExceptionHandler
	public ResponseEntity<InstructorResponce> insExc(Exception exc) {

		InstructorResponce error = new InstructorResponce();
		error.setState(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<InstructorResponce>(error, HttpStatus.BAD_REQUEST);

	}
	
}
