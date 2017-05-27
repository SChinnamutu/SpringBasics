package com.perficient.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.PerfConstant.Constant;
import com.perficient.daoImpl.viewAppointmentDAOImpl;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.to.AppointTO;
import com.perficient.to.ResponseTO;

@Component
@Service
public class viewAppointmentBO {

	@Autowired
	private viewAppointmentDAOImpl iViewDAOImpl;
	
	
	public List<AppointTO> retriveDetails() {
		List<PftDoctorDetails> details = iViewDAOImpl.getAvailDoctorDetails();
		return this.getDetails(details);
	}
	
	public List<AppointTO> getDetails(List<PftDoctorDetails> details){
		List<AppointTO> appointTOs = new ArrayList<AppointTO>();
		for (PftDoctorDetails pftAppointDetail : details) {
			AppointTO appointTO = new AppointTO();
				appointTO.setName(pftAppointDetail.getDoctorName());
				appointTO.setLocation(pftAppointDetail.getDoctorLocation());
				appointTO.setAppointment(pftAppointDetail.getAppointments());
				appointTO.setDoctorId(pftAppointDetail.getId());
				appointTO.setFees(200.0);
				appointTOs.add(appointTO);
			}
		return appointTOs;
	}
	
	public ResponseTO saveFixedTimeDetails(String userId, String doctorId) {
			PftDoctorDetails iPftDoctorDetails = iViewDAOImpl.getDoctorDetail(userId);
			iPftDoctorDetails.setStatus(Constant.Y);
			return iViewDAOImpl.updateDetails(iPftDoctorDetails);
	}

}
