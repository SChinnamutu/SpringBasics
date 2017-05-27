package com.perficient.dao;

import com.perficient.pojo.PftDoctorDetails;


public interface RequestDAO {

	public PftDoctorDetails saveRequestDetials(String doctorId);
	public void attachDirty(PftDoctorDetails pftDoctorDetails);
	//List<PftAppointmentDetails> getAppointDetails(BigDecimal userId);
	
}
