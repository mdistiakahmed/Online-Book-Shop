package com.isti.service;

import java.util.List;

import com.isti.model.Accounts;

public interface AccountsService {
	public void add(Accounts account);
	public void edit(Accounts account);
	public void delete(Accounts acc);
	public Accounts getAccount(String username);
	public List getAllAccount();

}
