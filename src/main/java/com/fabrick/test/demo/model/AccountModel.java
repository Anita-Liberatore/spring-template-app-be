package com.fabrick.test.demo.model;

public class AccountModel {

	private String accountCode;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	@Override
	public String toString() {
		return "AccountModel [accountCode=" + accountCode + "]";
	}
	
	
}
