package com.wbl.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.wbl.utilities.ConfigUtils;
import com.wbl.utilities.Constants;
import com.wbl.utilities.ScreenShots;
import com.wbl.utilities.WebDriverUtils;

public class BaseTest {

	protected static WebDriver driver;
	protected static String url;
	protected static String browser;
	
	static Logger log = LogManager.getLogger(BaseTest.class);
	
	@BeforeSuite(alwaysRun=true)
	public void beforesuit(){
		ConfigUtils configutils = new ConfigUtils(Constants.RESOURCE_PROPERTIES_PATH +"Config.properties");
				url = configutils.getProperty("stageUrl");		
		        browser = configutils.getProperty("browser");
		        System.out.println(url);
		        System.out.println(browser);
		
	}
	
	/*@BeforeTest(alwaysRun=true)
	public void beforetest(){
		System.out.println("Test executionstarts");
		
	}*/
	
	
	@BeforeMethod(alwaysRun=true)
	public void beforemethod(){
		driver = WebDriverUtils.getdriver(browser);// this will go to getdriver method in webdriverutils and match the browser name chrome and give us chromedriver
		driver.get(url);
		driver.manage().window().maximize();

		
	}
	
	/*@AfterMethod(alwaysRun=true)
	public void aftermethod(ITestResult rs){
		log.info("rs test case name after method:"+ rs.getName());
		if (ITestResult.FAILURE==rs.getStatus()){
			ScreenShots.takeScreenShot(rs.getName(), driver);
		}
		driver.quit();
		
	}*/
	
}


