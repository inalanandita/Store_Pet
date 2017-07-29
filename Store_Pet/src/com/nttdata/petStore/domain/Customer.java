package com.nttdata.petStore.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Customer {
private String custId;
private String password;
private String firstName;
private String lastName;
private Date dateOfBirth;
private String address;
private int contactNumber;
private int creditCardNo;
private String cardType;
private Date cardExpiryDate;

public Customer(String custId,String password)
{
	this.custId=custId;
	this.password=password;
}
public Customer(String custId, String password, String firstName,
		String lastName, Date dateOfBirth, String address, int contactNumber,
		int creditCardNo, String cardType, Date cardExpiryDate) {
	
	this.custId = custId;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.dateOfBirth = dateOfBirth;
	this.address = address;
	this.contactNumber = contactNumber;
	this.creditCardNo = creditCardNo;
	this.cardType = cardType;
	this.cardExpiryDate = cardExpiryDate;
}
public Customer(String custid2) {
	this.custId=custid2;
}
public Customer(String password2, String firstName2, String lastName2,
		java.sql.Date dob, String address2, int contactNo, int creditCardNo2,
		String cardType2, java.sql.Date expiryDt) {
	this.password = password2;
	this.firstName = firstName2;
	this.lastName = lastName2;
	this.dateOfBirth = dob;
	this.address = address2;
	this.contactNumber = contactNo;
	this.creditCardNo = creditCardNo2;
	this.cardType = cardType2;
	this.cardExpiryDate = expiryDt;
	
}
public String getCustId() {
	return custId;
}
public void setCustId(String custId) {
	this.custId = custId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Date getDateOfBirth() {
	return dateOfBirth;
}
public void setDateOfBirth(Date dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getContactNumber() {
	return contactNumber;
}
public void setContactNumber(int contactNumber) {
	this.contactNumber = contactNumber;
}
public int getCreditCardNo() {
	return creditCardNo;
}
public void setCreditCardNo(int creditCardNo) {
	this.creditCardNo = creditCardNo;
}
public String getCardType() {
	return cardType;
}
public void setCardType(String cardType) {
	this.cardType = cardType;
}
public Date getCardExpiryDate() {
	return cardExpiryDate;
}
public void setCardExpiryDate(Date cardExpiryDate) {
	this.cardExpiryDate = cardExpiryDate;
}

@Override
	public int hashCode() {
		
		return HashCodeBuilder.reflectionHashCode(this);
		}
@Override
	public boolean equals(Object obj) {
		
		return EqualsBuilder.reflectionEquals(this,obj);
	}
}
