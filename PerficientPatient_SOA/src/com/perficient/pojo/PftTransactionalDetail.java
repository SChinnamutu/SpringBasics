package com.perficient.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PFT_TRANSACTIONAL_DETAIL")
public class PftTransactionalDetail {
	
	@Column(name="PTD_ID")
	private int id;
	
	@Column(name="PTD_TRANSACTION_FROM")
	private String transactionFrom;
	
	@Column(name="PTD_TRANSACTION_TO")
	private String trabnsactionTo;
	
	@Column(name="PTD_TRANSACTION_TYPE")
	private String transactionType;
	
	@Column(name="PTD_TRANSACTION_STATUS")
	private String transactionStatus;
	
	@Column(name="PTD_TRANSACTION_ID")
	private String transactionId;
	
	@Column(name="PTD_OWNER_ID")
	private int ownerId;

	@OneToMany(mappedBy="pftTransactionalDetails")
	private Set<PftAccountDetails> pftAccountDetails;
	
	public Set<PftAccountDetails> getPftAccountDetails() {
		return pftAccountDetails;
	}

	public void setPftAccountDetails(Set<PftAccountDetails> pftAccountDetails) {
		this.pftAccountDetails = pftAccountDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransactionFrom() {
		return transactionFrom;
	}

	public void setTransactionFrom(String transactionFrom) {
		this.transactionFrom = transactionFrom;
	}

	public String getTrabnsactionTo() {
		return trabnsactionTo;
	}

	public void setTrabnsactionTo(String trabnsactionTo) {
		this.trabnsactionTo = trabnsactionTo;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
}
