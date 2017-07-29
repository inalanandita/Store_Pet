package com.nttdata.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.petStore.dao.OrderDAO;
import com.nttdata.petStore.dao.PetStoreDAOException;
import com.nttdata.petStore.domain.Cart;
import com.nttdata.petStore.domain.Item;

public class DisplayCart implements HttpRequestHandler {

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
			int orderid=0;
		String categId=request.getParameter("categid");
		int categid=Integer.parseInt(categId);
		String prodid=request.getParameter("prodid");
		int productid=Integer.parseInt(prodid);
		String itemId=request.getParameter("itemid");
		int itemid=Integer.parseInt(itemId);
		String priceofitem=request.getParameter("price");
		double price=Double.parseDouble(priceofitem);
		
	
		String quantity=request.getParameter("quantity");
		int quan=Integer.parseInt(quantity);
		Double totalprice=price*quan;
		
		Double overallprice=(Double)session.getAttribute("overallamount");
		if(overallprice==null)
		{
			overallprice=0.0;
		}
		overallprice=overallprice+totalprice;
		
		
		
		
		
		List<Cart> productnames=(List)session.getAttribute("productlist");
		if(productnames==null)
		{
		productnames=new ArrayList<Cart>();
		try {
			orderid=OrderDAO.generateOrderid();
		} catch (PetStoreDAOException e) {
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
		}
		}
		
		Cart cart=new Cart(orderid, user, itemid, productid, categid, quan);
		
		
		productnames.add(cart);
		session.setAttribute("overallamount",overallprice);
		session.setAttribute("productlist", productnames);
		
			
				
				
				RequestDispatcher rd=request.getRequestDispatcher("displaycart.jsp");
				rd.forward(request, response);
				
				
			
			
			
			
		
		

	}

	}

}
