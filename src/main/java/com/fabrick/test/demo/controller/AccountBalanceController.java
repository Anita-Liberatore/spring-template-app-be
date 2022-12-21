package com.fabrick.test.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.test.demo.constants.FabrickApiUri;
import com.fabrick.test.demo.model.BalanceModel;
import com.fabrick.test.demo.service.BalanceService;

@RestController
@RequestMapping(FabrickApiUri.MAPPING_URI_BALANCE)
public class AccountBalanceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountBalanceController.class);
	
	//call it dependency injection :D
	@Autowired
	private BalanceService balanceService;
	

	@GetMapping("{accountId}")
	public ResponseEntity<BalanceModel> getBalanceByAccountId(@PathVariable("accountId") long accountId) {
		LOGGER.info("Balance: Balance API Controller with accountId {}", accountId);
		BalanceModel balance = balanceService.getBalanceByAccount(accountId);	
		LOGGER.info("Balance: Balance API Controller with balance response {}", balance);
		return new ResponseEntity<BalanceModel>(balance, HttpStatus.OK);
	}


}
