/**
 *
 * Copyright: Copyright (c) 2018 by AQUENT, L.L.C.
 * Company: AQUENT, L.L.C.
 *  
 * @created 17-April-2018
 * @version 1.0
 *
 */
package com.aquent.rambo.autotest.module;

import org.openqa.selenium.WebDriver;

import com.aquent.rambo.autotest.util.WebActionUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class Home {
	
	public WebActionUtil wau;
	public ExtentReports extent;
	private Setup setup;
	
	public Home(WebDriver driver, ExtentReports extent) {
		
		wau = new WebActionUtil(driver, extent.createTest("Login Test"));
		setup = new Setup(wau);
	}
	
	// Run all tests for login as per the regression test plan
	public void runTest() {
		
		try {			
			//success login
			setup.loginAdmin();
			
			tabs();
		
			setup.logout();			
		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Login test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}
	
	// test all left navigation 
	private void tabs() {
		
		setup.dashboardTab();
		
		setup.campaignsTab();
		
		setup.requestsTab();
		
		setup.myWorkTab();
		
		setup.reviewsTab();
		
		setup.notesTab();
		
		setup.clientsTab();
		
		setup.librariesTab();
		
		setup.usersTab();
		
		setup.estimatesTab();
		
		setup.reportsTab();
		
		setup.accountTab();
		
		setup.recycleBinTab();
	}
	
	//test all buttons/links in header 
	
		
}
