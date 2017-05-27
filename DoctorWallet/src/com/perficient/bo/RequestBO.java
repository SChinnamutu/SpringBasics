package com.perficient.bo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.daoImpl.AccountDAOImpl;
import com.perficient.daoImpl.RequestDAOImpl;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftAppointmentDetails;
import com.perficient.pojo.PftUploadFileDetails;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.RequestTO;
import com.perficient.to.ResponseTO;
import com.perficient.util.CommanUtil;

@Component
@Service
public class RequestBO {

	@Autowired
	private RequestDAOImpl iRequestDAOImpl;
	
	@Autowired
	private AccountDAOImpl iAccountDAOImpl;

	public List<RequestTO> getRequestDetails(String doctorId) {
		NumberFormat formatter = new DecimalFormat("#0");  
		BigDecimal userId = null;
		List<PftAppointmentDetails> iPftAppointDetails = iRequestDAOImpl.getAppointDetails(doctorId);
		List<RequestTO> iRequestTOs =  new ArrayList<RequestTO>();
		PftAppointmentDetails iPftAppointDetail  = null;
		List<PftUploadFileDetails> iPftUploadFileDetails  = null;
		for (Iterator<PftAppointmentDetails> iterator = iPftAppointDetails.iterator(); iterator.hasNext();) {
			RequestTO requestTO = new RequestTO();
			iPftAppointDetail = (PftAppointmentDetails) iterator.next();
			userId = iPftAppointDetail.getPmadUserId();
			PftUserDetails iPftUserDetails = iRequestDAOImpl.getUserDetails(formatter.format(userId));
			requestTO.setUserId(Integer.parseInt(formatter.format(userId)));
			requestTO.setPatientName(iPftUserDetails.getName());
			requestTO.setPatientNumber(iPftUserDetails.getMobileNumber());
			requestTO.setFixedTime(iPftAppointDetail.getFixedTime());
			requestTO.setRaisedDate(CommanUtil.convertDateToFormat(iPftAppointDetail.getRaisedDate(), "dd/MM/yyyy HH:mm:ss"));  
			requestTO.setAppointmentDate(CommanUtil.convertDateToFormat(iPftAppointDetail.getAppointmentDate(), "dd/MM/yyyy"));
			requestTO.setStatus(iPftAppointDetail.getStatus());
			requestTO.setDoctorId(Integer.parseInt(doctorId));
			requestTO.setRequestId(String.valueOf(iPftAppointDetail.getId()));	
			iPftUploadFileDetails = iRequestDAOImpl.checkFileAvailable(formatter.format(userId));
			if(iPftUploadFileDetails != null && iPftUploadFileDetails.size() >= 0){
				requestTO.setFileAvailable(ApplicationConstant.YES);
			}
			iRequestTOs.add(requestTO);
		}
		return iRequestTOs;
		
	}

	public ResponseTO declineRequest(String requestId) {
		PftAppointmentDetails iPftAppointDetails = iRequestDAOImpl.getSpecificAppointDetails(requestId);
		PftAccountDetails accountDetails = iAccountDAOImpl.getUserSpecificAccountDetails(iPftAppointDetails.getPmadUserId());
		accountDetails.setAccountBalance(accountDetails.getAccountBalance()+200);
		iRequestDAOImpl.attachDirty(accountDetails);
		iPftAppointDetails.setStatus(ApplicationConstant.DECLINE);
		return iRequestDAOImpl.attachDirty(iPftAppointDetails);
	}
	
	public ResponseTO acceptRequest(String requestId) {
		PftAppointmentDetails iPftAppointDetails = iRequestDAOImpl.getSpecificAppointDetails(requestId);
		PftAccountDetails accountDetails = iAccountDAOImpl.getUserSpecificAccountDetails(iPftAppointDetails.getPmadUserId());
		accountDetails.setAccountBalance(accountDetails.getAccountBalance());
		iRequestDAOImpl.attachDirty(accountDetails);
		iPftAppointDetails.setStatus(ApplicationConstant.ACCEPT);
		return iRequestDAOImpl.attachDirty(iPftAppointDetails);
	}

	public ResponseTO getFileDetails(String userId) {
		ResponseTO responseTO = new ResponseTO();
		PftUploadFileDetails iPftUploadFileDetails = iRequestDAOImpl.getFileDetails(userId);
		responseTO.setBlob(iPftUploadFileDetails.getContent());
		responseTO.setfName(iPftUploadFileDetails.getFileName());
		responseTO.setContenType(iPftUploadFileDetails.getContentType());
		return responseTO;
	}
	
		
	
}
