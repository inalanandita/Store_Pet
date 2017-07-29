package com.nttdata.petStore.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nttdata.dbfw.DBFWException;

public class ProductDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetCategories() throws PetStoreDAOException, DBFWException {
		
		Object obj=ProductDAO.getCategories();
		assertNotNull(obj);
	}

	@Test
	public void testGetCatById() throws PetStoreDAOException {
		Object obj=ProductDAO.getCatById(103);
		assertNotNull(obj);
	}

	@Test
	public void testGetProductList() throws PetStoreDAOException {
		Object obj=ProductDAO.getProductList(102);
		assertNotNull(obj);
	}

	@Test
	public void testGetProduct() throws PetStoreDAOException {
		Object obj=ProductDAO.getProduct(102, 1002);
		assertNotNull(obj);
	}

	@Test
	public void testGetItemList() throws PetStoreDAOException {
		Object obj=ProductDAO.getItemList(102, 1002);
		assertNotNull(obj);
	}

	@Test
	public void testGetItem() throws PetStoreDAOException {
		Object obj=ProductDAO.getItem(102,1002,203);
		assertNotNull(obj);
	}

}
