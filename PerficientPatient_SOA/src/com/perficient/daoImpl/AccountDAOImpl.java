package com.perficient.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.PerfConstant.Constant;
import com.perficient.pojo.PftAccountDetails;
import com.perficient.to.ResponseTO;

@Component
@Transactional
public class AccountDAOImpl  {

	@PersistenceContext
	private EntityManager entityManager;
	
	ResponseTO responseTO = new ResponseTO();
	
	
	public ResponseTO saveDetails(PftAccountDetails pftAccountDetails) {
		try {
			entityManager.persist(pftAccountDetails);
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return responseTO;
	}

	public ResponseTO updateDetails(PftAccountDetails pftAccountDetails) {
		try {
			entityManager.merge(pftAccountDetails);
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return responseTO;
	}

	@SuppressWarnings("unchecked")
	public List<PftAccountDetails> getAccountDetails(BigDecimal userId) {
		List<PftAccountDetails> iPftAccountDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftAccountDetails where pftUserId=:userId");
			query.setParameter("userId", userId);
			iPftAccountDetails = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return iPftAccountDetails;
	}
	
	public PftAccountDetails getUserSpecificAccountDetails(BigDecimal userId) {
		PftAccountDetails iPftAccountDetail = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftAccountDetails where pftUserId=:userId");
			query.setParameter("userId", userId);
			iPftAccountDetail = (PftAccountDetails) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return iPftAccountDetail;
	}

	
}
