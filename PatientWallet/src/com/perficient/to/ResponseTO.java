package com.perficient.to;

import java.sql.Blob;
import java.util.List;

public class ResponseTO {

	private String status;
	private String responseCodeDescription;
	private String userId;
	private List<AccountTO> iAccountTOs;
	private String fName;
	private Blob blob;
	private String contenType;
	
	
	
	public String getContenType() {
		return contenType;
	}
	public void setContenType(String contenType) {
		this.contenType = contenType;
	}
	public Blob getBlob() {
		return blob;
	}
	public void setBlob(Blob blob) {
		this.blob = blob;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public List<AccountTO> getiAccountTOs() {
		return iAccountTOs;
	}
	public void setiAccountTOs(List<AccountTO> iAccountTOs) {
		this.iAccountTOs = iAccountTOs;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResponseCodeDescription() {
		return responseCodeDescription;
	}
	public void setResponseCodeDescription(String responseCodeDescription) {
		this.responseCodeDescription = responseCodeDescription;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
