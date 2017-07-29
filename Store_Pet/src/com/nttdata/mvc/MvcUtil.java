package com.nttdata.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

final public class MvcUtil {
private MvcUtil()
{
}
private static boolean checkInterface(Class clazz,String interfaceName)
{
	boolean found=false;
	Class[] interfaces=clazz.getInterfaces();
	for(int i=0;i<interfaces.length;i++)
	{
		if(interfaces[i].getName().equals(interfaceName))
		{
			found=true;
			break;
		}
	}
	return found;
}

public static Map buildHandlers(String propsFile) throws MVCException, InstantiationException, IllegalAccessException
{
	Map handlers=new HashMap();
	Properties props=new Properties();
	FileInputStream proStr=null;
	
		
		try {
			proStr=new FileInputStream(propsFile);
			props.load(proStr);
		 
		Enumeration enKeys=props.propertyNames();
		while(enKeys.hasMoreElements())
		{
			String key=(String)enKeys.nextElement();
			String clazz=props.getProperty(key);
			
				Class handClazz=Class.forName(clazz);
			 //check for instances
				if(checkInterface(handClazz,"com.nttdata.mvc.HttpRequestHandler"))
				{
					Object handler=handClazz.newInstance();
					handlers.put(key,handler);
				}
				else
				{
					throw new MVCException("class doesnot implement com.nttdata.mvc.HttpRequestHandler");
				}
				
			}
			}
		catch (FileNotFoundException e) {
			
			throw new MVCException(e.getMessage());
		}
	
catch (ClassNotFoundException e) {
	
	throw new MVCException(e.getMessage());
}
	catch (IOException e) {
		throw new MVCException(e.getMessage());
	}
	catch(InstantiationException e)
	{
		throw new MVCException(e.getMessage());
	}
	catch(IllegalAccessException e)
	{
		throw new MVCException(e.getMessage());
	}
	finally
	{
		try
		{
			proStr.close();
		}
		catch(IOException e)
		{
			throw new MVCException(e.getMessage());
		}
	}
	return handlers;
	
}

}
