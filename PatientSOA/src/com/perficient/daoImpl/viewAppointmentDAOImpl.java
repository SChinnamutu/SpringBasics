package com.perficient.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.PerfConstant.Constant;
import com.perficient.pojo.PftAppointDetails;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.pojo.PftServiceDetails;
import com.perficient.to.ResponseTO;


@Component
@Transactional
public class viewAppointmentDAOImpl{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<PftDoctorDetails> getAllAppointDetails(BigDecimal userId) {
		List<PftDoctorDetails> iPftAppointDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftDoctorDetails where status=:status");
			query.setParameter("status", Constant.N);
			iPftAppointDetails = (List<PftDoctorDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iPftAppointDetails;
	}
	
	@SuppressWarnings("unchecked")
	public List<PftDoctorDetails> getAvailDoctorDetails() {
		List<PftDoctorDetails> iPftAppointDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftDoctorDetails where status=:status");
			query.setParameter("status", Constant.N);
			iPftAppointDetails = (List<PftDoctorDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iPftAppointDetails;
	}
	
	public PftDoctorDetails getDoctorDetail(String userId) {
		PftDoctorDetails iPftAppointDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftDoctorDetails where id=:userId");
			query.setParameter("userId", Integer.parseInt(userId));
			iPftAppointDetails = (PftDoctorDetails) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iPftAppointDetails;
	}
	
	public ResponseTO updateDetails(PftDoctorDetails pftAppointDetails) {
		ResponseTO responseTO = new ResponseTO();
		try {
			entityManager.merge(pftAppointDetails);
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return responseTO;
	}
	
	public ResponseTO save(PftAppointDetails pftAppointDetails) {
		ResponseTO responseTO = new ResponseTO();
		try {
			entityManager.persist(pftAppointDetails);
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return responseTO;
	}

	@SuppressWarnings("unchecked")
	public List<PftServiceDetails> getServiceDetails() {
		List<PftServiceDetails> iPftServiceDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftServiceDetails");
			iPftServiceDetails = (List<PftServiceDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iPftServiceDetails;

	}

	
	
}
