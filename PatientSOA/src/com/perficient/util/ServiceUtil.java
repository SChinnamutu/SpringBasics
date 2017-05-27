package com.perficient.util;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perficient.daoImpl.viewAppointmentDAOImpl;
import com.perficient.pojo.PftServiceDetails;

@Component
public class ServiceUtil {

	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private viewAppointmentDAOImpl iviewAppointmentDAOImpl;
	
	@PostConstruct
	public void init(){
		System.out.println("MyService init method called");
		List<PftServiceDetails> iPftServiceDetail = null;
		try {
			System.out.println("Ooh Dybala");
			iPftServiceDetail = iviewAppointmentDAOImpl.getServiceDetails();
			for (PftServiceDetails pftServiceDetail : iPftServiceDetail) {
				servletContext.setAttribute(pftServiceDetail.getServiceName(),pftServiceDetail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ServiceUtil(){
		System.out.println("MyService no-args constructor called");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("MyService destroy method called");
	}
	

	
}
