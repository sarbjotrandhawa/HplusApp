package com.test.hplus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*This class helps to define exceptions at controllers level
so that all the controllers can use this exceptions
*/

@ControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ApplicationException.class)
	public String handleException() {
		System.out.println("in global exception handler");
		return "error";
	}

	@ExceptionHandler(LoginFailException.class)
	public ResponseEntity LoginFailExceptionHandler(LoginFailException ex) {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
	}
}
