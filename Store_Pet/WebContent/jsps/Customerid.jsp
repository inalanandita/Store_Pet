<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
 <%@taglib  prefix="c_rt"  uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Stylesheet.css" rel="stylesheet" type="text/css" />
<title>Customer Id</title>
</head>
<body bgcolor="#DCDCDC">
<form method="post">
<h1>Your Customer id is :
<%out.print(request.getAttribute("customerid")); %></h1><br>
</form>
<h2><a href="login.jsp"> Login</a> to purchase</h2>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<h3 class="ss" align="right">©2012 NTTDATA All rights reserved.</h3>
</body>
</html>