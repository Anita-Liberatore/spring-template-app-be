package com.fabrick.test.demo.service.impl;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fabrick.test.demo.constants.FabrickApiUri;
import com.fabrick.test.demo.model.CreatePaymentModel;
import com.fabrick.test.demo.service.CreatePaymentService;
import com.fabrick.test.demo.util.HttpHeadersUtil;

@Service
public class CreatePaymentServiceImpl implements CreatePaymentService{

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);


	RestTemplate restTemplate;

	@Autowired
	CreatePaymentServiceImpl(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}

	@Override
	public void createPayment(long accountId, CreatePaymentModel createPaymentModel) {
		LOGGER.info("createPayment service START {}",createPaymentModel );

		// create headers
		HttpHeaders headers = HttpHeadersUtil.getHeaders();

		String url = FabrickApiUri.URL_CREATE_PAYMENT;
		
		JSONObject paymentJsonObject = new JSONObject();
		JSONObject creditorJsonObject = new JSONObject();
		creditorJsonObject.put("name", createPaymentModel.getCreditor().getName());
		JSONObject accountJsonObject = new JSONObject();
		accountJsonObject.put("accountCode", createPaymentModel.getCreditor().getAccount().getAccountCode());
		creditorJsonObject.put("account", accountJsonObject);
		

		JSONObject taxReliefJsonObject = new JSONObject();
		taxReliefJsonObject.put("taxReliefId", createPaymentModel.getTaxRelief().getTaxReliefId());
		taxReliefJsonObject.put("isCondoUpgrade", createPaymentModel.getTaxRelief().isCondoUpgrade());
		taxReliefJsonObject.put("creditorFiscalCode", createPaymentModel.getTaxRelief().getCreditorFiscalCode());
		taxReliefJsonObject.put("beneficiaryType", createPaymentModel.getTaxRelief().getBeneficiaryType());
		
		
		JSONObject naturalPersonBeneficiaryJsonObject = new JSONObject();
		naturalPersonBeneficiaryJsonObject.put("fiscalCode1", createPaymentModel.getTaxRelief().getNaturalPersonBeneficiary().getFiscalCode1());

		taxReliefJsonObject.put("naturalPersonBeneficiary", naturalPersonBeneficiaryJsonObject);
		paymentJsonObject.put("creditor", creditorJsonObject);
		paymentJsonObject.put("executionDate", "2019-04-01");
		paymentJsonObject.put("uri", "REMITTANCE_INFORMATION");
		paymentJsonObject.put("description", "Payment invoice 75/2017");
		paymentJsonObject.put("amount", 800);
		paymentJsonObject.put("currency", "EUR");
		paymentJsonObject.put("feeAccountId", "45685475");
		paymentJsonObject.put("taxRelief", taxReliefJsonObject);

		LOGGER.info("request {}", paymentJsonObject.toString());

		HttpEntity<String> response = 
				new HttpEntity<String>(paymentJsonObject.toString(), headers);

		LOGGER.info("response for Create Payment Service {}", response);

		restTemplate.postForObject(url, response, String.class, accountId);
		

	}

}
