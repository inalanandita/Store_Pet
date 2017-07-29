package com.nttdata.dbfw;


public class DBFWException extends Exception {
	public DBFWException(String msg,Throwable cause)
	{
		super(msg,cause);
	}
	public DBFWException(String msg)
	{
		super(msg);
	}
}

