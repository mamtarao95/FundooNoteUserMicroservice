package com.bridgelabz.microservice.fundoonote.user.exceptions;

public class UserNotUniqueException extends Exception {
	private static final long serialVersionUID = 1L;

	public UserNotUniqueException(String message) {
		super(message);
	}

}
