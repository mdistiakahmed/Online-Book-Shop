package com.isti.model;

public class CartLineInfo {
	private Book productInfo;
	private int quantity;
    public Book getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(Book productInfo) {
		this.productInfo = productInfo;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
        return this.productInfo.getPrice() * this.quantity;
    }
	
}
