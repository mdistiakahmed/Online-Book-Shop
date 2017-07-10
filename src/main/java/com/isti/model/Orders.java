package com.isti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orders {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderid;
	@Column
	private int shopid;
	@Column
	private int bookid;
	@Column
	private String username;
	
	public Orders(){}
	
	public Orders(int oid,int sid,int bid,String uname){
		orderid=oid;
		shopid=sid;
		bookid=bid;
		username=uname;
	}
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
