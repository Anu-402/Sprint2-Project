package com.cg.bookStore.exceptions;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String message)
	{
		super(message);
	}
	public UserNotFoundException()
	{}

}
