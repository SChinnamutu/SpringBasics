package com.perficient.to;


public class RequestTO {

	private int doctorId;
	private String doctorName;
	private String doctorLocation;
	private String fixedTime;
	private String appointmentDate;
	private String status;
	private String requestId;
	private String patientName;
	private String patientNumber;
	private int userId;
	private String fileAvailable;
	private String raisedDate;
	
	public String getRaisedDate() {
		return raisedDate;
	}
	public void setRaisedDate(String raisedDate) {
		this.raisedDate = raisedDate;
	}
	public String getFileAvailable() {
		return fileAvailable;
	}
	public void setFileAvailable(String fileAvailable) {
		this.fileAvailable = fileAvailable;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientNumber() {
		return patientNumber;
	}
	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDoctorLocation() {
		return doctorLocation;
	}
	public void setDoctorLocation(String doctorLocation) {
		this.doctorLocation = doctorLocation;
	}
	public String getFixedTime() {
		return fixedTime;
	}
	public void setFixedTime(String fixedTime) {
		this.fixedTime = fixedTime;
	}
	
}
