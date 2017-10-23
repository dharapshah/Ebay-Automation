package com.wbl.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtils {

	static Logger log = LogManager.getLogger(WebDriverUtils.class);
	
	
	// this is also known as pagefactory pattern
	public static WebDriver getdriver(String browser){
		
		WebDriver driver = null;
		log.info("In get driver method - browser:" + browser);
		
		try{
			
			
			switch(browser){
			
			case"Chrome":
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/resource/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
			case"Firefox":
			System.setProperty("webdriver.geckodriver.driver",System.getProperty("user.dir")+"/resource/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
				
			case"ie":
				break;
				
			case"htmlunit":
				break;
				
			case"safari":
				break;
				
			default:
			
			}		
			
		}catch(Exception e){
			log.error("There is an exception when creating webdriver object");
			log.error(e.getStackTrace());
			
		}
		
		return driver;
		
	}
		
}



/*

here input is webdriver and we r returning driver instead of void 
we will have this in try catch so that in case if there is an exception , will got to know 
add drivers
then method named beforeclass in base test... to inject the driver from here 
so creation of driver class is done .
every page has one page class and one test class corresponding to it. 
create classes named base page-base package, then home page-pages package and home page-test java test 
going forward we might have 100 page class in our app, so we will always require driver in order to find elements and all
so if we have written the same once to create and initialize driver , we can use in every page class. like here we create first base page and the homepage which extends commonpage.
findby is as per page factory method and always we need to initialize that by pagefactory.init otherwise test will not run.

 search result page test and then search result details page test
 create a text file - right click -new - text file as config.properties and mention stageurl, devurl, browser etc. so that we can get from that only.
 then create a class named configutilities 
 create interface named constants in utilities  - to add the resource folder path so that everytime we need not have to mention get property
 
add annotation before suit in base test and do the needfull.
 
 Now we will create testngxml file of all the test classes.for that create folder named test suites in resources.
 then select all test classes -right click-testng-convert to testng. this will create xml file in project.
 move that xml file to test suites folder. 
 
 now in home page test we created group, i.e means which test we need to run in which group .i.e (groups={"Smoke"})
go to testng.xml and add the froup in smoke test(because we will run smoke test)below test name
 <groups>
  <run>
  <include name= "Smoke">
  </include>
  </run>
  </groups>

When ever we create groups we always have to mention (alwaysRun=true) in base test(i.e before class, afterclass) otherwise test will not run.irrespective of group conbination it will be able to run
right click on tesng-xml to run the test cases.

data driven testing
go to maven repositories
copy jars apache poi xml to pom.xml
create folder in resource named any.. i used test-data and copy the excel file there.
create excelhelper class in utilities.

package com.wbl.utilities;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;// sheet class in apache poi obj2
import org.apache.poi.xssf.usermodel.XSSFWorkbook;// class in apache poi obj1


public class ExcelHelper {

	//static Logger log = LogManager.getLogger(ExcelHelper.class);
	
	public static Object[][] getExcelData(String fileName, String sheetName) {
		Object[][] data = null;
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(Constants.RESOURCE_PATH + "/Test-Data/"+ fileName); // here it is loading the file (filename) in workbook object XSSFWorkbook wb = null
			XSSFSheet sheet = wb.getSheet(sheetName);// then it is getting the sheet XSSFSheet 
			int rowsIndex = sheet.getLastRowNum();//return last row index-index starts from 0, once you get the sheet u will get no of rows using sheet.getLastRowNum();
			System.out.println("total rows:" + rowsIndex);
			data = new Object[rowsIndex][];
			
			for (int i = 1; i <= rowsIndex; i++) { // we dont want title (expected, actual, no, etc) to be iterated hence starting from index 1, i <= rowsIndex means end of index
				XSSFRow row = sheet.getRow(i);
				int cols = row.getLastCellNum();// returns no of columns- index start from 0, u will get no of rows using sheet.getLastCellNum();
				System.out.println("total cols:" + cols);
				Object[] colData = new Object[cols];
				for (int j = 0; j < cols; j++) {
					colData[j] = row.getCell(j).toString();
				}
				data[i-1]=colData;
			}

		} catch (IOException e) {
			System.out.println("ExcelHelper exception:"+e);
		} finally {
			try {
				wb.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}

		return data;

	}

}

LOGS:
levels: debug, info, warm,error,trace.

Dependencies to be added from maven... 1) log4j-api 2) log4j-core
create xml file ... right click on src/main/java (below ebay automation)  - new - other - write xml - click on xml - name it as log4j2 and copt this xml
XML will contains below details about logs....
where the log should be store
what kind of log you need - file or console log
level of log you need

<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="warn">
    <Properties>
        <Property name="basePath">C:/Users/WBL/MedhaJanWorkspace/JanAutomationFramework/logs</Property>
    </Properties>
 
 //where the log should be store and what kind of log you need - file or console log
    <Appenders>
        <RollingFile name="fileLogger" fileName="${basePath}/app-info.log" filePattern="${basePath}/app-info-%d{yyyy-MM-dd}.log">
            <PatternLayout>
                <pattern>[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n</pattern>
            </PatternLayout>
            <Policies>
                <TimeBasedTriggeringPolicy interval="1" modulate="true" />
            </Policies>
        </RollingFile>
        
 
        <Console name="console" target="SYSTEM_OUT">
            <PatternLayout   pattern="[%-5level] %d{yyyy-MM-dd HH:mm:ss.SSS} [%t] %c{1} - %msg%n" />
        </Console>
    </Appenders>
    
    //level of log you need
    <Loggers>
        <Root level="all" additivity="false">
            <appender-ref ref="console" level="all"  />
               <appender-ref ref="fileLogger" level="info" />
        </Root>
    </Loggers>
</Configuration>


in above loggers... console - all will show all levels and info will show only info and after levels
levels will be like - all, debug, info , warn, error, fatal
then import  below in excelhelper class
static Logger log = LogManager.getLogger(ExcelHelper.class);
there should not be any print statements.. we need to replace with log statements

waits



Loggerlistner utils
because we dont have to write every time log.info, log.error, log.warn,etc we create this seperate utility.
it extends TestListnerAdapter(parent class - taken from testng) and has inbuilt methods 
just creating the utility is not enought. we have to configure in testng.xml in resource-test suites(xml file)then onlt it will know that he has to call so and so method if testfailure, testpassed, etc
we can write whatever information we need to in the methods...below are basis statements..
Under suite we have tag called listeners  - configure listener class in that - name the class  - save it
now testng will understand that there is general class loggerlistener which we have written by extending testelistener adapter

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
<listeners>
<listener class-name="com.wbl.utilities.LoggerListener"></listener>
</listeners>
  <test name="SmokeTest">
   <groups>
  <run>
  <include name= "Smoke"> </include>
  </run>
  </groups>
    <classes>
      <class name="com.wbl.HomePageTest"/>
      <class name="com.wbl.SearchResultPageTest"/>
    </classes>
  </test> 
 </suite> 
 
  
  <!--<test name="RegressionTest">
    <classes>
      <class name="com.wbl.SearchResultsDetailsPageTest"/>
      <class name="com.wbl.HomePageTest"/>
      <class name="com.wbl.SearchResultPageTest"/>
    </classes>
  </test>--> 
  
  
  
  --------------------------------------------------------
  
  package com.wbl.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class LoggerListener extends TestListenerAdapter {


	
	Logger logger = LogManager.getLogger(LoggerListener.class);
	
		@Override
		public void onTestStart(ITestResult tr) {
			logger.info("Test Started....");
		}

		@Override
		public void onTestSuccess(ITestResult tr) {

			logger.info("Test '" + tr.getName() + "' PASSED");
			logger.info("Priority of this method is " + tr.getMethod().getPriority());
		}

		@Override
		public void onTestFailure(ITestResult tr) {
			logger.error("Test '" + tr.getName() + "' FAILED");
			logger.error("Priority of this method is " + tr.getMethod().getPriority());
		}

		@Override
		public void onTestSkipped(ITestResult tr) {
			logger.warn("Test '" + tr.getName() + "' SKIPPED");
		}


	} 

  reports are generate on your test results 
logs are to log any exception, errors or other details.

to check the reports...
go to test-output

*/