package com.journaldev.spring.model;

public class PwdForm {
	private String password;

	public PwdForm() {
		super();
	}

	public PwdForm(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
