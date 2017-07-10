package com.isti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shop {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int shopid;
	@Column
	private String managername;
	
	public Shop(){}
	
	public Shop(int id,String mname)
	{
		super();
		this.shopid = id;
		this.managername= mname;
	}
	
	
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
}
