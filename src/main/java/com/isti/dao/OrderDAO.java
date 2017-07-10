package com.isti.dao;

import java.util.List;

import com.isti.model.Orders;

public interface OrderDAO {
	public void add(Orders od);
	public void edit(Orders od);
	public void delete(Orders od);
	public Orders getOrder(int code);
	public List getAllOrder();

}
