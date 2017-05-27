package com.perficient.modelController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Response;

import org.json.simple.parser.ParseException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.perficient.to.ResponseTO;
import com.perficient.util.ServiceCommanUtil;


@ControllerAdvice
public class GlobalAccessDeniedExceptionHandler {

	/*
	 * auhtor Sasikumar Chinnamuthu
	 */
	
	private ResponseTO  responseTO =  new ResponseTO();
	
	@ExceptionHandler(AccessDeniedException.class)
	public String handleException(HttpServletRequest request, Exception ex) throws ParseException{
		responseTO.setErrorCode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
		responseTO.setResponseData(ex.getMessage());
		responseTO.setResponseCodeDescription(Response.Status.BAD_REQUEST.toString());
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	

	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex) throws ParseException{
		responseTO.setErrorCode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
		responseTO.setResponseCodeDescription(Response.Status.BAD_REQUEST.toString());
		responseTO.setResponseData(ex.getMessage());
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	
	@ExceptionHandler(IOException.class)
	public String handleIOException(HttpServletRequest request, Exception ex) throws ParseException{
		responseTO.setErrorCode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
		responseTO.setResponseData(ex.getMessage());
		responseTO.setResponseCodeDescription(Response.Status.BAD_REQUEST.toString());
		return ServiceCommanUtil.convertToJson(responseTO);
	}
	
}

