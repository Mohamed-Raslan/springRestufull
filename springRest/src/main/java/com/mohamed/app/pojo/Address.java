package com.mohamed.app.pojo;

public class Address {
	
	private String street;
	private String zip;
	private String governrate;
	
	
	public Address() {}
	
	public Address(String street, String zip, String governrate) {
		super();
		this.street = street;
		this.zip = zip;
		this.governrate = governrate;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getGovernrate() {
		return governrate;
	}
	public void setGovernrate(String governrate) {
		this.governrate = governrate;
	}
	
	
	

}
