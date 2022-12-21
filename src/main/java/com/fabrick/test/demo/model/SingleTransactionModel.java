package com.fabrick.test.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleTransactionModel implements Serializable{

	private static final long serialVersionUID = -5238235257002279497L;
	
	@JsonProperty("transactionId")
	private String transactionId;
	
	@JsonProperty("operationId")
	private String operationId;
	
	@JsonProperty("accountingDate")
	private String accountingDate;
	
	@JsonProperty("valueDate")
	private String valueDate;
	
	@JsonProperty("type")
	private TypeModel type;
	
	@JsonProperty("amount")
	private double amount;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("description")
	private String description;
	
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getOperationId() {
		return operationId;
	}
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	public String getAccountingDate() {
		return accountingDate;
	}
	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	public String getValueDate() {
		return valueDate;
	}
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	public TypeModel getType() {
		return type;
	}
	public void setType(TypeModel type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SingleTransactionModel [transactionId=" + transactionId + ", operationId=" + operationId
				+ ", accountingDate=" + accountingDate + ", valueDate=" + valueDate + ", type=" + type + ", amount="
				+ amount + ", currency=" + currency + ", description=" + description + "]";
	}

}
