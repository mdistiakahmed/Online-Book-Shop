package com.isti.service;

import java.util.List;

import com.isti.model.Orders;

public interface OrderService {
	public void add(Orders od);
	public void edit(Orders od);
	public void delete(Orders od);
	public Orders getOrder(int code);
	public List getAllOrder();
}
