package com.perficient.scheduler;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.RequestDAOImpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftAppointmentDetails;


@Component
public class AppointmentScheduler {

	
	@Autowired
	private RequestDAOImpl iRequestDAOImpl;

	
	@Autowired
	private AccountDAOImpl iAccountDAOImpl;
	
	
	//@Scheduled(cron="*/5 * * * * ?")
	public void viewAppointmentDetails(){
		List<PftAppointmentDetails> iPftAppointDetails = null;
		Date currentDate =  new Date();
		try {
			iPftAppointDetails =  iRequestDAOImpl.getAppointmentDetails();
			for (Iterator<PftAppointmentDetails> iterator = iPftAppointDetails.iterator(); iterator.hasNext();) {
				PftAppointmentDetails pftAppointDetails = (PftAppointmentDetails) iterator.next();
				if(pftAppointDetails.getAppointmentDate().after(currentDate)){
					if(pftAppointDetails.getStatus().equalsIgnoreCase(ApplicationConstant.PENDING)){
						PftAccountDetails accountDetails = iAccountDAOImpl.getUserSpecificAccountDetails(pftAppointDetails.getPmadUserId());
						accountDetails.setAccountBalance(accountDetails.getAccountBalance()+200);
						iRequestDAOImpl.attachDirty(accountDetails);
						pftAppointDetails.setStatus(ApplicationConstant.EXPIRED);
						iRequestDAOImpl.attachDirty(pftAppointDetails);
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 
	
	
	//@Scheduled(cron="*/5 * * * * ?")
	/*public void checkExpire(){
		List<PftDoctorDetails> iPftDoctorDetails = null;
		Date currentDate =  new Date();
		try {
			iPftDoctorDetails =  iRequestDAOImpl.getDoctorDetail();
			for (Iterator<PftDoctorDetails> iterator = iPftDoctorDetails.iterator(); iterator.hasNext();) {
				PftDoctorDetails pftDoctorDetails = (PftDoctorDetails) iterator.next();
				PftAppointmentDetails pftAppointDetails = pftDoctorDetails.getAppointmentDetails().iterator().next();
				if(pftAppointDetails.getAppointmentDate().after(currentDate)){
					if(pftAppointDetails.getStatus().equalsIgnoreCase(ApplicationConstant.PENDING)){
						PftAccountDetails accountDetails = iAccountDAOImpl.getUserSpecificAccountDetails(pftAppointDetails.getPmadUserId());
						accountDetails.setAccountBalance(accountDetails.getAccountBalance()+200);
						iRequestDAOImpl.attachDirty(accountDetails);
						pftAppointDetails.setStatus(ApplicationConstant.EXPIRED);
						iRequestDAOImpl.attachDirty(pftAppointDetails);
					}
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	} 
	*/
	
}
