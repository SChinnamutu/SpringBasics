package com.eprficient.junit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.junit.Test;

public class JUnitSpringExample {

	@Test
	public void successTest() throws ClientProtocolException, IOException {
		try {
			String url = "http://localhost:8080/perficientPatientService/serviceRequestDetails.do?userId=101&&merchantKey=101";
			HttpClient client = new DefaultHttpClient();
			HttpPost get = new HttpPost(url);
			HttpResponse response = client.execute(get);
			System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			//Read Data from object
			JSONObject jsonObject = new JSONObject(result.toString());
            System.out.println(jsonObject);
            String name = (String) jsonObject.get("responseData");
            System.out.println(name);
            String age = (String) jsonObject.get("status");
            System.out.println(age);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSampleServiceGetOrder() throws ClientProtocolException, IOException {
		try {
			//String url = "http://localhost:8080/bcbsmaClient/serviceRequestDetails.do";
			String url = "http://localhost:8080/perficientPatientService/serviceRequestDetails.do?userId=101&&merchantKey=101";
			HttpClient client = new DefaultHttpClient();
			HttpPost get = new HttpPost(url);
			/*List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
			urlParameters.add(new BasicNameValuePair("userId", "101"));
			urlParameters.add(new BasicNameValuePair("merchantKey", "101"));
			get.setEntity(new UrlEncodedFormEntity(urlParameters));*/
			HttpResponse response = client.execute(get);
			System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
