package com.nttdata.petStore.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Product {
private int productId;
private int categoryId;
private String productName;
private String productDescription;
public Product(int productId, int categoryId, String productName,
		String productDescription) {
	super();
	this.productId = productId;
	this.categoryId = categoryId;
	this.productName = productName;
	this.productDescription = productDescription;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
@Override
public String toString() {
	
	return ToStringBuilder.reflectionToString(this);
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
