 /*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  com.perficient.dao.viewAppointmentDAO
 *  com.perficient.pojo.PftAppointmentDetails
 *  com.perficient.pojo.PftDoctorDetails
 *  com.perficient.to.ResponseTO
 *  javax.persistence.EntityManager
 *  javax.persistence.PersistenceContext
 *  javax.persistence.Query
 *  org.springframework.stereotype.Component
 *  org.springframework.transaction.annotation.Transactional
 */
package com.perficient.daoImpl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.perficient.applicationConstant.ApplicationConstant;
import com.perficient.pojo.PftAppointmentDetails;
import com.perficient.pojo.PftDoctorDetails;
import com.perficient.to.ResponseTO;

@Component
@Transactional
public class ViewAppointmentDAOImpl {
  
	@PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
	public List<PftDoctorDetails> getAllAppointDetails(BigDecimal userId) {
    	List<PftDoctorDetails> iPftDoctorDetails = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftDoctorDetails where status=:status");
            query.setParameter("status", (Object)"N");
            iPftDoctorDetails = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return iPftDoctorDetails;
    }

    @SuppressWarnings("unchecked")
	public List<PftDoctorDetails> getAvailDoctorDetails() {
    	List<PftDoctorDetails> iPftAppointDetails = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftDoctorDetails where status=:status");
            query.setParameter("status",ApplicationConstant.Y);
            iPftAppointDetails = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return iPftAppointDetails;
    }

    public PftDoctorDetails getDoctorDetail(String userId) {
        PftDoctorDetails iPftAppointDetails = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftDoctorDetails where id=:userId");
            query.setParameter("userId", (Object)Integer.parseInt(userId));
            iPftAppointDetails = (PftDoctorDetails)query.getSingleResult();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return iPftAppointDetails;
    }

    public ResponseTO updateDetails(PftDoctorDetails pftDoctorDetails) {
        ResponseTO responseTO = new ResponseTO();
        try {
            this.entityManager.merge((Object)pftDoctorDetails);
            responseTO.setStatus("SUCCESS");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return responseTO;
    }

    public ResponseTO save(PftAppointmentDetails pftAppointDetails) {
        ResponseTO responseTO = new ResponseTO();
        try {
            this.entityManager.persist((Object)pftAppointDetails);
            responseTO.setStatus("SUCCESS");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return responseTO;
    }

    @SuppressWarnings("unchecked")
	public List<PftAppointmentDetails> getAppointmentDetails() {
    	List<PftAppointmentDetails> iPftAppointDetails = null;
        Query query = null;
        try {
            query = this.entityManager.createQuery("from PftAppointmentDetails");
            iPftAppointDetails = query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return iPftAppointDetails;
    }

}
