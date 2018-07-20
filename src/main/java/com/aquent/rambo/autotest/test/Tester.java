/**
 *
 * Copyright: Copyright (c) 2018 by AQUENT, L.L.C.
 * Company: AQUENT, L.L.C.
 *  
 * @created 18-April-2018
 * @version 1.0
 *
 */
package com.aquent.rambo.autotest.test;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aquent.rambo.autotest.conf.DataProperties;
import com.aquent.rambo.autotest.module.Login;
import com.aquent.rambo.autotest.module.Project;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class Tester {

	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	public ATUTestRecorder recorder;

	private String URL= DataProperties.getProperty("test.url");
	
	  public static final String USERNAME = "pareshprakashcha1";
	  public static final String AUTOMATE_KEY = "6zYHyDaMsL1CrzCMhyYL";
	  public static final String URL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


	@BeforeSuite
	public void beforeSuite() throws ATUTestRecorderException
	{
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder("Resources/Videos/","TestVideo1-"+dateFormat.format(date),false);

		recorder.start(); 
		
		htmlReporter = new ExtentHtmlReporter("RoboHead.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("OS", "win7");
		extent.setSystemInfo("Host Name", "Autotest server");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User Name", "Paresh Chavhan");

		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("AutomationTesting.in RoboHead-Demo Report ");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.setAppendExisting(true);
	}
	@Parameters("browser")
	@BeforeMethod
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{		
			System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			
			
			//this code related to browser stack
			
			/*DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "67.0");
		    caps.setCapability("os", "OS X");
		    caps.setCapability("os_version", "El Capitan");
		    caps.setCapability("resolution", "1024x768");

		    try {
			
		    	driver = new RemoteWebDriver(new java.net.URL(URL1), caps);
			    
			} catch (Exception e) {
				
			}*/
		    
			
			//this code related to grid
			/*DesiredCapabilities dr = new DesiredCapabilities();
			dr.setBrowserName("chrome");
			dr.setPlatform(Platform.WINDOWS);*/
			/*try {
			 driver = new RemoteWebDriver(new java.net.URL("http://192.168.0.3:4444/wd/hub"),dr);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Resources/geckodriver.exe");
			driver = new FirefoxDriver();			
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "Resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("Safari"))
		{
			
		}
		
		
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	@Test
	public void testAll() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		
		testLogin();	
		testProject();
				
		// more module testing
		
	}
	
	@Test
	public void testLogin() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		Login login = new Login(driver, extent);
		login.runTest();
	}
	
	@Test
	public void testProject() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Project Test";
		Project project = new Project(driver, extent,name);
		project.runTest();
	}
	
	@Test
	public void testCreateProject() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Create Project";
		Project project = new Project(driver, extent,name);
		project.runTestCreateProject();
	}
	
	@Test
	public void testCalenderView() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "verify CalenderView";
		Project project = new Project(driver, extent,name);
		project.runCalenderView();
	}
	
	@Test
	public void testModifyProject() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Modify Project";
		Project project = new Project(driver, extent,name);
		project.runModifyProject();
	}
	
	@Test
	public void testCopyProject() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Copy Project";
		Project project = new Project(driver, extent,name);
		project.runCopyProject();
	}
	
	@Test
	public void testCopyProjectWithRadioButtons() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Copy Project With Radio Buttons";
		Project project = new Project(driver, extent,name);
		project.runCopyProjectWithRadioButtons();
		
	}
	
	@Test
	public void testCopyProjectResorcesRadioButtonAndSaveAsDraft() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Copy Project With Radio Buttons";
		Project project = new Project(driver, extent,name);
		project.runCopyProjectResourcesRadioButtonAndSaveAsDraft();
		
	}
	
	@Test
	public void testCopyProjectTemplate() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Copy Project With Template";
		Project project = new Project(driver, extent,name);
		project.runCopyProjectTemplate();
		
	}
	
	@Test
	public void testAddToCampaignArchiveAndFavorite() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Add To Campaign,Archive,Favorite";
		Project project = new Project(driver, extent,name);
		project.runAddToCampaignArchiveAndAddTofavorite();
		
	}
	
	@Test
	public void testAddNote() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Add Note";
		Project project = new Project(driver, extent,name);
		project.runAddNote();
		
	}
	
	@Test
	public void testManageNote() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Manage Note";
		Project project = new Project(driver, extent,name);
		project.runManageNote();
		
	}
	
	@Test
	public void testTaskFunctionality() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Task Functionality";
		Project project = new Project(driver, extent,name);
		project.runTaskFunctionality();
		
	}
	
	@Test
	public void testRevieFunctionality() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Review Functionality";
		Project project = new Project(driver, extent,name);
		project.runReviewFunctionality();
		
	}
	
	@Test
	public void testFilterByFunctionality() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Filter By";
		Project project = new Project(driver, extent,name);
		project.runFilterBy();
		
	}

	@Test
	public void testReviewTabFunctionality() throws InterruptedException, AWTException, FileNotFoundException, IOException
	{
		String name = "Review Tab";
		Project project = new Project(driver, extent,name);
		project.runReviewTab();
		
	}
	
	@AfterMethod
	public void close()
	{
		driver.close();
	}
	
	@AfterSuite
	public void closeSuite()
	{
		extent.flush();
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			
			e.printStackTrace();
		}
	}
}
