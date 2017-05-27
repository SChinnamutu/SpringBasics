package com.perficient.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	/*@Column(name="PAD_DOCTOR_FIXED_TIMES")
	private String fixedTimes;*/

	@Column(name="PAD_STATUS")
	private String status;
	
	
	
	/*	@Column(name="PAD_USER_ID")
	private BigDecimal padUserId;*/
	
	
	/*@Column(name="PAD_DOCTOR_ID")
	private BigDecimal doctorId;
	*/

	/*public String getStatus() {
		return status;
	}*/

	/*public void setStatus(String status) {
		this.status = status;
	}*/

	/*public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
*/
/*	public PftUserDetails getPftUserDetails() {
		return pftUserDetails;
	}

	public void setPftUserDetails(PftUserDetails pftUserDetails) {
		this.pftUserDetails = pftUserDetails;
	}*/

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
