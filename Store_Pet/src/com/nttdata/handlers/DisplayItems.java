package com.nttdata.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.petStore.dao.PetStoreDAOException;
import com.nttdata.petStore.dao.ProductDAO;
import com.nttdata.petStore.domain.Item;
import com.nttdata.petStore.domain.Product;

public class DisplayItems implements HttpRequestHandler {

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
		String categId=request.getParameter("categid");
		int categid=Integer.parseInt(categId);
		String prodid=request.getParameter("prodid");
		int productid=Integer.parseInt(prodid);
		List<Item> items=null;
		try {
			items=ProductDAO.getItemList(categid, productid);
			request.setAttribute("itemslist",items);
			RequestDispatcher rd=request.getRequestDispatcher("displayitems.jsp");
			rd.forward(request, response);
			
			
		} catch (PetStoreDAOException e) {
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
		} 
		}

	}

}
