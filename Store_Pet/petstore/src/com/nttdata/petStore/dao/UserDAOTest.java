package com.nttdata.petStore.dao;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nttdata.petStore.domain.Customer;

public class UserDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testRegisterUser() throws PetStoreDAOException {
		String str="1991-06-06";
		  Date dob=Date.valueOf(str);
		  String str1="1991-06-06";
		  Date doe=Date.valueOf(str1);
		 
		 
		Customer cust=new Customer("hello","rakesh", "kumar",dob ," address", 9960456, 55564482, "visa", doe);
		Object obj=UserDAO.registerUser(cust);
		assertNotNull(obj);
		
	}

	@Test
	public void testValidateUser() throws PetStoreDAOException {
		
		boolean acctual=UserDAO.validateUser("29", "654");
		assertTrue(acctual);
		
		
	}

	@Test
	public void testGenerateCustId() throws PetStoreDAOException {
		int expected=64;
		int acctual=UserDAO.generateCustId();
		assertTrue(expected==acctual);
	}

}
