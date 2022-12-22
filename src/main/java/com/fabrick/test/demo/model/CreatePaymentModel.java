package com.fabrick.test.demo.model;

public class CreatePaymentModel {

	private double amount;
	private TaxReliefModel taxRelief;
	private String feeAccountId;
	private String executionDate;
	private String description;
	private CreditorModel creditor;
	private String currency;
	private String uri;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public TaxReliefModel getTaxRelief() {
		return taxRelief;
	}
	public void setTaxRelief(TaxReliefModel taxRelief) {
		this.taxRelief = taxRelief;
	}
	public String getFeeAccountId() {
		return feeAccountId;
	}
	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}
	public String getExecutionDate() {
		return executionDate;
	}
	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public CreditorModel getCreditor() {
		return creditor;
	}
	public void setCreditor(CreditorModel creditor) {
		this.creditor = creditor;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	@Override
	public String toString() {
		return "CreatePaymentModel [amount=" + amount + ", taxRelief=" + taxRelief + ", feeAccountId=" + feeAccountId
				+ ", executionDate=" + executionDate + ", description=" + description + ", creditor=" + creditor
				+ ", currency=" + currency + ", uri=" + uri + "]";
	}
	
	
}
