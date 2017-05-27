package com.perficient.pojo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PFT_ACCOUNT_DETAILS")
public class PftAccountDetails {

	@Id
	@Column(name="PAD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	/*@Id
	@Column(name="PAD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigDecimal id;*/

	
	/*@Column(name="PAD_USER_ID")
	private PftUserDetails pftUserDetails;*/
	
	@Column(name="PAD_USER_ID")
	private BigDecimal pftUserId;
	
	@Column(name="PAD_ACCOUNT_NUMBER")
	private String accountNumber;
	

	@Column(name="PAD_ACCOUNT_NAME")
	private String accountName;
	
	@Column(name="PAD_ACCOUNT_BALANCE")
	private double accountBalance;
	
	@Column(name="PAD_REMARKS")
	private String remarks;

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
	/*public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BigDecimal getPftUserId() {
		return pftUserId;
	}

	public void setPftUserId(BigDecimal pftUserId) {
		this.pftUserId = pftUserId;
	}
	
	/*public PftUserDetails getPftUserDetails() {
		return pftUserDetails;
	}

	public void setPftUserDetails(PftUserDetails pftUserDetails) {
		this.pftUserDetails = pftUserDetails;
	}*/


	
}
