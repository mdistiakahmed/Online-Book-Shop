package com.isti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isti.dao.OrderDAO;
import com.isti.model.Orders;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderDAO orderDao;
	
	@Transactional
	public void add(Orders od) {
		orderDao.add(od);

	}

	@Transactional
	public void edit(Orders od) {
		orderDao.edit(od);
	}

	@Transactional
	public void delete(Orders od) {
		orderDao.delete(od);
	}

	@Transactional
	public Orders getOrder(int code) {
		return orderDao.getOrder(code);
	}
	

	

	@Transactional
	public List getAllOrder() {
		return orderDao.getAllOrder();
	}


}
