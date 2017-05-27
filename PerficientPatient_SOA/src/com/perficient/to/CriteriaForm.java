package com.perficient.to;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class CriteriaForm implements Serializable{

	/**
	 * Sasikumar Chinnamuthu
	 */
	private static final long serialVersionUID = 1L;
	private String fromdate;
	private String todate;
	private String profession;
	private String institution;
	private String dental;
	private String subscriberId;
	private String submitterId;
	private MultipartFile dcnfile;
	private String email;
	private String comments;
	private String claimType;
	
	
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public String getFromdate() {
		return fromdate;
	}
	public MultipartFile getDcnfile() {
		return dcnfile;
	}
	public void setDcnfile(MultipartFile dcnfile) {
		this.dcnfile = dcnfile;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getDental() {
		return dental;
	}
	public void setDental(String dental) {
		this.dental = dental;
	}
	public String getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(String subscriberId) {
		this.subscriberId = subscriberId;
	}
	public String getSubmitterId() {
		return submitterId;
	}
	public void setSubmitterId(String submitterId) {
		this.submitterId = submitterId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
