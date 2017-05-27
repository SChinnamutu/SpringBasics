package com.perficient.to;

import java.util.HashMap;
import java.util.Map;

public class ResponseTO {

	private String status;
	private String responseCodeDescription;
	private String responseData;
	private String errorCode;
	private String userId;
	private String fnamme;
	
	//private String status;
	//private String responseCodeDescription;
	//private String userId;
	//private List<AccountTO> iAccountTOs;
	private String fName;
	//private Blob blob;
	private String contenType;
	//private Map<String,Object> map;
	private Map<String,Object> map = new HashMap<String,Object>();

	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getContenType() {
		return contenType;
	}
	public void setContenType(String contenType) {
		this.contenType = contenType;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getFnamme() {
		return fnamme;
	}
	public void setFnamme(String fnamme) {
		this.fnamme = fnamme;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
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
	public String getResponseData() {
		return responseData;
	}
	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	
	
	
}
