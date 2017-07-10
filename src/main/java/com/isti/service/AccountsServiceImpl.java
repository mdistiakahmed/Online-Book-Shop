package com.isti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.isti.dao.AccountsDAO;
import com.isti.model.Accounts;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountsDAO accountDao;
	
	@Transactional
	public void add(Accounts account) {
		accountDao.add(account);

	}

	@Transactional
	public void edit(Accounts account) {
		accountDao.edit(account);
	}

	@Transactional
	public void delete(Accounts acc) {
		accountDao.delete(acc);
	}

	@Transactional
	public Accounts getAccount(String username) {
		System.out.println("AccountService --: "+username);
		return accountDao.getAccount(username);
	}

	@Transactional
	public List getAllAccount() {
		return accountDao.getAllAccount();
	}

}
