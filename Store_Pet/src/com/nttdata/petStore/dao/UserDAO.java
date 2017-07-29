package com.nttdata.petStore.dao;
import com.nttdata.petStore.domain.Customer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import org.apache.log4j.Logger;

public class UserDAO {
	static final Logger log = Logger.getLogger(UserDAO.class);
	public static Object registerUser(final Customer customerObject) throws PetStoreDAOException
	
	{
		ConnectionHolder ch;
		Connection con=null;
	Integer count=null;
		
		ParamMapper inmap1=new ParamMapper() {
			
			@Override
			public void mapParams(PreparedStatement prestmt) throws SQLException {
				prestmt.setString(1,customerObject.getCustId());
				prestmt.setString(2,customerObject.getPassword());
				
			}
		};
		ParamMapper inmap2=new ParamMapper() {
			
			@Override
			public void mapParams(PreparedStatement prestmt) throws SQLException {
				prestmt.setString(1, customerObject.getCustId());
				prestmt.setString(2, customerObject.getFirstName());
				prestmt.setString(3,customerObject.getLastName());
				prestmt.setDate(4, (Date) customerObject.getDateOfBirth());
				prestmt.setString(5,customerObject.getAddress());
				prestmt.setInt(6, customerObject.getContactNumber());
				prestmt.setInt(7, customerObject.getCreditCardNo());
				
			}
		};
		ParamMapper inmap3=new ParamMapper() {
			
			@Override
			public void mapParams(PreparedStatement prestmt) throws SQLException {
				prestmt.setInt(1, customerObject.getCreditCardNo());
				prestmt.setString(2, customerObject.getCardType());
				prestmt.setDate(3, (Date) customerObject.getCardExpiryDate());
				
			}
		};
		
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			try {
				DBHelper.executeUpdate(con, ValidateCreateUserMapper.insertIntoUser, inmap1);
				DBHelper.executeUpdate(con, ValidateCreateUserMapper.insertIntoCreditCard_info, inmap3);
				count=DBHelper.executeUpdate(con, ValidateCreateUserMapper.insertIntoCustomer , inmap2);
				
				
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
		
		return count;
	}
public static boolean validateUser(final String userId,final String password) throws PetStoreDAOException
{
	ConnectionHolder ch;
	Connection con=null;
	List<Customer> custname=null;
	ParamMapper inmap=new ParamMapper() {
		
		@Override
		public void mapParams(PreparedStatement prestmt) throws SQLException {
			prestmt.setString(1, userId);
			prestmt.setString(2, password);
			
		}
	};
	try {
		
		ch=ConnectionHolder.getInstance();
		con=ch.getConnection();
		
			custname=DBHelper.executeSelect(con, ValidateCreateUserMapper.validate, ValidateCreateUserMapper.object_outmap, inmap);
			
	}
		 catch (DBFWException e) {
			 log.debug(e);
			throw new PetStoreDAOException(e.getMessage());
		}
	 catch (DBConnectionException e) {
		 log.debug(e);
		System.out.println(e.getMessage());
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
if(custname.size()>0)
	return true;
else
	return false;
}

public static Integer generateCustId() throws PetStoreDAOException {
	ConnectionHolder ch;
	Connection con=null;
	List custid =null;
	try
	{
		
	ch = ConnectionHolder.getInstance();
	con = ch.getConnection();
			
	custid = DBHelper.executeSelect(con, ValidateCreateUserMapper.getcustid,ValidateCreateUserMapper.seqCustidValue);
	
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
	System.out.println("created orderid is"+custid.get(0));
	return (Integer)custid.get(0);
}

}



