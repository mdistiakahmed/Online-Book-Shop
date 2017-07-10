package com.isti.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {
	
	 private int orderNum;
	 private Book book;
	 private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();
	 
	 public CartInfo() {
		 
	 }
	 
	 public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	 public List<CartLineInfo> getCartLines() {
	        return this.cartLines;
	    }
	
	private CartLineInfo findLineByCode(int code) {
        for (CartLineInfo line : this.cartLines) {
            if (line.getProductInfo().getBookId()==code) {
                return line;
            }
        }
        return null;
    }
	
	public void addProduct(Book bookInfo, int quantity) {
        CartLineInfo line = this.findLineByCode(bookInfo.getBookId());
 
        if (line == null) {
            line = new CartLineInfo();
            line.setQuantity(0);
            line.setProductInfo(bookInfo);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }
	
	public void removeProduct(Book productInfo) {
        CartLineInfo line = this.findLineByCode(productInfo.getBookId());
        if (line != null) {
            this.cartLines.remove(line);
        }
    }

	

}
