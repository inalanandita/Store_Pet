<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="C" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<title>Items List</title>

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
<TABLE align=center border=2 cellPadding=2 cellSpacing=2 class=outerTable
      id=TABLE1 width="100%">
 
       <TR>
       	<TD class=tblHeader height=10 width="10%">itemId</TD>
          <TD class=tblHeader height=10 width="10%">productId</TD>
          <TD class=tblHeader height=10 width="10%">CTGY ID</TD>
          <TD class=tblHeader height=10 width="15%">Item Name</TD>
          <TD class=tblHeader height=10 width="35%">itemDescription</TD>
          <TD class=tblHeader height=10 width="20%">Item Price</TD>
        </TR>
        <C:forEach var="a" items="${requestScope.itemslist}">  
        <TR>
        <TD class=tblDataText><A
            href="selecteditem.pet?categid=${a.categoryId}&prodid=${a.productId}&itemid=${a.itemId}&itemname=${a.itemName}">&nbsp;
            ${a.itemId}  </A>  </TD>
          <TD class=tblDataText><A
            href="selecteditem.pet?categid=${a.categoryId}&prodid=${a.productId}&itemid=${a.itemId}&itemname=${a.itemName}">&nbsp;
            ${a.productId}  </A>  </TD>
          <TD class=tblDataText>&nbsp; <A
            href="selecteditem.pet?categid=${a.categoryId}&prodid=${a.productId}&itemid=${a.itemId}&itemname=${a.itemName}">&nbsp;
           ${a.categoryId} </A>  </TD>
           <TD class=tblDataText>&nbsp; <A
            href="selecteditem.pet?categid=${a.categoryId}&prodid=${a.productId}&itemid=${a.itemId}&itemname=${a.itemName}">&nbsp;
           ${a.itemName} </A>  </TD>
          <TD class=tblDataText>&nbsp; ${a.itemDescription}</TD>
          <TD class=tblDataText>&nbsp; ${a.itemPrice}</TD>
		</TR>
		</C:forEach>
		</TABLE>


</body>
</html>