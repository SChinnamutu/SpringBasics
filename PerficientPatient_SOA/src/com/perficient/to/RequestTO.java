package com.perficient.to;


public class RequestTO {

	private int doctorId;
	private String doctorName;
	private String doctorLocation;
	private String fixedTime;
	private String appointmentDate;
	
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
