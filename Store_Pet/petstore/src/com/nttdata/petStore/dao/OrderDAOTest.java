package com.nttdata.petStore.dao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nttdata.petStore.domain.Cart;
import com.nttdata.petStore.domain.Item;

public class OrderDAOTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testPlaceOrder() throws PetStoreDAOException {
		
		Cart cart=new Cart(29,1844);
		Item item=new Item( 202  ,     1004     ,   102          );
		
		Cart.addCartItem(item,4);
		Object expected=OrderDAO.placeOrder(cart);
		assertNotNull(expected);
		
	}

	@Test
	public void testGetPurchasedetails() throws PetStoreDAOException {
	int i=1035;
	Object obj=OrderDAO.getPurchasedetails(i);
	assertNotNull(obj);
	
	}

	

	@Test
	public void testGenerateOrderid() throws PetStoreDAOException {
		int actual=OrderDAO.generateOrderid();
		int expected=1044;
		assertTrue("the expected value and actuall value are same", actual==expected);
	}

}
