package com.nttdata.petStore.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Item {
private int itemId;
private int productId;
private int categoryId;
private String itemName;
private String itemDescription;
private int itemPrice;
public Item(int itemId, int productId, int categoryId, String itemName,
		String itemDescription, int itemPrice) {
	super();
	this.itemId = itemId;
	this.productId = productId;
	this.categoryId = categoryId;
	this.itemName = itemName;
	this.itemDescription = itemDescription;
	this.itemPrice = itemPrice;
}
public Item(int itemId2, int prodId, int categId) {
	this.itemId = itemId2;
	this.productId = prodId;
	this.categoryId = categId;
}
public Item() {
	// TODO Auto-generated constructor stub
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
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
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getItemDescription() {
	return itemDescription;
}
public void setItemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
}
public int getItemPrice() {
	return itemPrice;
}
public void setItemPrice(int itemPrice) {
	this.itemPrice = itemPrice;
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
