package com.nttdata.mvc;

public class MVCException extends Exception{

	public MVCException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public MVCException(String message) {
		super(message);
	}

}
