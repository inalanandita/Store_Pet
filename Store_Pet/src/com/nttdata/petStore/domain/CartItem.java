package com.nttdata.petStore.domain;
import com.nttdata.petStore.domain.Item;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class CartItem {
private Item Item;
private int Quantity;
public CartItem(Item item, int quantity) {
	super();
	Item = item;
	Quantity = quantity;
}
public CartItem() {
	
}
public Item getItem() {
	return Item;
}
public void setItem(Item item) {
	Item = item;
}
public int getQuantity() {
	return Quantity;
}
public void setQuantity(int quantity) {
	Quantity = quantity;
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
