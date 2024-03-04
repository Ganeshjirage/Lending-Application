package com.banking.app.exception;

public class UsernameNotFoundException extends RuntimeException {
	public UsernameNotFoundException(String name, Integer id) {
		super(name + " NOT found with ID : " + id);
	}

	public UsernameNotFoundException(String name, String id) {
		super(name + " NOT found with ID : " + id);
	}

	public UsernameNotFoundException(String message) {
		super(message);
	}
}
