package com.fabrick.test.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fabrick.test.demo.service.BalanceService;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
    private BalanceService balanceService;

	@Test
	void contextLoads() {
	}

}
