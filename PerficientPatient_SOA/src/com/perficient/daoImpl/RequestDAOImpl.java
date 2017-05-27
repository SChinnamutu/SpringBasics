package com.perficient.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.pojo.PftAppointDetails;
import com.perficient.pojo.PftDoctorDetails;

@Component
@Transactional
public class RequestDAOImpl {


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

	public void save(PftAppointDetails pftAppointDetails) {
		try {
			entityManager.persist(pftAppointDetails);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<PftAppointDetails> getAppointDetails(BigDecimal userId) {
		List<PftAppointDetails> iPftAppointDetails = null;
		Query query = null;
		try {
			query  = entityManager.createQuery("from PftAppointDetails where pmadUserId=:userId");
			query.setParameter("userId", userId);
			iPftAppointDetails = (List<PftAppointDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return iPftAppointDetails;
	}

}
