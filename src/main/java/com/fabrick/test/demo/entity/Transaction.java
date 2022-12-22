package com.fabrick.test.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="transaction_id", nullable = false)
	private String transactionId;
	
	@Column(name="operation_id", nullable = false)
	private String operationId;
	
	@Column(name="accounting_date", nullable = false)
	private String accountingDate;
	
	@Column(name="value_date", nullable = false)
	private String valueDate;
	
	@Column(name="amount", nullable = false)
	private Double amount;
	
	@Column(name="currency", nullable = false)
	private String currency;
	
	@Column(name="description", nullable = false)
	private String description;
	
	@Column(name="type_enumeration", nullable = false)
	private String typeEnumeration;
	
	@Column(name="type_value", nullable = false)
	private String typeValue;
	
	@Column(name="account_id", nullable = false)
	private String accountId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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

	public String getTypeEnumeration() {
		return typeEnumeration;
	}

	public void setTypeEnumeration(String typeEnumeration) {
		this.typeEnumeration = typeEnumeration;
	}

	public String getTypeValue() {
		return typeValue;
	}

	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionId=" + transactionId + ", operationId=" + operationId
				+ ", accountingDate=" + accountingDate + ", valueDate=" + valueDate + ", amount=" + amount
				+ ", currency=" + currency + ", description=" + description + ", typeEnumeration=" + typeEnumeration
				+ ", typeValue=" + typeValue + ", accountId=" + accountId + "]";
	}

	
}
