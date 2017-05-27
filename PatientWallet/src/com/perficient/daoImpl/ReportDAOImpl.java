package com.perficient.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.dao.ReportDAO;
import com.perficient.pojo.PftAppointmentDetails;
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
   @SuppressWarnings("unchecked")
public List<PftAppointmentDetails> getReportDoctor(String userId) {
        List<PftAppointmentDetails> iPftUploadFileDetails = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftAppointmentDetails where pmadUserId=:userId");
            query.setParameter("userId", (Object)new BigDecimal(userId));
            iPftUploadFileDetails = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return iPftUploadFileDetails;
    }
}
