package com.perficient.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.perficient.PerfConstant.Constant;
import com.perficient.pojo.PftServiceDetails;
import com.perficient.pojo.PftServiceFieldDetail;
import com.perficient.to.ResponseTO;

@Component
public class ServiceValidityUtility {

	
	@Autowired
	private ServletContext context;
	
	/*http://localhost:8080/perficientServiceWallet/serviceValidateLoginCredintials.do?uname=7373430978&pswd=messi
*/	
	public String validateInputParameter(HttpServletRequest request , String serviceName) throws ParseException{
		StringBuilder builder = new StringBuilder();
		ResponseTO responseTO = new ResponseTO();
		Map<String,String> serviceMap  = this.getParamerterDetail(request);
		PftServiceDetails pftServiceDetails = null;
		PftServiceFieldDetail  pftServiceFieldDetail = null;
		boolean status = false;
		try {
			pftServiceDetails = (PftServiceDetails) context.getAttribute(serviceName);
			if(pftServiceDetails != null && pftServiceDetails.getPftServiceFieldDetail() !=null){
				
				for (Iterator<PftServiceFieldDetail> iterator = pftServiceDetails.getPftServiceFieldDetail().iterator(); iterator.hasNext();) {
					
					pftServiceFieldDetail = (PftServiceFieldDetail) iterator.next();
					String fieldValue = serviceMap.get(pftServiceFieldDetail.getFieldName());
					
					if(ServiceCommanUtil.isMandatory(pftServiceFieldDetail.getFieldMandatory()) && pftServiceFieldDetail.getFieldMandatory().equalsIgnoreCase(Constant.Y)){
						if(fieldValue == null || "".equalsIgnoreCase(fieldValue)){
							responseTO.setResponseCodeDescription(builder.append(pftServiceFieldDetail.getFieldName().toString()).append(" should not be null.").toString());
							responseTO.setErrorCode(pftServiceFieldDetail.getErrorCode());
							responseTO.setStatus(Constant.RESPONSE_FAILURE);
							status =   true;
							break;
						}
					}
					
					if(ServiceCommanUtil.isMandatory(pftServiceFieldDetail.getFieldExpression())){
						if(!validateWithRegularExpression(pftServiceFieldDetail.getFieldExpression(),fieldValue)){
							responseTO.setResponseCodeDescription(builder.append(pftServiceFieldDetail.getFieldName().toString()).append(" should be in proper format.").toString());
							responseTO.setErrorCode(pftServiceFieldDetail.getErrorCode());
							responseTO.setStatus(Constant.RESPONSE_FAILURE);
							status =   true;
							break;
						}
					} 
					
				}
				
				}
			} catch (Exception e) {
				e.printStackTrace();
				responseTO.setResponseCodeDescription(Constant.APPLICATION_ERROR);
			}
			if(!status){
				return null;
			}
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	
	private boolean validateWithRegularExpression(String fieldExpression,String fieldValue) {
		Pattern pattern = Pattern.compile(fieldExpression);
		Matcher matcher = pattern.matcher(fieldValue);
		if(matcher.matches()){
			return true;
		}
		return false;
	}

	private Map<String, String> getParamerterDetail(HttpServletRequest request) {
		Map<String,String> serviceMap =  new HashMap<String,String>();
		Enumeration<String> en = request.getParameterNames();
		try {
			while (en.hasMoreElements()) {
				String key = (String) en.nextElement();
				String value = request.getParameter(key);
				serviceMap.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serviceMap;
	}
}
