package com.cg.bookStore.exceptions;

public class ListNotFoundException extends RuntimeException {
	public ListNotFoundException(String message)
	{
		super(message);
	}
	public ListNotFoundException()
	{}

}
