package com.perficient.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.pojo.PftUserDetails;

@Component
@Transactional
public class LoginDAOImpl {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<PftUserDetails> validate(String userName,String pswd) {
		List<PftUserDetails> pftUserDetails = null;
		Query query = null;
		try {
			query = entityManager.createQuery("from PftUserDetails  where mobileNumber=:number and password=:pswd");
			query.setParameter("number", userName);
			query.setParameter("pswd", pswd);
			pftUserDetails = (List<PftUserDetails>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return pftUserDetails;
	}

}
