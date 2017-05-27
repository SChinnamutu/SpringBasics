package com.perficient.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.pojo.PftDoctorDetails;

@Component
@Transactional
public class ServiceCreationImplDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	public String save(PftDoctorDetails pftDoctorDetails){
		try {
			entityManager.persist(pftDoctorDetails);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return ApplicationConstant.SERVICE_CREATED_SUCCESSFULLY;
	}
	
}
