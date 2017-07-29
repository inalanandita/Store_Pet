package com.nttdata.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.dbfw.DBFWException;
import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.petStore.dao.PetStoreDAOException;
import com.nttdata.petStore.dao.ProductDAO;
import com.nttdata.petStore.domain.Category;

public class DisplayCategories implements HttpRequestHandler {

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
		
		List<Category> categories=null;
		try {
			categories=ProductDAO.getCategories();
			request.setAttribute("categlist",categories);
			RequestDispatcher rd=request.getRequestDispatcher("displaycategories.jsp");
			rd.forward(request, response);
			
			
		} catch (PetStoreDAOException e) {
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
		} catch (DBFWException e) {
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
		}

	}
	}
}
