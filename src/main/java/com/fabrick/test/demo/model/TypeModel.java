package com.fabrick.test.demo.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -529908409573961563L;
	
	@JsonProperty("enumeration")
	private String enumeration;
	
	@JsonProperty("value")
	private String value;
	
	public String getEnumeration() {
		return enumeration;
	}
	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "TypeModel [enumeration=" + enumeration + ", value=" + value + "]";
	}
	
	
}
