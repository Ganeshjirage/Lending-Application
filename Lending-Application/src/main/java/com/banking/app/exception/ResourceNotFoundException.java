package com.banking.app.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String name, Integer id) {
		super(name + " NOT found with ID : " + id);
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
