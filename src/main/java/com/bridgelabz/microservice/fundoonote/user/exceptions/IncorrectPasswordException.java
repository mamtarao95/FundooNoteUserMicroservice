package com.bridgelabz.microservice.fundoonote.user.exceptions;

public class IncorrectPasswordException extends Exception {

	private static final long serialVersionUID = 1L;

	public IncorrectPasswordException(String message) {
		super(message);
	}

}
