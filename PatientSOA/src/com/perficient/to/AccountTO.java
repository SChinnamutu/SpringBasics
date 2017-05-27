package com.perficient.to;

public class AccountTO {

	private String accountNumber;
	private String accountBalance;
	private String remarks;
	private String accountName;
	private String isAmountAvailable;
	
	public String getIsAmountAvailable() {
		return isAmountAvailable;
	}
	public void setIsAmountAvailable(String isAmountAvailable) {
		this.isAmountAvailable = isAmountAvailable;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
}
