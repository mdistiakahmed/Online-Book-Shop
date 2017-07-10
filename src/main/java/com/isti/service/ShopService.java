package com.isti.service;

import java.util.List;

import com.isti.model.Shop;

public interface ShopService {
	public void add(Shop sp);
	public void edit(Shop sp);
	public void delete(Shop sp);
	public Shop getAccount(String username);
	public List getAllShop();
}
