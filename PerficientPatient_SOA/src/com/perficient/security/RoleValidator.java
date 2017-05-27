package com.perficient.security;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.perficient.interceptor.CustomRequestHandler;
import com.perficient.util.ServiceCommanUtil;
 

@Component(value="roleValid")
public class RoleValidator  {
 
	private String handler = CustomRequestHandler.class.getSimpleName();
	
	private static final Logger logger = Logger.getLogger(CustomRequestHandler.class.getSimpleName());
	
    public boolean preHandle(Object key,String merchantKey) throws Exception {
    	logger.info("Interceptor is invoked successfully");
    	long startTime = System.currentTimeMillis();
    	boolean status = false;
    	
    	if(ServiceCommanUtil.isMandatory(merchantKey) && merchantKey.equals(key)){
    		status = true;
    	}
    	long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		if(logger.isDebugEnabled()){
			logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
		}
    	return status;
    }
    
    
    public boolean isUserExist(Object userId){
    	boolean status = false;    	
    	if(userId != null && !"".equals(userId)){
    		status =  false;
    	}
    	return status;
    }
    
 
}