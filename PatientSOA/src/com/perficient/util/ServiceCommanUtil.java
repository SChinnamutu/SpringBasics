package com.perficient.util;

import java.security.Key;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.json.simple.parser.ParseException;

import com.google.gson.Gson;


public class ServiceCommanUtil {

	public static boolean isMandatory(String input){
		if(input != null && !"".equalsIgnoreCase(input) && !input.isEmpty()){
			return true;
		}
		return false;
	}
	
	public static String dateFormat(Date date, String format){	
		String currentDate = null;
		SimpleDateFormat formattter = new SimpleDateFormat(format); 
		try {
			currentDate =  formattter.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDate.toString();
	}
	
	public static String convertToJson(Object response) throws ParseException{
		Gson gson = new Gson();
	    return gson.toJson(response);
	}
	
	private static final String ALGO = "AES";
	    //generate 128bit key
	private static final String keyStr = "Z8LSq0wWwB5v+6YJzurcP463H3F12iZh74fDj4S74oUH4EONkiKb2FmiWUbtFh97GG/c/lbDE47mvw6j94yXxKHOpoqu6zpLKMKPcOoSppcVWb2q34qENBJkudXUh4MWcreondLmLL2UyydtFKuU9Sa5VgY/CzGaVGJABK2ZR94=";
	 
	private static Key generateKey() throws Exception {
	        byte[] keyValue = keyStr.getBytes("UTF-8");
	        MessageDigest sha = MessageDigest.getInstance("SHA-1");
	        keyValue = sha.digest(keyValue);
	        keyValue = Arrays.copyOf(keyValue, 16); // use only first 128 bit       
	        Key key = new SecretKeySpec(keyValue, ALGO);
	        return key;
	}
	 
	public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);       
        byte[] decordedValue = DatatypeConverter.parseBase64Binary(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        System.out.println("Decrypt    "+ decryptedValue);
        return decryptedValue;
    }
	
}
