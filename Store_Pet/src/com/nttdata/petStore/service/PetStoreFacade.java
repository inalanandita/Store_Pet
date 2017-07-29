package com.nttdata.petStore.service;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.nttdata.dbfw.DBFWException;
import com.nttdata.petStore.domain.Cart;
import com.nttdata.petStore.domain.Category;
import com.nttdata.petStore.domain.Item;
import com.nttdata.petStore.domain.Product;
import com.nttdata.petStore.dao.OrderDAO;
import com.nttdata.petStore.dao.PetStoreDAOException;
import com.nttdata.petStore.dao.ProductDAO;
import com.nttdata.petStore.dao.UserDAO;
import com.nttdata.petStore.domain.Customer;

public class PetStoreFacade {
	public static boolean validateUser(String custid,String password) throws PetStoreDAOException
	{
		boolean ok=false;
		
		ok=UserDAO.validateUser(custid, password);
		return ok;
	}
	public static int registerUser() throws PetStoreDAOException
	{
		Integer custid=0;
		Scanner scan=new Scanner(System.in);
		 System.out.println("Enter the password");
		   String password=scan.next();
		   System.out.println("Enter the firstname");
		   String firstName=scan.next();
		   System.out.println("Enter the lastname");
		   String lastName=scan.next();
		   System.out.println("Enter the date of birth");
		  String str=scan.next();
		  Date dob=Date.valueOf(str);
		   System.out.println("Enter the Address");
		   String address=scan.next();
		   System.out.println("Enter the contact number");
		   int contactNo=scan.nextInt();
		   System.out.println("Enter the credit card number");
		   int creditCardNo=scan.nextInt();
		   System.out.println("Enter the credit card type");
		   String cardType=scan.next();
		   System.out.println("Enter the Card Expiry date");
		   String str1=scan.next();
		   Date expiryDt=Date.valueOf(str1);
		   Customer customer=new Customer(password, firstName, lastName, dob, address, contactNo, creditCardNo, cardType, expiryDt);
		  
			custid=(Integer)UserDAO.registerUser(customer);
		return custid;
		
	}
	public static List<Category> getCategories() throws PetStoreDAOException, DBFWException
	{
		List<Category> listOfAllCategories=null;
		listOfAllCategories=ProductDAO.getCategories();
		return listOfAllCategories;
	}
	public static List<Category> getCatById(int categid) throws PetStoreDAOException {
		List<Category> listOfCategories=null;
		listOfCategories=ProductDAO.getCatById(categid);
		return listOfCategories;
	}
	public static List<Product> getAllProductList(int categid) throws PetStoreDAOException
	{
		List<Product> listOfProductsOfCategId=null;
		listOfProductsOfCategId=ProductDAO.getProductList(categid);
		return listOfProductsOfCategId;
	}
	public static List<Product> getProduct(int categid,int prodid) throws PetStoreDAOException
	{
		List<Product> listOfProduct=null;
		listOfProduct=ProductDAO.getProduct(categid, prodid);
		return listOfProduct;
	}
	public static List<Item> getItemList(int categId, int productId) throws PetStoreDAOException
	{
		List<Item> listofitemsoncategidprodid=null;
		listofitemsoncategidprodid=ProductDAO.getItemList(categId, productId);
		return listofitemsoncategidprodid;
	}
	public static List<Item> getItem(int categId,int prodId,int itemId) throws PetStoreDAOException
	{
		List<Item> listofitemsoncategidprodiditemid=null;
		listofitemsoncategidprodiditemid=ProductDAO.getItem(categId, prodId, itemId);
		return listofitemsoncategidprodiditemid;
	}
	public static int placeOrder(Cart shoppingCart) throws PetStoreDAOException
	{
		Integer noOfRowsinserted=0;
		noOfRowsinserted=(Integer) OrderDAO.placeOrder(shoppingCart);
		return noOfRowsinserted;
	}
	public static List getPurchaseDetails(int orderId) throws PetStoreDAOException
	{
		List<Cart> listOfItems=null;
		listOfItems=OrderDAO.getPurchasedetails(orderId);
		return listOfItems;
	}
}
	
