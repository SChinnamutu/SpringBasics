package com.perficient.interceptor;

import org.apache.log4j.Logger;

import com.perficient.util.ServiceCommanUtil;
 

public class CustomRequestHandler  {
 
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
 
}