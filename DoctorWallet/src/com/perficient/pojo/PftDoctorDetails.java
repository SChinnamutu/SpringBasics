package com.perficient.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="PFD_DOCTOR_DETAIL")
public class PftDoctorDetails {

	@Id
	@Column(name="PAD_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="PAD_DOCTOR_NAME")
	private String doctorName;
	
	@Column(name="PAD_DOCTOR_LOCATION")
	private String doctorLocation;
	
	@Column(name="PAD_DOCTOR_APPOINTMENTS")
	private String appointments;
	
	@Column(name="PAD_DOCTOR_CHARGE")
	private int doctorCharge;
	
	@Column(name="PAD_DOCTOR_AVAIL_DATE")
	private String doctorAvailDate;
	
	@Column(name="PAD_DOCTOR_SERVICE")
	private String service;

	@Column(name="PAD_STATUS")
	private String status;
	
	@Column(name="PAD_DOCTOR_ID")
	private int doctorId;
	


	 /*@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	 @JoinColumn(name="PAD_DOCTOR_ID")
	 private Set<PftAppointmentDetails> appointmentDetails;
	 
	public Set<PftAppointmentDetails> getAppointmentDetails() {
		return appointmentDetails;
	}

	public void setAppointmentDetails(Set<PftAppointmentDetails> appointmentDetails) {
		this.appointmentDetails = appointmentDetails;
	}*/

	 
	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorAvailDate() {
		return doctorAvailDate;
	}
	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public void setDoctorAvailDate(String doctorAvailDate) {
		this.doctorAvailDate = doctorAvailDate;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/*	public BigDecimal getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(BigDecimal doctorId) {
		this.doctorId = doctorId;
	}
*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAppointments() {
		return appointments;
	}

	public void setAppointments(String appointments) {
		this.appointments = appointments;
	}

	public int getDoctorCharge() {
		return doctorCharge;
	}

	public void setDoctorCharge(int doctorCharge) {
		this.doctorCharge = doctorCharge;
	}


/*	public String getFixedTimes() {
		return fixedTimes;
	}

	public void setFixedTimes(String fixedTimes) {
		this.fixedTimes = fixedTimes;
	}
	public BigDecimal getPadUserId() {
		return padUserId;
	}

	public void setPadUserId(BigDecimal padUserId) {
		this.padUserId = padUserId;
	}*/
	

/*	@Id
	@Column(name="PAD_APPOINT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigDecimal id;
*/
	//private PftUserDetails pftUserDetails;
}
