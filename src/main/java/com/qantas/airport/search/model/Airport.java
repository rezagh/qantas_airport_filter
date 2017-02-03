package com.qantas.airport.search.model;

public class Airport {
	private String code;
	private String display_name;
	private Boolean international_airport;
	private Boolean regional_airport;
	private Location location;
	private String currency_code;
	private String timezone;
	private Country country;
	
	public Airport(){}
	
	public Airport (Country country, String code, Boolean intl, Boolean domestic){
		this.code = code;
		this.international_airport = intl;
		this.regional_airport = domestic;
		this.country = country;
		
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
	public Boolean isInternational_airport() {
		return international_airport;
	}
	public void setInternational_airport(Boolean international_airport) {
		this.international_airport = international_airport;
	}
	public Boolean isRegional_airport() {
		return regional_airport;
	}
	public void setRegional_airport(Boolean regional_airport) {
		this.regional_airport = regional_airport;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
}
