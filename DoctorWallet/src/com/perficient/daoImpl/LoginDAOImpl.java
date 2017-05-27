package com.perficient.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.dao.LoginDAO;
import com.perficient.pojo.PftUserDetails;

@Component
@Transactional
public class LoginDAOImpl implements LoginDAO {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<PftUserDetails> validate(String userName,String pswd) {
		List<PftUserDetails> pftUserDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftUserDetails  where mobileNumber=:number and password=:pswd and roleId=:roleId");
			query.setParameter("number", userName);
			query.setParameter("pswd", pswd);
			query.setParameter("roleId", ApplicationConstant.DOCTOR);
			pftUserDetails = (List<PftUserDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return pftUserDetails;
	}


}
