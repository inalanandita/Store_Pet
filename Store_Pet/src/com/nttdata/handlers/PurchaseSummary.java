package com.nttdata.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.petStore.domain.Cart;

public class PurchaseSummary implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		
		String user=(String)session.getAttribute("user");
		if(user==null)
		{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		else
		{
			Double overallprice=(Double)session.getAttribute("overallamount");
			List<Cart> productnames=(List)session.getAttribute("productlist");
			session.setAttribute("overallamount",overallprice);
			session.setAttribute("productlist", productnames);
			
				
					
					
					RequestDispatcher rd=request.getRequestDispatcher("purchasesummary.jsp");
					rd.forward(request, response);
		}

	}

}
