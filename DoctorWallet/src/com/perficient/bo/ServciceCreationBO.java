package com.perficient.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.daoImpl.RequestDAOImpl;
import com.perficient.daoImpl.ServiceCreationImplDAO;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ServiceCreationForm;

@Component
public class ServciceCreationBO {

	@Autowired
	private ServiceCreationImplDAO iServiceCreationImplDAO; 
	
	@Autowired
	private RequestDAOImpl iRequestDAOImpl; 
	
	public String saveServiceCreationDetails(ServiceCreationForm serviceCreationForm,String userId){
		PftUserDetails pftUserDetails = iRequestDAOImpl.getUserDetails(userId);
		PftDoctorDetails pftDoctorDetails = new PftDoctorDetails();
		pftDoctorDetails.setStatus(ApplicationConstant.Y);
		pftDoctorDetails.setDoctorName(pftUserDetails.getName());
		pftDoctorDetails.setDoctorLocation(serviceCreationForm.getLocation());
		pftDoctorDetails.setDoctorCharge(serviceCreationForm.getServiceCharge());
		pftDoctorDetails.setAppointments(serviceCreationForm.getAvailTime());
		pftDoctorDetails.setDoctorAvailDate(serviceCreationForm.getAvailDate());
		pftDoctorDetails.setDoctorId(pftUserDetails.getUserId());
		pftDoctorDetails.setService(serviceCreationForm.getServiceName());
		return iServiceCreationImplDAO.save(pftDoctorDetails);
	}
	
}
