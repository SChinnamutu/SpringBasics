package com.perficient.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.dao.RegistrationDAO;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;

@Component
@Transactional
public class RegistrationDAOimpl implements RegistrationDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public ResponseTO saveDetails(PftUserDetails pftUserDetails) {
		ResponseTO responseTO = new ResponseTO();
		try {
			entityManager.persist(pftUserDetails);
			responseTO.setStatus(ApplicationConstant.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return responseTO;
	}


	@SuppressWarnings("unchecked")
	public List<PftUserDetails> getUserDetails(String mobileNumber) {
		List<PftUserDetails> iPftUserDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftUserDetails where PUD_MOBILE_NUMBER=:mobileNumber");
			query.setParameter("mobileNumber", mobileNumber);
			iPftUserDetails = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iPftUserDetails;
	}

	
}
