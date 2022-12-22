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
class TestBalanceController {



	@Autowired
	private MockMvc mockMvc;

	//all good test
	@Test
	public void returnTransactionsJsonFromApi() throws Exception {
		this.mockMvc.perform(get("/v1/api/account/transaction/14537780?fromAccountingDate=2019-04-01&toAccountingDate=2019-09-01")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"payload\":{\"list\":[{\"transactionId\":\"428524\",\"operationId\":\"00000000428524\",\"accountingDate\":\"2019-06-28\",\"valueDate\":\"2019-07-01\",\"type\":{\"enumeration\":\"GBS_TRANSACTION_TYPE\",\"value\":\"GBS_ACCOUNT_TRANSACTION_TYPE_0050\"},\"amount\":-38.9,\"currency\":\"EUR\",\"description\":\"PD VISA CORPORATE 05\"},{\"transactionId\":\"1390057989001\",\"operationId\":\"19000095363538\",\"accountingDate\":\"2019-06-14\",\"valueDate\":\"2019-06-14\",\"type\":{\"enumeration\":\"GBS_TRANSACTION_TYPE\",\"value\":\"GBS_ACCOUNT_TRANSACTION_TYPE_0010\"},\"amount\":90.0,\"currency\":\"EUR\",\"description\":\"BD LUCA TERRIBILE        DA 03268.44430         DATA ORDINE 14062019 RIMBORSO VISA\"},{\"transactionId\":\"314569\",\"operationId\":\"00000000314569\",\"accountingDate\":\"2019-05-31\",\"valueDate\":\"2019-06-01\",\"type\":{\"enumeration\":\"GBS_TRANSACTION_TYPE\",\"value\":\"GBS_ACCOUNT_TRANSACTION_TYPE_0050\"},\"amount\":-28.4,\"currency\":\"EUR\",\"description\":\"PD VISA CORPORATE 04\"},{\"transactionId\":\"038917\",\"operationId\":\"00000000038917\",\"accountingDate\":\"2019-04-30\",\"valueDate\":\"2019-05-01\",\"type\":{\"enumeration\":\"GBS_TRANSACTION_TYPE\",\"value\":\"GBS_ACCOUNT_TRANSACTION_TYPE_0050\"},\"amount\":-62.4,\"currency\":\"EUR\",\"description\":\"PD VISA CORPORATE 03\"}]}}")));
	
	}
	
	//with wrong accountid - expeted 500 for missing params
	@Test
	public void returnErrorBalanceFromApi() throws Exception {
		this.mockMvc.perform(get("/v1/api/account/transaction/14537780?toAccountingDate=2019-09-01")).andDo(print()).andExpect(status().is5xxServerError());
	
	}

}
