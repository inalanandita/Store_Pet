<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="Stylesheet.css" rel="stylesheet" type="text/css" />
<title>Registration</title>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="right">&nbsp;</td>
		<!-- #BeginEditable "page title" -->
		<td class="lblTitle">
		<div id='DIVPageTitle'><b>HOME</b></div>
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
</table>
<script language="JavaScript" type="text/javascript">
function validate()
{
var first=document.getElementById("first").value;
var last=document.getElementById("last").value;
var pass=document.getElementById("pass").value;
var phno=document.getElementById("cont").value;
var credit=document.getElementById("creditno").value;
var date=document.getElementById("dob").value;
var addr=document.getElementById("addr").value;
var expr=document.getElementById("expiry").value;


if(first=="" && last=="" && phno=="" && credit=="" && pass=="" && date=="" && addr=="" && expr=="" )
{alert("Enter all fields");return false;}

if(first=="" || !isNaN(first))
{alert("Enter firstname");return false;}

if(last=="" || !isNaN(last))
{alert("Enter lastname");return false;}

if(pass=="")
{alert("Enter the password");return false;}

if(date=="")
{alert("Enter the date");return false;}

if(addr=="")
{alert("Enter the address");return false;}

if(expr=="")
{alert("Enter the expiry date");return false;}

if( phno=="" || isNaN(phno) )
{alert("Enter 10 digit phone number");return false;}

if(credit=="" || isNaN(credit))
{alert("Enter credit card number");return false;}



}
</script>
</head>
<body bgcolor="#DCDCDC">
<p align="center">Enter your Details</p>
<form method="post" action="registernewuser.pet"
	onsubmit="return validate();">
<table align="center" >
	<tr>
		<td>Enter your First Name:</td>
		<td><input type="text" name="first" maxlength="30"></td>
	</tr>
	<tr>
		<td>Enter your Last Name:</td>
		<td><input type="text" name="last" maxlength="30"></td>
	</tr>
	<tr>
		<td>Enter the password:</td>
		<td><input type="password" name="pass" maxlength="10"></td>
	</tr>
	<tr>
		<td>Enter your Date of Birth(YYYY-MM-DD):</td>
		<td><input type="text" name="dob"></td>
	</tr>
	<tr>
		<td>Enter your Address :</td>
		<td><textarea rows="3" name="addr" cols=""></textarea></td>
	</tr>
	<tr>
		<td>Enter your contact number:</td>
		<td><input type="text" name="cont" maxlength="10"></td>
	</tr>
	<tr>
		<td>Enter your credit card number:</td>
		<td><input type="text" name="creditno" maxlength="16"></td>
	</tr>
	<tr>
		<td>Enter your credit card type:</td>
		<td><input type="radio" name="cardtype" value="Master" >Master<input
			type="radio" name="cardtype" value="Visa" checked="checked">Visa<input
			type="radio" name="cardtype" value="Maestro">Maestro</td>
	</tr>
	<tr>
		<td>Enter the card's Expiry date(YYYY-MM-DD):</td>
		<td><input type="text" name="expiry"></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="SUBMIT" value="Submit"></td>
	</tr>
</table>

</form>
<br><br><br><br><br><br><br><br>
<h3 class="ss" align="right">©2012 NTTDATA All rights reserved.</h3>
</body>


</html>