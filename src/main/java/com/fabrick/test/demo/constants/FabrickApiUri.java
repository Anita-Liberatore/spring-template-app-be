package com.fabrick.test.demo.constants;

public class FabrickApiUri {

	public static final String MAPPING_URI_BALANCE = "/v1/api/account/balance";
	public static final String MAPPING_URI_PING_TEST = "/v1/api/ping";
	public static final String MAPPING_URI_TRANSACTION = "/v1/api/account/transaction";
	public static final String MAPPING_URI_PAYMENT = "/v1/api/account/payment";
	
	public static final String URL_BALANCE_ACCOUNT = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/balance";
	public static final String URL_TRANSACTION_ACCOUNT = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/transactions?fromAccountingDate={fromAccountingDate}&toAccountingDate={toAccountingDate}";
	public static final String URL_CREATE_PAYMENT = "https://sandbox.platfr.io/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";

	
}
