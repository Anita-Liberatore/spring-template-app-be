 package com.fabrick.test.demo.service.impl;

import java.util.List;

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
import com.fabrick.test.demo.entity.Transaction;
import com.fabrick.test.demo.model.SingleTransactionModel;
import com.fabrick.test.demo.model.TransanctionPayloadModel;
import com.fabrick.test.demo.repository.TransactionRepository;
import com.fabrick.test.demo.service.TransactionService;
import com.fabrick.test.demo.util.HttpHeadersUtil;

@Service
public class TransactionServiceImpl implements TransactionService{

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

	RestTemplate restTemplate;

	@Autowired
	TransactionServiceImpl(RestTemplateBuilder builder) {
		restTemplate = builder.build();
	}
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public TransanctionPayloadModel getAllTransactionsByAccountId(long accountId, String fromAccountingDate, String toAccountingDate) {
		LOGGER.info("Balance: Balance Service with accountId {}", accountId);
		
		// create headers
		HttpHeaders headers = HttpHeadersUtil.getHeaders();

		String url = FabrickApiUri.URL_TRANSACTION_ACCOUNT;

		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

		ResponseEntity<TransanctionPayloadModel> response = restTemplate.exchange(
				url, HttpMethod.GET, requestEntity, TransanctionPayloadModel.class, accountId, fromAccountingDate, toAccountingDate);

		LOGGER.info("Balance Service, response: {}", response);
	
		TransanctionPayloadModel result = response.getBody();
		return result;

		
	
	}

	@Override
	public void saveTransaction(TransanctionPayloadModel transactionPayload) {
		
		LOGGER.info("Balance Service - saveTransaction, transactionPayload: {}", transactionPayload.getPayload());

		List<SingleTransactionModel> listTransactions = transactionPayload.getPayload().getTransactions();
		
		
		for (SingleTransactionModel singleTransactionModel : listTransactions) {
			LOGGER.info("singleTransactionModel: {}", singleTransactionModel);

			Transaction transactionExist = transactionRepository.findTransactionByOperationId(singleTransactionModel.getOperationId());
			LOGGER.info("transactionExist is present: {}", transactionExist);

			if(transactionExist==null) {
				LOGGER.info("operation SAVE for transaction");
				Transaction transaction = new Transaction();
				transaction.setAccountingDate(singleTransactionModel.getAccountingDate());
				transaction.setAmount(singleTransactionModel.getAmount());
				transaction.setCurrency(singleTransactionModel.getCurrency());
				transaction.setDescription(singleTransactionModel.getDescription());
				transaction.setOperationId(singleTransactionModel.getOperationId());
				transaction.setTransactionId(singleTransactionModel.getTransactionId());
				transaction.setTypeEnumeration(singleTransactionModel.getType().getEnumeration());
				transaction.setTypeValue(singleTransactionModel.getType().getValue());
				transaction.setValueDate(singleTransactionModel.getValueDate());
				transactionRepository.save(transaction);
				LOGGER.info("transaction with operationId {}, saved into db", transaction.getOperationId());
			}
			
		}
		
	}

}
