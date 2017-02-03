package com.qantas.airport.search.model;

public class Country {
	private String code;
	private String display_name;
	public Country(){}
	public Country (String code, String display_name){
		this.code  = code;
		this.display_name = display_name;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDisplay_name() {
		return display_name;
	}
	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
}
