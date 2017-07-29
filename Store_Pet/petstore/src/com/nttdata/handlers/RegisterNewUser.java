package com.nttdata.handlers;

import java.io.IOException;
import java.sql.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nttdata.mvc.HttpRequestHandler;
import com.nttdata.petStore.dao.PetStoreDAOException;
import com.nttdata.petStore.dao.UserDAO;
import com.nttdata.petStore.domain.Customer;

public class RegisterNewUser implements HttpRequestHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		Integer custid=null;
		String custId=null;
		try {
			custid=UserDAO.generateCustId();
			custId=String.valueOf(custid);
		} catch (PetStoreDAOException e) {
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
			
		}
		String password=request.getParameter("pass");
		String firstName=request.getParameter("first");
		String lastName=request.getParameter("last");
		String date=request.getParameter("dob");
		Date dob=Date.valueOf(date);
		String address=request.getParameter("addr");
		String number=request.getParameter("cont");
		int contactNumber=Integer.parseInt(number);
		String creditnumber=request.getParameter("creditno");
		
		int creditCardNo=Integer.parseInt(creditnumber);
		String cardType=request.getParameter("cardtype");
		String dateofexpiry=request.getParameter("expiry");
		Date doe=Date.valueOf(dateofexpiry);
		
		Customer customer=new Customer(custId,password, firstName, lastName, dob, address, contactNumber, creditCardNo, cardType, doe);
		try {
			UserDAO.registerUser(customer);
			request.setAttribute("customerid",custId);
			RequestDispatcher rd=request.getRequestDispatcher("Customerid.jsp");
			rd.forward(request, response);
			
			
		} catch (PetStoreDAOException e) {
			session.setAttribute("error", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
		}
	
	}

}
