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
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class TestTransactionController {

	@Autowired
	private MockMvc mockMvc;

	//all good test
	@Test
	public void returnBalanceFromApi() throws Exception {
		this.mockMvc.perform(get("/v1/api/account/balance/14537780"))
					.andDo(print())
					.andExpect(status().isOk())
				    .andExpect(content().string(containsString("{\"balance\":706.66,\"availableBalance\":706.66}")));
	
	}
	
	//with wrong accountid - expeted 500
	@Test
	public void returnErrorBalanceFromApi() throws Exception {
		this.mockMvc.perform(get("/v1/api/account/balance/145377805")).andDo(print()).andExpect(status().is5xxServerError());
	
	}
}
