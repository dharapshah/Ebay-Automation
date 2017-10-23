package com.wbl.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ConfigUtils {

	public static final Properties prop = new Properties();// final if you dont want anyone to change it
		
	static Logger log = LogManager.getLogger(ConfigUtils.class);
	
	public ConfigUtils(String filename){
		
		try {
			
			prop.load(new FileInputStream(filename));// one we write this, it will give us try and catch block
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
	
	public String getProperty(String key){
		return prop.getProperty(key);
	}
	
}
