package com.nttdata.petStore.dao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.petStore.domain.Category;
import com.nttdata.petStore.domain.Item;
import com.nttdata.petStore.domain.Product;

public class ProductDAO {
	static final Logger log = Logger.getLogger(ProductDAO.class);
public static List<Category> getCategories() throws PetStoreDAOException, DBFWException
{
	ConnectionHolder ch;
	Connection con=null;
	List<Category> category;
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		try {
			category=DBHelper.executeSelect(con, CategoriesProductItemListMapper.selectAllCategories,
					CategoriesProductItemListMapper.object_categories);
		} catch (DBFWException e) {
			con=ch.getConnection();
			category=DBHelper.executeSelect(con, CategoriesProductItemListMapper.selectAllCategories,
					CategoriesProductItemListMapper.object_categories);
		}
	} catch (DBConnectionException e) {
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
	return category;
	
}

public static List getCatById(final int categid) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;
	List<Category> category=null;
	ParamMapper inmap1=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
		prestmt.setInt(1, categid);
			
		}
	};
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		
		
			category=DBHelper.executeSelect(con, CategoriesProductItemListMapper.getCatById,
					CategoriesProductItemListMapper.object_categories,inmap1);
	} catch (DBFWException e) {
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
	return category;
}

public static List<Product> getProductList(final int categid) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;
	List<Product> category=null;
	ParamMapper inmap1=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
		prestmt.setInt(1, categid);
			
		}
	};
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		
		
			category=DBHelper.executeSelect(con, CategoriesProductItemListMapper.getProductById,
					CategoriesProductItemListMapper.object_parts,inmap1);
	} catch (DBFWException e) {
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
	return category;
}
public static List getProduct(final int categid,final int prodid) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;
	List<Product> parts=null;
	ParamMapper inmap1=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
		prestmt.setInt(1, categid);
		prestmt.setInt(2, prodid);
			
		}
	};
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		
		
			parts=DBHelper.executeSelect(con, CategoriesProductItemListMapper.getProductByPIdCatgId,
					CategoriesProductItemListMapper.object_parts,inmap1);
	} catch (DBFWException e) {
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
	return parts;
}

public static List<Item> getItemList(final int categId,final int productId) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;
	List<Item> itemList=null;
	ParamMapper CatidProdId_input=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
			prestmt.setInt(1, categId);
			prestmt.setInt(2, productId);
			
		}
	};
	
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		try {
			itemList=DBHelper.executeSelect(con, CategoriesProductItemListMapper.getProductLineItemsByCatProd,
					CategoriesProductItemListMapper.object_ProductLineItems, CatidProdId_input);
		} catch (DBFWException e) {
			log.debug(e);
			throw new PetStoreDAOException(e.getMessage());
		}
	} catch (DBConnectionException e) {
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
	return itemList;
}
public static List getItem(final int categId,final int productId,final int itemId) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;
	List<Item> itemList=null;
	ParamMapper CatidProdId_input=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
			prestmt.setInt(1, categId);
			prestmt.setInt(2, productId);
			prestmt.setInt(3, itemId);
			
		}
	};
	
	try {
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		try {
			itemList=DBHelper.executeSelect(con, CategoriesProductItemListMapper.getProductLineItemsByCatProdItem,
					CategoriesProductItemListMapper.object_ProductLineItems, CatidProdId_input);
		} catch (DBFWException e) {
			log.debug(e);
			throw new PetStoreDAOException(e.getMessage());
		}
	} catch (DBConnectionException e) {
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
	return itemList;
}


}
