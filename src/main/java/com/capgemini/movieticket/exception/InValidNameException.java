package com.capgemini.movieticket.exception;

public class InValidNameException extends RuntimeException{
	public InValidNameException(String exception)
	{
		
		System.err.println(exception);
	}

}
