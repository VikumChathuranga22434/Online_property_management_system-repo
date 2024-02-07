package com.company.web.jdbc;

public class Customer {
	
	private int customerId;
	private String firstname;
	private String lastname;
	private String address;
	private String NIC;
	private String message;
	
	public Customer(int customerId, String firstname, String lastname, String address, String nIC, String message) {
		super();
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		NIC = nIC;
		this.message = message;
	}

	public Customer(String firstname, String lastname, String address, String nIC, String message) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		NIC = nIC;
		this.message = message;
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getNIC() {
		return NIC;
	}

	public String getMessage() {
		return message;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", NIC=" + NIC + ", message=" + message + "]";
	}

}
