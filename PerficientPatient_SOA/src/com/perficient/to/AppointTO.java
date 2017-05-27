package com.perficient.to;

import java.util.List;

public class AppointTO {

	private int doctorId;
	private String name;
	private String location;
	private String appointment;
	private String status;
	private double fees;
	private List<String> availablityTimings;
	
	
	public String getAppointment() {
		return appointment;
	}
	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public List<String> getAvailablityTimings() {
		return availablityTimings;
	}
	public void setAvailablityTimings(List<String> availablityTimings) {
		this.availablityTimings = availablityTimings;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
