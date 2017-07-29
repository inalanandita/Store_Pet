package com.nttdata.mvc;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MvcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MvcController() {
        super();
        
    }

	
    public Map handlers;
    public void init(ServletConfig config) throws ServletException
    {
  	  super.init(config);
  	  String mvcProps=getServletContext().getRealPath("/WEB-INF/mvc.properties");
  	  try
  	  {
  		  this.handlers=MvcUtil.buildHandlers(mvcProps);
  	  }
  	  catch(MVCException e)
  	  {
  		  throw new ServletException("unable to config controller servlet",e);
  	  } catch (InstantiationException e) {
  		  throw new ServletException("unable to config controller servlet",e);
  		
  	} catch (IllegalAccessException e) {
  		throw new ServletException("unable to config controller servlet",e);
  		
  	} 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getServletPath();
		int begin=url.lastIndexOf('/');
		String key=url.substring(begin+1,url.lastIndexOf('.'));
		
		HttpRequestHandler handler=(HttpRequestHandler)handlers.get(key);
		if(handler!=null)
		{
			handler.handle(request, response);
		}
		else
		{
			throw new ServletException("no matching found");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
