<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<title>Login Page</title>

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
</head>

<body class="background"  text="#000000" ><!-- #BeginEditable "Page Specific Javascript" --><!-- #EndEditable -->
<form method="post" name="LOGIN">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td colspan="3" height="15"><!-- #BeginEditable "Process" -->
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="10">&nbsp;</td>
				<td></td>
				<td></td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
				<td width="10">&nbsp;</td>
				<td class=lblError></td>
				<td class=error align="right">
				<div align="right">
				<BUTTON name="BTN_CLOSE" title="Close the Current Window"
					 
            onClick="window.close()">Close</BUTTON>
				</div>
				</td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
				<td width="10">&nbsp;</td>
				<td class=error colspan="2">&nbsp;</td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
				<td width="10">&nbsp;</td>
				<td class=error colspan="2">&nbsp;</td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
				<td width="10">&nbsp;</td>
				<td class=error colspan="2" align="middle">
				<table  border="5" cellpadding="6" cellspacing="4" bgcolor="#ccffcc" class=outerTable>
              <TBODY>
				  <tr>
							<th colspan="2" align="middle">
											<b>
											<font  style="FONT-FAMILY: Bookman Old Style" color="#ff3300" >
											<br></b></FONT>
											<font       
                  style="FONT-FAMILY: Bookman Old Style" 
                  color="#0033ff">
											<b>Enter Login Information</b></font>
						 </th>
					</tr>
					</tr>
					<tr>
						<td align="middle" class=mainLabel><font      
                  style="FONT-FAMILY: Georgia; TEXT-ALIGN: center" 
                  color="#006600">USERNAME : </font></td>
						<td><input style="COLOR: #0066ff" name="username" class=txbEnabledText 
                 ></td>
					</tr>
					<tr>
						<td align="middle" class=mainLabel><font      
                  style="FONT-FAMILY: Georgia; TEXT-ALIGN: center" 
                  color="#006600">PASSWORD : </font></td>
						<td><input style="COLOR: #0066ff" type="password" name="password" class=txbEnabledText></td>
					</tr>
				</table>
				</td>
				<td width="10">&nbsp;</td>
			</tr>
			<tr>
				<td width="10">&nbsp;</td>
				<td class=error colspan="2">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
 
						<td></td>
						<td width="78">&nbsp;</td>
						<td width="10">&nbsp;</td>
						<td>
						<div align="right"></div>
						</td>
						<td width="10">&nbsp;</td>
					</tr>
				</table>
				</td>
				<td width="10">&nbsp;</td>
			</tr>
 
			<tr>
				<td width="10">&nbsp;</td>
				<td class=error colspan="2">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td align="right">
						<div align="center">
						<BUTTON name="BTN_LOGIN" title="Login"
						 onClick="LOGIN.action='validateuser.pet';LOGIN.submit();">Login</BUTTON>
						</div>
						</td>
						<td width="78">&nbsp;</td>
						<td width="10">&nbsp;</td>
						<td>
						<div align="right"></div>
						</td>
						<td width="10">&nbsp;</td>
 
					</tr>
				</table>
				</td>
				<td width="10">&nbsp;</td>
			</tr>
		</table>
		<strong> <p align="center"><br><br><br>${requestScope.invalid }</p></strong>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p>
		<p>&nbsp;</p><!-- #EndEditable --></TD></TR>
	<tr>
		<td colspan="3">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
            <td>&nbsp;
            </td>
            <td>&nbsp;
            </td>
            <td>&nbsp;
            </td>
            <td>&nbsp;
            </td>
	        <td>&nbsp;
		    </td>
				<td></td>
			</tr>
		</table>
		</td>
	</tr></TBODY></TABLE>
<table>
<tr><td>
</td></tr>
</table>
</form>
<h3 class="ss" align="right">©2012 NTTDATA All rights reserved.</h3>

</body>
</html>