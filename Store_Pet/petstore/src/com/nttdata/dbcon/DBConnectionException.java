package com.nttdata.dbcon;

public class DBConnectionException extends Exception{
	
	public DBConnectionException(String msg,Throwable cause)
	{
		super(msg,cause);
	}
	public DBConnectionException(String msg)
	{
		super(msg);
	}
}
