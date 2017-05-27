package com.perficient.pojo;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;


@Entity
@Table(name="PPI_UPLOAD_FILE_DETAIL")
public class PftUploadFileDetails {

	@Id
	@Column(name="PUFD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="PUFD_FILE_NAME")
	private String fileName;
	
	@Column(name="PUFD_USER_ID")
	private int userId;

	@Column(name = "PUFD_FILE_DATA")
	@Lob
	private Blob content;
	
	@Column(name="PUFD_FILE_CONTENT_TYPE")
	private String contentType;
	
	@Column(name="PUFD_FILE_UPDATE_DATE")
	private Date created;
	
	@Column(name="PUFD_DOCTOR_ID")
	private int doctorId;
	
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Blob getContent() {
		return content;
	}

	public void setContent(Blob content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
