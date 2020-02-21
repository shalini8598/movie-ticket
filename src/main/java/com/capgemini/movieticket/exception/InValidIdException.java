package com.capgemini.movieticket.exception;

public class InValidIdException extends RuntimeException {
	public InValidIdException(String exception)
	{
		
		System.err.println(exception);
	}

}
