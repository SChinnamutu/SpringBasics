package com.perficient.dao;

import java.math.BigDecimal;
import java.util.List;

import com.perficient.pojo.PftAppointDetails;
import com.perficient.pojo.PftDoctorDetails;


public interface RequestDAO {

	public PftDoctorDetails saveRequestDetials(String doctorId);
	public void attachDirty(PftDoctorDetails pftDoctorDetails);
	List<PftAppointDetails> getAppointDetails(BigDecimal userId);
	
}
