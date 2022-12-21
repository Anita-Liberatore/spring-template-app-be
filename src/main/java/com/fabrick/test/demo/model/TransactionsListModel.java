package com.fabrick.test.demo.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsListModel implements Serializable{


	private static final long serialVersionUID = 797517328955108853L;
	
	@JsonProperty("list")
	List<SingleTransactionModel> transactions;


	public List<SingleTransactionModel> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<SingleTransactionModel> transactions) {
		this.transactions = transactions;
	}
}
