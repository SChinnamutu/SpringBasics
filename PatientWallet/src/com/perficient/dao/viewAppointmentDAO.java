package com.perficient.dao;

import java.math.BigDecimal;
import java.util.List;

import com.perficient.pojo.PftDoctorDetails;
import com.perficient.to.ResponseTO;



public interface viewAppointmentDAO {

	List<PftDoctorDetails> getAllAppointDetails(BigDecimal userId);
	PftDoctorDetails getUserDetail(BigDecimal userId);
	ResponseTO updateDetails(PftDoctorDetails pftAppointDetails);
	
}
