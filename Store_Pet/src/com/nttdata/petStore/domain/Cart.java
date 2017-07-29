package com.nttdata.petStore.domain;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Cart {
private int orderId;
private String custId;
private int itemid;
private int productid;
private int categoryid;
private int quantity;

public int getItemid() {
	return itemid;
}

public void setItemid(int itemid) {
	this.itemid = itemid;
}

public int getProductid() {
	return productid;
}

public void setProductid(int productid) {
	this.productid = productid;
}

public int getCategoryid() {
	return categoryid;
}

public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Cart(int orderId, String custId, int itemid, int productid,
		int categoryid, int quantity) {
	super();
	this.orderId = orderId;
	this.custId = custId;
	this.itemid = itemid;
	this.productid = productid;
	this.categoryid = categoryid;
	this.quantity = quantity;
}
private static List<CartItem> itemDetails;

public Cart(int orderId, String custId) {
	
	this.orderId = orderId;
	this.custId = custId;
}

public Cart() {
	// TODO Auto-generated constructor stub
}

public Cart(int i, int j) {
	// TODO Auto-generated constructor stub
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public String getCustId() {
	return custId;
}

public void setCustId(String custId) {
	this.custId = custId;
}

public static List<CartItem> getItemDetails() {
	return itemDetails;
}

public static void setItemDetails(List<CartItem> itemDetails) {
	Cart.itemDetails = itemDetails;
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
public static CartItem addCartItem(Item obj,int qty)
{
	obj.getItemId();
	obj.getProductId();
	obj.getCategoryId();
	CartItem ctm = new CartItem();
	ctm.setItem(obj);
	ctm.setQuantity(qty);
	itemDetails=new ArrayList<CartItem>();
	itemDetails.add(ctm);
	return ctm;

}
}
