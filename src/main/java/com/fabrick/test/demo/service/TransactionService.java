package com.fabrick.test.demo.service;

import com.fabrick.test.demo.model.TransanctionPayloadModel;

public interface TransactionService {

	TransanctionPayloadModel getAllTransactionsByAccountId(long accountId, String fromAccountingDate, String toAccountingDate);
	
	void saveTransaction(TransanctionPayloadModel transaction, long accountId);
	

}
