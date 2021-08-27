package com.sample.microservice.customer.preferences.model;

import java.io.Serializable;

public class CustomerPreferencesVO implements Serializable {

	private static final long serialVersionUID = -7218459511942122094L;
	private String firstName;
	private String lastName;
	private String emailId;
	private String postalAddress;
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CustomerPreferencesVO [firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", postalAddress=" + postalAddress + ", phoneNumber=" + phoneNumber + "]";
	}

}
