package com.fabrick.test.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.test.demo.constants.FabrickApiUri;
import com.fabrick.test.demo.enumtype.DirectionEnum;
import com.fabrick.test.demo.enumtype.StatusEnum;
import com.fabrick.test.demo.model.CreatePaymentModel;
import com.fabrick.test.demo.model.PaymentDoneModel;
import com.fabrick.test.demo.service.CreatePaymentService;

@RestController
@RequestMapping(FabrickApiUri.MAPPING_URI_PAYMENT)
public class AccountPaymentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountPaymentController.class);

	@Autowired
	CreatePaymentService createPaymentService;
	
	@PostMapping("{accountId}")
	ResponseEntity<?> createPayment(@PathVariable("accountId") long accountId, @RequestBody CreatePaymentModel request) {
		
		LOGGER.info("AccountPaymentController with accountId {}, request {}", accountId, request);

		createPaymentService.createPayment(accountId, request);
		
		LOGGER.info("AccountPaymentController after createPaymentService call");

		return new ResponseEntity<>(new PaymentDoneModel(StatusEnum.EXECUTED, DirectionEnum.OUTGOING), HttpStatus.CREATED);
	}


}
