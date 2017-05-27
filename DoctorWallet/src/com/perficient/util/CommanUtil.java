package com.perficient.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class CommanUtil {

	public static boolean isMandatory(String input){
		if(input != null && !"".equalsIgnoreCase(input) && !input.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static String convertDateToFormat(Date date, String format){	
		String currentDate = null;
		SimpleDateFormat formattter = new SimpleDateFormat(format); 
		try {
			if(date != null){
				currentDate =  formattter.format(date);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDate.toString();
	}
	
	public static String convertToJson(Object response) throws ParseException{
		Gson gson = new Gson();
	    return gson.toJson(response);
	}
	
	public static Date convertStringToDate(String inputDate,String format){
		DateFormat formatter = null; 
		Date date = null ; 
		try {
			formatter = new SimpleDateFormat(format);
			date = formatter.parse(inputDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
