package com.assignment.token.businessObject;

import lombok.Data;


public class Token {

    private String tokenId;

    private String createdOn;

    private String counter;

    private int forPrivilegedCustomer;
    
	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getCounter() {
		return counter;
	}

	public void setCounter(String counter) {
		this.counter = counter;
	}
	
	

	public int getForPrivilegedCustomer() {
		return forPrivilegedCustomer;
	}

	public void setForPrivilegedCustomer(int forPrivilegedCustomer) {
		this.forPrivilegedCustomer = forPrivilegedCustomer;
	}

	@Override
	public String toString() {
		return "Token [tokenId=" + tokenId + ", createdOn=" + createdOn + ", counter=" + counter
				+ ", forPrivilegedCustomer=" + forPrivilegedCustomer + "]";
	}

	

    
    
    

}
