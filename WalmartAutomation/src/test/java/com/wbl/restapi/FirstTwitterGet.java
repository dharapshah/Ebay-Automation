package com.wbl.restapi;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.wbl.base.BaseApiTest;

import junit.framework.Assert;

public class FirstTwitterGet extends BaseApiTest{

	private static final String resource = "/1.1/account/settings.json";
	
	@Test
	public void testapi(){
		
		
		//HttpGet get = new HttpGet("https://api.twitter.com/1.1/account/settings.json");kept just to show how we derived execute.get
			
		try {
		HttpResponse response = client.execute(get(resource));
		
		System.out.println("response status:" + response.getStatusLine().getStatusCode());
		
		System.out.println("response status2:" + response.getStatusLine());
		
		String responsestring  = IOUtils.toString(response.getEntity().getContent(),"UTF-8");
		
		System.out.println("response:"+ responsestring);
		
		
	   Assert.assertEquals(200, response.getStatusLine().getStatusCode());//expected 200, actual
		
		
		
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		
	}
}










/*
 - Go to new and create new maven project 
 add jars - testng and apache http client , apache commons io , json in java, signpost core(aouth) and Signpost Commonshttp4  from maven dependencies...remove junit if already present
fyi - twitter will not work without authentication and hence we are adding aouth jar and Signpost Commonshttp4
 create new class in test/jav 



 */
