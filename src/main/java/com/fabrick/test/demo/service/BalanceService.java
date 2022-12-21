package com.fabrick.test.demo.service;

import com.fabrick.test.demo.model.BalanceModel;

public interface BalanceService {

	BalanceModel getBalanceByAccount(long accountId);
}
