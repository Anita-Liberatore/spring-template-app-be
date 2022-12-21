package com.fabrick.test.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransanctionPayloadModel implements Serializable{


	private static final long serialVersionUID = -4263026181018068238L;
	
	@JsonProperty("payload")
	private TransactionsListModel payload;

	public TransactionsListModel getPayload() {
		return payload;
	}

	public void setPayload(TransactionsListModel payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "TransanctionPayloadModel [payload=" + payload + "]";
	}
	
	
}
