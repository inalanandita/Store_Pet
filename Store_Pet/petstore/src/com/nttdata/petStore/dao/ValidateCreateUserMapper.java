package com.nttdata.petStore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.nttdata.dbfw.ResultMapper;
import com.nttdata.petStore.domain.Customer;

public class ValidateCreateUserMapper {
public static final String validate="select custid from user_86078 where custid=? and password=?";
public static final String getcustid = "SELECT custid_86078.nextval FROM dual";
public static final String insertIntoUser="insert into user_86078 values(?,?)";
public static final String insertIntoCustomer="insert into customer_86078 values(?,?,?,?,?,?,?)";
public static final String insertIntoCreditCard_info="insert into creditcard_info_86078 values(?,?,?)";
public static final ResultMapper object_outmap=new ResultMapper() {
	
	@Override
	public Object mapRow(ResultSet rs) throws SQLException {
		String custid=rs.getString(1);
		Customer customer=new Customer(custid);

		return customer;
	}
}; 
public static final ResultMapper seqCustidValue=new ResultMapper() {
	
	@Override
	public Object mapRow(ResultSet rs) throws SQLException {
		Integer orderId=rs.getInt(1);
		return orderId;
	}
};
}
