package com.perficient.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.dao.RequestDAO;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.pojo.PftAppointmentDetails;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.pojo.PftUploadFileDetails;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;

@Component
@Transactional
public class RequestDAOImpl implements RequestDAO{


	@PersistenceContext
	private EntityManager entityManager;
	
	public PftDoctorDetails saveRequestDetials(String doctorId) {
		PftDoctorDetails iPftDoctorDetail = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftDoctorDetails where doctorId=:doctorId");
			query.setParameter("doctorId", doctorId);
			iPftDoctorDetail = (PftDoctorDetails)query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return iPftDoctorDetail;
	}

	public void attachDirty(PftDoctorDetails pftDoctorDetails) {
		try {
			entityManager.merge(pftDoctorDetails);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void attachDirty(PftAccountDetails pftAccountDetails) {
		try {
			entityManager.merge(pftAccountDetails);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void save(PftAppointmentDetails pftAppointDetails) {
		try {
			entityManager.persist(pftAppointDetails);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PftAppointmentDetails> getAppointDetails(String userId) {
		List<PftAppointmentDetails> iPftAppointDetails = null;
		Query query = null;
		try {
			query  = entityManager.createQuery("from PftAppointmentDetails where doctorId=:doctorId and status=:status");
			query.setParameter("doctorId", Integer.parseInt(userId));
			query.setParameter("status", ApplicationConstant.PENDING);
			iPftAppointDetails = (List<PftAppointmentDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return iPftAppointDetails;
	}
	
	@SuppressWarnings("unchecked")
	public List<PftDoctorDetails> getDoctorDetail() {
		List<PftDoctorDetails> iPftDoctorDetails = null;
		Query query = null;
		try {
			query  = entityManager.createQuery("from PftDoctorDetails where status=:status");
			query.setParameter("status", ApplicationConstant.Y);
			iPftDoctorDetails = (List<PftDoctorDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return iPftDoctorDetails;
	}
	
	public PftAppointmentDetails getSpecificAppointDetails(String requestId) {
		PftAppointmentDetails iPftAppointDetails = null;
		Query query = null;
		try {
			query  = entityManager.createQuery("from PftAppointmentDetails where id=:requestId");
			query.setParameter("requestId", Integer.parseInt(requestId));
			iPftAppointDetails = (PftAppointmentDetails) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return iPftAppointDetails;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public PftUserDetails getUserDetails(String userId) {
   		List<PftUserDetails> iPftUserDetails = null;
		Query query = null;
		PftUserDetails pftUserDetails = null;
		try {
			query  = entityManager.createQuery("from PftUserDetails where userId=:userId");
			query.setParameter("userId", Integer.parseInt(userId));
			iPftUserDetails = (List<PftUserDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if(iPftUserDetails != null && iPftUserDetails.size() > 0){
			pftUserDetails = iPftUserDetails.get(0);
		}
		return pftUserDetails;
	}

	public ResponseTO attachDirty(PftAppointmentDetails pftAppointmentDetails) {
		ResponseTO responseTO = new ResponseTO();
		try {
			entityManager.merge(pftAppointmentDetails);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		responseTO.setStatus(ApplicationConstant.RESPONSE_SUCCESS);
		return responseTO;
	}

	@SuppressWarnings("unchecked")
	public List<PftAppointmentDetails> getAppointmentDetails() {
		List<PftAppointmentDetails> iPftAppointDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftAppointmentDetails");
			iPftAppointDetails = (List<PftAppointmentDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iPftAppointDetails;
	}

	@SuppressWarnings("unchecked")
	public PftUploadFileDetails getFileDetails(String userId) {
		List<PftUploadFileDetails> iPftUploadFileDetails = null;
		PftUploadFileDetails iPftUploadFileDetail = null;
		Query query = null;
		try {
			query  = entityManager.createQuery("from PftUploadFileDetails where doctorId=:userId");
			query.setParameter("userId", Integer.parseInt(userId));
			iPftUploadFileDetails = (List<PftUploadFileDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		if(iPftUploadFileDetails != null && iPftUploadFileDetails.size() > 0){
			return iPftUploadFileDetails.get(0);
		}
		return iPftUploadFileDetail;
	}

	@SuppressWarnings("unchecked")
	public List<PftUploadFileDetails> checkFileAvailable(String id) {
		List<PftUploadFileDetails> iPftUploadFileDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftUploadFileDetails where doctorId=:id");
			query.setParameter("id", Integer.parseInt(id));
			iPftUploadFileDetails = (List<PftUploadFileDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iPftUploadFileDetails;
	}

}
