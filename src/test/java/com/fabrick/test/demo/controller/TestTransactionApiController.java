package com.fabrick.test.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.fabrick.test.demo.model.TransanctionPayloadModel;
import com.fabrick.test.demo.util.HttpHeadersUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class TestTransactionApiController {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper mapper;

	RestTemplate restTemplate;

	@Autowired
	TestTransactionApiController(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	@Test
	public void returnTransactionsJsonFromApi() throws Exception {

		// create headers
		HttpHeaders headers = HttpHeadersUtil.getHeaders();

		String url = FabrickApiUri.URL_TRANSACTION_ACCOUNT;

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<TransanctionPayloadModel> response = restTemplate.exchange(
				url, HttpMethod.GET, requestEntity, TransanctionPayloadModel.class, "14537780", "2022-04-01", "2022-09-01");


		TransanctionPayloadModel result = response.getBody();
		String jsonResult = mapper.writeValueAsString(result);

		this.mockMvc.perform(get("/v1/api/account/transaction/14537780?fromAccountingDate=2022-04-01&toAccountingDate=2022-09-01")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString(jsonResult)));

	}

	//with wrong accountid - expeted 500 for missing params
	@Test
	public void returnErrorBalanceFromApi() throws Exception {
		this.mockMvc.perform(get("/v1/api/account/transaction/14537780?toAccountingDate=2019-09-01")).andDo(print()).andExpect(status().is5xxServerError());

	}

}
