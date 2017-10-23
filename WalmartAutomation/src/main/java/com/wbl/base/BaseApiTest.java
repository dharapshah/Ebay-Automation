package com.wbl.base;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.wbl.utilities.ConfigUtils;
import com.wbl.utilities.Constants;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;


public class BaseApiTest {

	
	protected static String endpoint;
	protected static OAuthConsumer consumer;
	static Logger log = LogManager.getLogger(BaseApiTest.class);
	protected HttpClient client = HttpClientBuilder.create().build();
	
	@BeforeSuite
	public void beforesuite(){
		ConfigUtils configutils = new ConfigUtils(Constants.RESOURCE_PROPERTIES_PATH +"Configapi.properties");
		
		endpoint = configutils.getProperty("qaurl");
		
        consumer = new CommonsHttpOAuthConsumer(configutils.getProperty("consumerkey")
        		, configutils.getProperty("consumersecret"));
		
		consumer.setTokenWithSecret(configutils.getProperty("token"), configutils.getProperty("tokensecret"));
		
		
	}
	
	public HttpGet get(String resource){
		HttpGet get = new HttpGet(endpoint + resource);
		try {
			consumer.sign(get);
		} catch (Exception e) {
			log.error("exception in get....");
			log.error(e.getMessage());
		}
		return get;
		
		
	}
	
	public HttpPost post(String resource){
		HttpPost post = new HttpPost(endpoint + resource);
		try {
			consumer.sign(post);
		} catch (Exception e) {
			log.error("exception in post....");
			log.error(e.getMessage());
		}
		return post;
		
		
	}
	
	public HttpPut put(String resource){
		HttpPut put = new HttpPut(endpoint + resource);
		try {
			consumer.sign(put);
		} catch (Exception e) {
			log.error("exception in put....");
			log.error(e.getMessage());
		}
		return put;
		
		
	}
	
	public HttpDelete delete(String resource){
		HttpDelete delete = new HttpDelete(endpoint + resource);
		try {
			consumer.sign(delete);
		} catch (Exception e) {
			log.error("exception in delete....");
			log.error(e.getMessage());
		}
		return delete;
	}
}



/*
Go to new and create new maven project 
Add jars - testng and apache http client , apache commons io , json in java, signpost core(aouth) and Signpost Commonshttp4  from maven dependencies...remove junit if already present
fyi - twitter will not work without authentication and hence we are adding aouth jar and Signpost Commonshttp4
Create BASE API class in base folder and test classes in test package
Creat configapi.properties in resource - properties - folder
devurl:https://dev.api.twitter.com
qaurl:https://api.twitter.com
stageurl:https://stage.api.twitter.com
consumerkey:fC0CMs1a9i9oINsZxdGf0t9YY
consumersecret:RusixSbiqjukrUTBONTd6feDKXdAsjGR9Blqx9g43r4ME8ePZX
token:897005333217853440-LwOrSFcTHm4Pr1kAShaSF9vJDGGreDu
tokensecret:0rDS97cBUuLG4CZvxkQBUe1grMnJtGH9T3yBJUydYN7MK
gatewayid:12345 (random)
publisherid:678910(random)

Base Class includes:
GET, POST, PUT, DELETE Methods



 

 
 
 
 */
