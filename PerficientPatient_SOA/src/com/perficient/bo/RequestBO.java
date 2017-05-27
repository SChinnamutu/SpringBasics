package com.perficient.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.PerfConstant.Constant;
import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.RequestDAOImpl;
import com.perficient.daoImpl.viewAppointmentDAOImpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftAppointDetails;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.to.RequestTO;
import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;

@Component
@Service
public class RequestBO {

	@Autowired
	private RequestDAOImpl iRequestDAOImpl;
	
	@Autowired
	private viewAppointmentDAOImpl viewAppointmentDAOImpl;
	
	@PreAuthorize("@roleValid.preHandle(#merchantKey,'101') and @roleValid.isUserExist(#userId)")
	public List<RequestTO> getRequestDetails(String merchantKey,String userId) {
		List<PftAppointDetails> iPftAppointDetails = iRequestDAOImpl.getAppointDetails(new BigDecimal(userId));
		List<RequestTO> iAppointTOs =  new ArrayList<RequestTO>();
		PftAppointDetails iPftAppointDetail  = null;
		for (Iterator<PftAppointDetails> iterator = iPftAppointDetails.iterator(); iterator.hasNext();) {
			RequestTO requestTO = new RequestTO();
			iPftAppointDetail = (PftAppointDetails) iterator.next();
			requestTO.setDoctorId(iPftAppointDetail.getDoctorId());
			requestTO.setDoctorName(iPftAppointDetail.getDoctorName());
			requestTO.setDoctorLocation(iPftAppointDetail.getDoctorLocation());
			requestTO.setFixedTime("11:30");
			requestTO.setAppointmentDate(ServiceCommanUtil.dateFormat(iPftAppointDetail.getAppointmentDate(), "dd/MM/yyyy"));
			iAppointTOs.add(requestTO);
		}
		return iAppointTOs;
		
	}
	
	@Autowired
	private AccountDAOImpl accountDAOImpl;
	
	
	
	public ResponseTO saveRequestDetials(String loginUserId, String doctorId) {
		List<PftAccountDetails> accountDetails = accountDAOImpl.getAccountDetails(new BigDecimal(loginUserId));
		PftDoctorDetails pftDoctorDetails = null;
		ResponseTO responseTO =  new ResponseTO();
		for (PftAccountDetails pftAccountDetails : accountDetails) {
			if(pftAccountDetails != null){
				pftDoctorDetails = viewAppointmentDAOImpl.getDoctorDetail(doctorId);
				if(pftAccountDetails.getAccountBalance() >= pftDoctorDetails.getDoctorCharge()){
					PftAppointDetails pftAppointDetails =  new PftAppointDetails();
					pftAppointDetails.setDoctorName(pftDoctorDetails.getDoctorName());
					pftAppointDetails.setDoctorLocation(pftDoctorDetails.getDoctorLocation());
					pftAppointDetails.setPmadUserId(new BigDecimal(loginUserId));
					pftAppointDetails.setDoctorId(pftDoctorDetails.getId());
					pftAppointDetails.setAppointmentDate(new Date());
					pftAppointDetails.setFixedTime(pftDoctorDetails.getAppointments());
					pftAccountDetails.setAccountBalance(pftAccountDetails.getAccountBalance() - pftDoctorDetails.getDoctorCharge());
					iRequestDAOImpl.save(pftAppointDetails);
					pftDoctorDetails.setStatus(Constant.Y);
					iRequestDAOImpl.attachDirty(pftDoctorDetails);
					return accountDAOImpl.updateDetails(pftAccountDetails);
				}else{
					responseTO.setStatus(Constant.RESPONSE_FAILURE);
					responseTO.setResponseCodeDescription(Constant.INSUFFICIENT_WALLET_BALANCE);
				}
			}
		}
		return responseTO;	
	}
		
	
}
