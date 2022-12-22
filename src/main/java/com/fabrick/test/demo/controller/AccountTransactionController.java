package com.fabrick.test.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.test.demo.constants.FabrickApiUri;
import com.fabrick.test.demo.model.TransanctionPayloadModel;
import com.fabrick.test.demo.service.TransactionService;

@RestController
@RequestMapping(FabrickApiUri.MAPPING_URI_TRANSACTION)
public class AccountTransactionController {

private static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionController.class);
	
	//call it dependency injection :D
	@Autowired
	private TransactionService transactionService;
	

	@GetMapping("{accountId}")
	public ResponseEntity<TransanctionPayloadModel> getBalanceByAccountId(@PathVariable("accountId") long accountId, @RequestParam String fromAccountingDate, @RequestParam String toAccountingDate) {
		LOGGER.info("AccountTransactionController with accountId {}, fromAccountingDate {}, toAccountingDate {}", accountId, fromAccountingDate, toAccountingDate);
		
		//get list transactions with rest template
		TransanctionPayloadModel listTransactions = transactionService.getAllTransactionsByAccountId(accountId, fromAccountingDate, toAccountingDate);	
		
		//save transaction into DB
		if(listTransactions!=null) {
			transactionService.saveTransaction(listTransactions, accountId);
		}
		
		LOGGER.info("AccountTransactionController response {}", listTransactions);
		return new ResponseEntity<TransanctionPayloadModel>(listTransactions, HttpStatus.OK);
	}
}
