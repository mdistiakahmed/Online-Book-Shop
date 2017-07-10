package com.isti.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.isti.model.Accounts;
import com.isti.model.Book;


@Repository
public class AccountsDAOImpl implements AccountsDAO {

	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Accounts account) {
		session.getCurrentSession().save(account);

	}

	@Override
	public void edit(Accounts account) {
		session.getCurrentSession().update(account);
		 this.session.getCurrentSession().flush();
	}

	@Override
	public void delete(Accounts acc) {
		session.getCurrentSession().delete(acc);


	}

	@Override
	public Accounts getAccount(String username) {
		System.out.println("AccountDAO : "+username);
		Accounts acc= null;
		acc=(Accounts)session.getCurrentSession().get(Accounts.class,username);
		if(acc==null)System.out.println("AccountDAO : acc is null");
		return acc;
	}

	@Override
	public List getAllAccount() {
		return session.getCurrentSession().createQuery("from Accounts").list();
	}

}
