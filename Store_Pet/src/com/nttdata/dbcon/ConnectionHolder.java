package com.nttdata.dbcon;
import org.apache.commons.dbcp.BasicDataSource;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionHolder {
	private static ConnectionHolder instance=null;
	private javax.sql.DataSource datasource=null;
	private static final org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(ConnectionHolder.class);
	
	private ConnectionHolder()
	{
		super();
	}
	
	private void initAppserverDatasource() throws DBConnectionException
	{
		Context initContext;
		try {
			initContext=new InitialContext();
			Context envContext=(Context)initContext.lookup("java:/comp/env");
			datasource=(DataSource)envContext.lookup("jdbc/MyDB");
		} catch (NamingException e) {
			throw new DBConnectionException("unable to get datasource",e);
		}
		
		
		
	}
	private void initAppDatasource() throws DBConnectionException
	{
		String url;
		try
		{
			String user,pwd;
			final BasicDataSource bds=new BasicDataSource();
			final Properties prop=new Properties();
			prop.load(new FileInputStream("jdbcds.properties"));
			user=prop.getProperty("uname");
			pwd=prop.getProperty("pwd");
			url=prop.getProperty("url");
			final String driverclass=prop.getProperty("driver");
			bds.setUrl(url);
			bds.setDriverClassName(driverclass);
			bds.setUsername(user);
			bds.setPassword(pwd);
			this.datasource=bds;			
		} 
		catch (FileNotFoundException e)
		{
			log.debug("FileNotFoundException "+e);
			throw new DBConnectionException("unable to get the connection data to the database",e);
			
		}catch(IOException e)
		{
			log.debug("IoException"+e);
			throw new DBConnectionException("unable to get the connection data to the database",e);
		}
		
	}
	
	public static ConnectionHolder getInstance() throws DBConnectionException
	{
		synchronized (Connection.class)
		{
			if(instance==null)
			{
				instance=new ConnectionHolder();
				instance.initAppserverDatasource();
				//instance.initAppDatasource();
			}
		}
		return instance;
	}
	public Connection getConnection() throws DBConnectionException
	{
		try
		{
			return datasource.getConnection();
		} catch (SQLException e)
		{
			log.debug(e);
			throw new DBConnectionException("unable to get a connection",e);
		}
	}
	public void dispose() throws DBConnectionException
	{
		final BasicDataSource bds=(BasicDataSource)datasource;
		try
		{
			bds.close();
		
		} catch (Exception e)
		{
			log.debug(e);
			throw new DBConnectionException("unable to close a connection",e);
		}
}
}