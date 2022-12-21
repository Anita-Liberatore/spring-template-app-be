package com.fabrick.test.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fabrick.test.demo.constants.FabrickApiUri;
import com.fabrick.test.demo.constants.FabrickConstants;
import com.fabrick.test.demo.model.BalanceModel;
import com.fabrick.test.demo.service.BalanceService;
import com.fabrick.test.demo.util.HttpHeadersUtil;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class BalanceServiceImpl implements BalanceService {
	
	//logging
	private static final Logger LOGGER = LoggerFactory.getLogger(BalanceServiceImpl.class);

	//rest template for consuming api
	RestTemplate restTemplate;

	//call it dependency injection :D using constructor way oh yeah
	@Autowired
	BalanceServiceImpl(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	@Override
	public BalanceModel getBalanceByAccount(long accountId) {
		
		LOGGER.info("Balance: Balance Service with accountId {}", accountId);
		// create headers
		HttpHeaders headers = HttpHeadersUtil.getHeaders();

		//url api fabrick
		String url = FabrickApiUri.URL_BALANCE_ACCOUNT;

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		//using json node for get balance value and available value
		ResponseEntity<JsonNode> response = restTemplate.exchange(
				url, HttpMethod.GET, requestEntity, JsonNode.class, accountId);

		LOGGER.info("Balance Service, response: {}", response);

		//using json node for get balance value and available value
		JsonNode map = response.getBody();
		Double availableBalance = map.get(FabrickConstants.PAYLOAD_NODE).get(FabrickConstants.BALANCE_NODE).asDouble();
		Double balanceValue = map.get(FabrickConstants.PAYLOAD_NODE).get(FabrickConstants.AVAILABLE_BALANCE_NODE).asDouble();
	
		//create BalanceModel for setting balance value and available value
		BalanceModel balance = new BalanceModel();
	    balance.setBalance(balanceValue);
	    balance.setAvailableBalance(availableBalance);
		LOGGER.info(" Balance Service, balance: {}", balance);
	    return balance;
	}

}
