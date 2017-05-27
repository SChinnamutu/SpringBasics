package com.perficient.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.PerfConstant.Constant;
import com.perficient.pojo.PftUserDetails;
import com.perficient.to.ResponseTO;

@Component
@Transactional
public class RegistrationDAOimpl {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	public ResponseTO saveDetails(PftUserDetails pftUserDetails) {
		ResponseTO responseTO = new ResponseTO();
		try {
			entityManager.persist(pftUserDetails);
			responseTO.setStatus(Constant.RESPONSE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return responseTO;
	}

	
}
