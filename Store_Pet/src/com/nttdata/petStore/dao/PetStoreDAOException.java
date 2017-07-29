package com.nttdata.petStore.dao;

public class PetStoreDAOException extends Exception{

	public PetStoreDAOException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PetStoreDAOException(String message) {
		super(message);
		
	}

}
