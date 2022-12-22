package com.fabrick.test.demo.service;

import com.fabrick.test.demo.model.CreatePaymentModel;

public interface CreatePaymentService {

	void createPayment(long accountId, CreatePaymentModel request);
}
