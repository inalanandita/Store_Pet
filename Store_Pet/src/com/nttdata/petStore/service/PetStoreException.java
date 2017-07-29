package com.nttdata.petStore.service;

public class PetStoreException extends Exception {

	public PetStoreException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PetStoreException(Throwable cause) {
		super(cause);
		
	}

}
