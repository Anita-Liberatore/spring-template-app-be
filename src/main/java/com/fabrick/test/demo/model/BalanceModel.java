package com.fabrick.test.demo.model;

import java.io.Serializable;

public class BalanceModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4855617940918526040L;
	
	private Double balance;
	private Double availableBalance;
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	@Override
	public String toString() {
		return "Balance [balance=" + balance + ", availableBalance=" + availableBalance + "]";
	}
	
	
	
	
}
