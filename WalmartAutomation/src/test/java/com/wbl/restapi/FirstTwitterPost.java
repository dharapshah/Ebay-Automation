package com.wbl.restapi;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.wbl.base.BaseApiTest;

import junit.framework.Assert;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;

public class FirstTwitterPost extends BaseApiTest {
	
	private static final String resource = "/1.1/account/update_profile.json";

	@Test
	public void twitterapitest(){
		
				
		HttpPost post = post(resource);


		try {
			
			JSONObject reobj = new JSONObject();
			reobj.put("name", "pranav");
			reobj.put("description", "test");
			String req = reobj.toString();
			System.out.print(req);
			post.setEntity(new StringEntity(req));
			
			
			
			HttpResponse response = client.execute(post);
			System.out.println(response.getStatusLine().getStatusCode());
			
			String responsestring  = IOUtils.toString(response.getEntity().getContent(),"UTF-8");
			System.out.println("response:"+ responsestring);
			//Assert.assertEquals(200, response.getStatusLine().getStatusCode());
			
			JSONObject json = new JSONObject(responsestring);
			Assert.assertNotNull(json.getInt("id"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
