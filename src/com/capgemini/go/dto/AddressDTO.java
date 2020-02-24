package com.capgemini.go.dto;

public class AddressDTO {
	private String addressid;
	private String retailerId;
	private String buidingNo;
	private String city;
	private String state;
	private String field;
	private String zip;
	
	public AddressDTO(String addressid, String retailerId, String buidingNo, String city, String state, String field,
			String zip) {
		super();
		this.addressid = addressid;
		this.retailerId = retailerId;
		this.buidingNo = buidingNo;
		this.city = city;
		this.state = state;
		this.field = field;
		this.zip = zip;
	}

	public AddressDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getAddressid() {
		return addressid;
	}

	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}

	public String getRetailerId() {
		return retailerId;
	}

	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}

	public String getBuidingNo() {
		return buidingNo;
	}

	public void setBuidingNo(String buidingNo) {
		this.buidingNo = buidingNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Override
	public String toString() {
		return "AddressDTO [addressid=" + addressid + ", retailerId=" + retailerId + ", buidingNo=" + buidingNo
				+ ", city=" + city + ", state=" + state + ", field=" + field + ", zip=" + zip + "]";
	}
	
	

}
