package com.isti.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Accounts {
	@Id
	@Column
	private String UserName;
	@Column
	private String Password;
	@Column
	private String Role;
	
	public Accounts(){}
	
	public Accounts(String userName, String password, String role) {
		super();
		UserName = userName;
		Password = password;
		Role = role;
	}
	
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	


}
