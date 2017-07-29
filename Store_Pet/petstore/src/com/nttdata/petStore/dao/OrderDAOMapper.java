package com.nttdata.petStore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nttdata.dbfw.ResultMapper;
import com.nttdata.petStore.domain.Cart;
import com.nttdata.petStore.domain.CartItem;
import com.nttdata.petStore.domain.Item;

public class OrderDAOMapper {
	public static final String getorderid = "SELECT orderid_86078.nextval FROM dual";
	public static final String getPrice="Select price from product_line_items_86078 where categid=? and prodid=? and itemid=?";
	public static final String getpurchasedetail = "SELECT orderid,custid,itemid,prodid,categid,quantity FROM purchase_detail_86078 WHERE orderid=?";
	public static final String insertIntoCart="insert into purchase_detail_86078 values(?,?,?,?,?,?) ";
	
	public static final ResultMapper getTotalPrice=new ResultMapper() {
		
		@Override
		public Object mapRow(ResultSet rs) throws SQLException {
			Integer price=rs.getInt(1);
			return price;
		}
	};
	
	public static final ResultMapper object_getPurchaseDetails=new ResultMapper() {
	
	public Object mapRow(ResultSet rs) throws SQLException
	{
		
	
	int orderId=rs.getInt(1);
	String custId=rs.getString(2);
	
		
		int itemid = rs.getInt(3);
		int productid = rs.getInt(4);
		int categoryid = rs.getInt(5);
		int quantity = rs.getInt(6);
	
	Cart cart=new Cart(orderId, custId, itemid, productid, categoryid, quantity);
	return cart;
	}
};
public static final ResultMapper seqValue=new ResultMapper() {
	
	@Override
	public Object mapRow(ResultSet rs) throws SQLException {
		Integer orderId=rs.getInt(1);
		return orderId;
	}
};
public static final ResultMapper object_getPrice=new ResultMapper() {
	
	public Object mapRow(ResultSet rs) throws SQLException {
		Double price=rs.getDouble(1);
		return price;
	}
};

}
