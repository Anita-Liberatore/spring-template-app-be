package com.fabrick.test.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabrick.test.demo.constants.FabrickApiUri;

@RestController
@RequestMapping(FabrickApiUri.MAPPING_URI_PING_TEST)
public class PingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);
	
	@GetMapping
	public ResponseEntity<String> ping() {
		LOGGER.info("Ping: Ping Controller START");
		return new ResponseEntity<String>("Ping app OK", HttpStatus.OK);
	}
}
