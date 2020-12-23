/*
 * Exception class to handle the exceptions
 */
package com.cg.elecpurchapp.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ElectronicProductOrderNotFoundException extends RuntimeException {
	public  ElectronicProductOrderNotFoundException() {
		// TODO Auto-generated constructor stub
	}
}
