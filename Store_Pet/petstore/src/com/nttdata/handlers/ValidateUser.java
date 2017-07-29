package com.nttdata.handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.petStore.dao.PetStoreDAOException;
import com.nttdata.petStore.dao.UserDAO;

public class ValidateUser implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		try {
			boolean userExist=UserDAO.validateUser(username, password);
			
			if(userExist)
			{
			session.setAttribute("user", username);
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
			rd.forward(request, response);
			}
			else
			{
				String invalid="invalid customerId and password please enter correct details";
				request.setAttribute("invalid",invalid);
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			
				rd.forward(request, response);
			}
			
			
		} catch (PetStoreDAOException e) {
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
		}

	}

	}


