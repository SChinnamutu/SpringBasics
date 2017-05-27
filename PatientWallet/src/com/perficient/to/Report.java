package com.perficient.to;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class Report implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String description;
	private List<MultipartFile> images;
	private String status;
	private List<String> doctors;
	
	public String getStatus() {
		return status;
	}
	public List<String> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<String> doctors) {
		this.doctors = doctors;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<MultipartFile> getImages() {
		return images;
	}
	public void setImages(List<MultipartFile> images) {
		this.images = images;
	}
		
	
	
}
