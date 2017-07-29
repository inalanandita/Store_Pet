package com.nttdata.petStore.dao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.petStore.domain.Cart;
import com.nttdata.petStore.domain.CartItem;
import com.nttdata.petStore.domain.Item;

public class OrderDAO {
	static final Logger log = Logger.getLogger(OrderDAO.class);
	
public static Object placeOrder(final Cart shoppingCart) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;

	
	
	final Integer orderId=shoppingCart.getOrderId();
	final String custid=shoppingCart.getCustId();

	
	
	
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		

			insertNewOrder(shoppingCart,orderId,custid);
			
		
	} catch (DBConnectionException e) {
		log.debug(e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				log.debug(e);
				throw new PetStoreDAOException(e.getMessage());
			}
	
			
	}
	return orderId;
}


private static Integer insertNewOrder(final Cart shoppingCart,final int orderId,final String custid) throws PetStoreDAOException {
	ConnectionHolder ch;
	Connection con=null;
	Integer rowsInserted=0;
	ParamMapper INSERTINTOPRODUCTDETAILS=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
			List<CartItem> list=null;
			list=shoppingCart.getItemDetails();
			
			CartItem ci=list.get(0);
			
			Item item=ci.getItem();
			
			int quantity=ci.getQuantity();
			prestmt.setInt(1, orderId);
			prestmt.setString(2, custid);
			prestmt.setInt(3, item.getItemId());
			prestmt.setInt(4, item.getProductId());
			prestmt.setInt(5, item.getCategoryId());
			prestmt.setInt(6, quantity);
			
		}
	};
	
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		
			rowsInserted=DBHelper.executeUpdate(con,OrderDAOMapper.insertIntoCart , INSERTINTOPRODUCTDETAILS);
	}
		 catch (DBFWException e) {
			 log.debug(e);
			 throw new PetStoreDAOException(e.getMessage());
		}
	catch (DBConnectionException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	}
	finally
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				log.debug(e);
				throw new PetStoreDAOException(e.getMessage());
			}
	
			
	}
	
	return rowsInserted;
}


public static List<Cart> getPurchasedetails(final int orderid) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con = null;
	
	List<Cart> cartl = null;
	try {
		ch = ConnectionHolder.getInstance();
		con = ch.getConnection();
		ParamMapper orderid1=new ParamMapper() {
			
			@Override
			public void mapParams(PreparedStatement prestmt) throws SQLException {
				prestmt.setInt(1, orderid);
				
			}
		};
				
		cartl = DBHelper.executeSelect(con, OrderDAOMapper.getpurchasedetail,OrderDAOMapper.object_getPurchaseDetails,orderid1);;
	
		}
		

	catch (DBConnectionException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	} catch (DBFWException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	} finally {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				log.debug(e);
				throw new PetStoreDAOException(e.getMessage());
			}
		
	}
	

	return cartl;
}

public static List priceForOrderid(final int orderid) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;
	List price =null;
	ParamMapper pm=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
		prestmt.setInt(1, orderid);
			
		}
	};
	try
	{
		
	ch = ConnectionHolder.getInstance();
	con = ch.getConnection();
			
	price = DBHelper.executeSelect(con, OrderDAOMapper.getPrice,OrderDAOMapper.getTotalPrice,pm);
	
	} 
	
	catch (DBConnectionException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	} catch (DBFWException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	} finally {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				throw new PetStoreDAOException(e.getMessage());
			}
		
	}
	
	return price;
	
}


public static Double calculatePrice(final int itemid,final int prodid,final int categid) throws PetStoreDAOException 
{
	ConnectionHolder ch;
	Connection con=null;
	List price=null;
ParamMapper MAP_PRICE=new ParamMapper() {
		
		public void mapParams(PreparedStatement prestmt) throws SQLException {
			prestmt.setInt(3, itemid);
			prestmt.setInt(2, prodid);
			prestmt.setInt(1, categid);
			
		}
	};
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		price=DBHelper.executeSelect(con, OrderDAOMapper.getPrice, OrderDAOMapper.object_getPrice, MAP_PRICE);
	} catch (DBConnectionException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	} catch (DBFWException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	}finally
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				throw new PetStoreDAOException(e.getMessage());
			}
		}
	}
	
	
	return (Double)price.get(0);
	
	
}




public static int generateOrderid() throws PetStoreDAOException {
	ConnectionHolder ch;
	Connection con=null;
	List orderid =null;
	try
	{
		
	ch = ConnectionHolder.getInstance();
	con = ch.getConnection();
			
	orderid = DBHelper.executeSelect(con, OrderDAOMapper.getorderid,OrderDAOMapper.seqValue);
	
	} 
	
	catch (DBConnectionException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	} catch (DBFWException e) {
		log.debug(e);
		throw new PetStoreDAOException(e.getMessage());
	} finally {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				throw new PetStoreDAOException(e.getMessage());
			}
		
	}
	
	return (Integer) orderid.get(0);
}

}
