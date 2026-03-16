	package com.dsc.app.exceptions;
	
	public class RequiredFieldException extends RuntimeException {
	
	    public RequiredFieldException(String fieldName) {
	        super("Required Field Error: " + fieldName);
	    }
	}