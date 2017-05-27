package com.perficient.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.dao.ReportDAO;
import com.perficient.pojo.PftUploadFileDetails;
import com.perficient.to.ResponseTO;

@Component
@Transactional
public class ReportDAOImpl implements ReportDAO {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ResponseTO saveFileDetails(PftUploadFileDetails details) {
		ResponseTO responseTO =  new ResponseTO();
		try {
			entityManager.persist(details);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		responseTO.setStatus(ApplicationConstant.RESPONSE_SUCCESS);
		return responseTO;
	}

}
