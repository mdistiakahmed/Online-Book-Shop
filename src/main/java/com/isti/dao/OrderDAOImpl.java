package com.isti.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isti.model.Accounts;
import com.isti.model.Orders;


@Repository
public class OrderDAOImpl implements OrderDAO{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Orders od) {
		session.getCurrentSession().save(od);

	}

	@Override
	public void edit(Orders od) {
		session.getCurrentSession().update(od);
		 this.session.getCurrentSession().flush();
	}


	@Override
	public void delete(Orders od) {
		session.getCurrentSession().delete(od);


	}

	@Override
	public Orders getOrder(int code) {
		Orders od= null;
		od=(Orders)session.getCurrentSession().get(Orders.class,code);
		if(od==null)System.out.println("AccountDAO : acc is null");
		return od;
	}


	@Override
	public List getAllOrder() {
		return session.getCurrentSession().createQuery("from Orders").list();
	}

}
