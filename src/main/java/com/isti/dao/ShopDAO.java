package com.isti.dao;

import java.util.List;

import com.isti.model.Shop;

public interface ShopDAO {
	public void add(Shop sp);
	public void edit(Shop sp);
	public void delete(Shop sp);
	public Shop getAccount(String username);
	public List getAllShop();
}
