package com.qantas.airport.search.model;

/**
 *	Filter class that goes to backend. This is a good separation. 
 *
 */
public class FilterCriteria {
	private String country;
	private String code;
	private Boolean intl;
	private Boolean domestic;
	
	public FilterCriteria (){}
	public FilterCriteria(String country, String code, Boolean intl, Boolean domestic){
		this.country = country;
		this.code = code;
		this.intl = intl;
		this.domestic = domestic;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getIntl() {
		return intl;
	}

	public void setIntl(Boolean intl) {
		this.intl = intl;
	}

	public Boolean getDomestic() {
		return domestic;
	}

	public void setDomestic(Boolean domestic) {
		this.domestic = domestic;
	}

}
