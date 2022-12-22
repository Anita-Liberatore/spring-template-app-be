package com.fabrick.test.demo.model;

import com.fabrick.test.demo.enumtype.DirectionEnum;
import com.fabrick.test.demo.enumtype.StatusEnum;

public class PaymentDoneModel {

	private StatusEnum status;
	private DirectionEnum direction;
	
	public PaymentDoneModel(StatusEnum status, DirectionEnum direction) {
		this.status = status;
		this.direction = direction;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public DirectionEnum getDirection() {
		return direction;
	}
	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
	
	
}
