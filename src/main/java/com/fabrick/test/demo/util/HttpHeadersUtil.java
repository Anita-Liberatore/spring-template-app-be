package com.fabrick.test.demo.util;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fabrick.test.demo.constants.FabrickConstants;

public class HttpHeadersUtil {

	public static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		//custom headers
		headers.set(FabrickConstants.AUTH_SCHEMA_KEY, FabrickConstants.AUTH_SCHEMA_VALUE);
		headers.set(FabrickConstants.API_KEY, FabrickConstants.API_VALUE);
		
		return headers;
	}
}
