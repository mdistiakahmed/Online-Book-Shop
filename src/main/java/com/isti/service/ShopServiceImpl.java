package com.isti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isti.dao.ShopDAO;
import com.isti.model.Shop;


@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	private ShopDAO shopDao;
	
	@Transactional
	public void add(Shop sp) {
		shopDao.add(sp);

	}

	@Transactional
	public void edit(Shop sp) {
		shopDao.edit(sp);
	}

	@Transactional
	public void delete(Shop sp) {
		shopDao.delete(sp);
	}

	@Transactional
	public Shop getAccount(String username) {
		System.out.println("AccountService --: "+username);
		return shopDao.getAccount(username);
	}

	@Transactional
	public List getAllShop() {
		return shopDao.getAllShop();
	}

}
