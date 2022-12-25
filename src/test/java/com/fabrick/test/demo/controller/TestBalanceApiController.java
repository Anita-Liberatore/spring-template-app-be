package com.fabrick.test.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.fabrick.test.demo.constants.FabrickApiUri;
import com.fabrick.test.demo.constants.FabrickConstants;
import com.fabrick.test.demo.model.BalanceModel;
import com.fabrick.test.demo.util.HttpHeadersUtil;
import com.fasterxml.jackson.databind.JsonNode;



@SpringBootTest
@AutoConfigureMockMvc
class TestBalanceApiController {

	@Autowired
	private MockMvc mockMvc;

	RestTemplate restTemplate;

	@Autowired
	TestBalanceApiController(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}
	
	@Autowired
	AccountBalanceController balanceController;

	@Test
	public void testBalanceApi() throws Exception {
		//response from api

		HttpHeaders headers = HttpHeadersUtil.getHeaders();

		//url api fabrick
		String url = FabrickApiUri.URL_BALANCE_ACCOUNT;

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		BalanceModel balance = new BalanceModel();

		ResponseEntity<JsonNode> response = restTemplate.exchange(
				url, HttpMethod.GET, requestEntity, JsonNode.class, "14537780");


		//using json node for get balance value and available value
		JsonNode map = response.getBody();
		Double availableBalance = map.get(FabrickConstants.PAYLOAD_NODE).get(FabrickConstants.BALANCE_NODE).asDouble();
		Double balanceValue = map.get(FabrickConstants.PAYLOAD_NODE).get(FabrickConstants.AVAILABLE_BALANCE_NODE).asDouble();

		//create BalanceModel for setting balance value and available value
		balance.setBalance(balanceValue);
		balance.setAvailableBalance(availableBalance);
				
		String jsonStringResponse = new JSONObject()
                .put("balance", balance.getBalance())
                .put("availableBalance", balance.getAvailableBalance())
                .toString();


		this.mockMvc.perform(get("/v1/api/account/balance/14537780"))
		.andDo(print())
		.andExpect(status().isOk()).andExpect(content().string(containsString(jsonStringResponse)));
		
		

	}

	//with wrong accountid - expeted 500
	@Test
	public void returnErrorBalanceFromApi() throws Exception {
		this.mockMvc.perform(get("/v1/api/account/balance/145377805")).andDo(print()).andExpect(status().is5xxServerError());

	}
}
