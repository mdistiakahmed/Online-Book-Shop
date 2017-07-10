package com.isti.dao;

import java.util.List;

import com.isti.model.Accounts;


public interface AccountsDAO {
	public void add(Accounts account);
	public void edit(Accounts account);
	public void delete(Accounts acc);
	public Accounts getAccount(String username);
	public List getAllAccount();

}
