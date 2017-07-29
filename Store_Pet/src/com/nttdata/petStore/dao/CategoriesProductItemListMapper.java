package com.nttdata.petStore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nttdata.dbfw.ResultMapper;
import com.nttdata.petStore.domain.Category;
import com.nttdata.petStore.domain.Item;
import com.nttdata.petStore.domain.Product;

public class CategoriesProductItemListMapper {
public static final String selectAllCategories="select * from Categories_86078";
public static final String getCatById="select * from categories_86078 where categid=?";
public static final String getProductById="select * from category_Products_86078 where categid=?";
public static final String getProductByPIdCatgId="select * from category_Products_86078 where categid=? and prodid=?";
public static final String getProductLineItemsByCatProd="select * from product_line_items_86078 where categid=? and prodid=?";
public static final String getProductLineItemsByCatProdItem="select * from product_line_items_86078 where categid=? and prodid=? and itemid=?";
public static final ResultMapper object_ProductLineItems=new ResultMapper() {
	
	@Override
	public Object mapRow(ResultSet rs) throws SQLException {
		int itemId=rs.getInt(1);
		int productId=rs.getInt(2);
		int categoryId=rs.getInt(3);
		String itemName=rs.getString(4);
		String itemDescription=rs.getString(5);
		int itemPrice=rs.getInt(6);
		Item item=new Item(itemId, productId, categoryId, itemName, itemDescription, itemPrice);
		return item;
	}
};
public static final ResultMapper object_categories=new ResultMapper() {
	
	@Override
	public Object mapRow(ResultSet rs) throws SQLException {
		int catgid=rs.getInt(1);
		String catgryname=rs.getString(2);
		String catdes=rs.getString(3);
		Category category=new Category(catgid,catgryname,catdes);
		return category;
	}
};
public static final ResultMapper object_parts=new ResultMapper() {
	
	@Override
	public Object mapRow(ResultSet rs) throws SQLException {
		
		int productid=rs.getInt(1);
		int categoryid=rs.getInt(2);
		String productname=rs.getString(3);
		String productdesc=rs.getString(4);
		Product product=new Product(productid, categoryid, productname, productdesc);
		
		
		return product;
	}
};
}
