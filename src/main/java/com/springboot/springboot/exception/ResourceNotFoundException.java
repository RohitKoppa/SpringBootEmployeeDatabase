package com.springboot.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;  //remember versions of a Serializable class to 
	//verify that a loaded class and the serialized object are compatible

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
