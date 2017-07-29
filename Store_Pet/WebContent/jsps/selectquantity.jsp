<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="C" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<title>Enter quantity for item</title>


</head>
<body>
<form name="form" action="logout.pet">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="right">&nbsp;</td>
		<!-- #BeginEditable "page title" -->
		<td class="lblTitle">
		<div id='DIVPageTitle'><b>List of Items Available</b></div>
		</td>
 
		<!-- #EndEditable -->
		<td width="266" align="right" valign="top"><img src="gssmlanm.gif" width="100" height="100"></td>
	</tr>
	<tr height="13%" align="left">
		<td colspan="3" class="blueBackGround"></td>
	</tr>
	<tr height="13%" align="left" valign="top">
		<td colspan="3" class="orangeBackGround"></td>
	</tr>
	<tr>
				<td width="10">&nbsp;</td>
				<td class=lblError></td>
				<td class=error align="right">
				<div align="right">
				<input type="submit" value="LOGOUT" name="BTN_CLOSE" title="Close the Current Window">
			
				</div>
				</td>
				<td width="10">&nbsp;</td>
			</tr>
</table>
</form><br><br>
<form method="post" name="form" action="displaycart.pet?categid=${requestScope.categid}&prodid=${requestScope.prodid}&itemid=${requestScope.itemid}&price=${requestScope.price}">

<table width="100%" border="2" cellspacing="2" cellpadding="2"
                    class=outerTable align="center" id=TABLE1>
 							 <tr>
                  
                  <td class="tblHeader" width="10%" height="10">CTGY ID</td>
                  <td class="tblHeader" width="10%" height="10">PROD ID</td>
                  <td class="tblHeader" width="10%" height="10">ITEM ID</td>
                  <td class="tblHeader" width="20%" height="10">ITEM NAME</td>
                  <td class="tblHeader" width="10%" height="10">PRICE</td>
                  <td class="tblHeader" width="10%" height="10">QUANTITY</td>
                </tr>
			    <tr>
                 
                  <td class="tblDataText" >&nbsp; ${requestScope.categid}</td>
                  <td class="tblDataText" >&nbsp; ${requestScope.prodid} </td>
                  <td class="tblDataText" >&nbsp; ${requestScope.itemid} </td>
                  <td class="tblDataText" >&nbsp;${requestScope.itemname} </td>
                 
                  <td class="tblDataText" > &nbsp; ${requestScope.price} </td>
                  <td class="tblDataText" ><INPUT type="text" 
            name="quantity" value="" style="HEIGHT: 22px; WIDTH: 77px"> &nbsp; </td>
                </tr>
                </table><br>
                
      		
      		<BUTTON name=BTN_BACK style="HEIGHT: 35px; LEFT: 5px; TOP: 0px; WIDTH: 200px" 
      		onClick="form.submit();">ADD TO CART</BUTTON>
      		
      		
</form>
</body>
</html>