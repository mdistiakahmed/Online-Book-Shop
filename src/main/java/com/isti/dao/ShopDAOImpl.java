package com.isti.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isti.model.Accounts;
import com.isti.model.Book;
import com.isti.model.Shop;


@Repository
public class ShopDAOImpl  implements ShopDAO{
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Shop sp) {
		System.out.println("dao here");
		session.getCurrentSession().save(sp);

	}

	@Override
	public void edit(Shop sp) {
		session.getCurrentSession().update(sp);
		 this.session.getCurrentSession().flush();
	}

	@Override
	public void delete(Shop sp) {
		session.getCurrentSession().delete(sp);


	}

	@Override
	public Shop getAccount(String username) {
		Shop sp= null;
		String hql="from Shop where managername= :mname";
        Query query = session.getCurrentSession().createQuery(hql);
        query.setParameter("mname", username);
        return (Shop) query.uniqueResult();
		//return sp;
	}

	@Override
	public List getAllShop() {
		return session.getCurrentSession().createQuery("from Shop").list();
	}
	
}
