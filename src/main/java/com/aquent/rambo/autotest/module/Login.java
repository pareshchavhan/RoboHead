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

import com.aquent.rambo.autotest.conf.DataProperties;
import com.aquent.rambo.autotest.util.RamboUtil;
import com.aquent.rambo.autotest.util.WebActionUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class Login {
	
	public WebActionUtil wau;
	public ExtentReports extent;
	private Setup setup;
	WebDriver driver;
	
	public Login(WebDriver driver, ExtentReports extent) {
		this.extent=extent;
		
		wau = new WebActionUtil(driver, extent.createTest("Login Test"));
		setup = new Setup(wau);
	}
	
	// Run all tests for login as per the regression test plan
	public void runTest() {
		
		try {

			links();
			
			invalidInputs();
			
			blankInputs();
			
			threeWrongAttempts();
			
			//other test cases
			
			
			//success login
			setup.loginAdmin();
			
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
	
	private void links() {
		
		wau.waitVisibility("login.link.contactSupport");
		wau.waitClickable("login.link.contactSupport");
		//RamboUtil.pause(5000);
		wau.clickLink("login.link.contactSupport");
		wau.switchToFrame("login.form.contactRoboHeadSupport");
		wau.waitVisibility("login.link.contactsuport.success"); 
		wau.waitVisibility("login.button.contactsupport.cancel");
		wau.clickButton("login.button.contactsupport.cancel");
		wau.switchToDefaultFrame();
		wau.refreshPage();
		wau.waitVisibility("login.link.help");
		wau.waitClickable("login.link.help");
		RamboUtil.pause(2000);
		wau.clickLink("login.link.help");
		wau.switchToFrame("login.form.contactRoboHeadSupport");
		wau.waitVisibility("login.link.contactsuport.success");
		wau.waitClickable("login.link.contactsuport.success");
		wau.waitVisibility("login.button.contactsupport.cancel");
		wau.clickButton("login.button.contactsupport.cancel");
		wau.switchToDefaultFrame();
		wau.validateImage("login.image.logo");	
		wau.isPresent("login.link.createAccount");
		wau.clickLink("login.link.createAccount");
		wau.waitVisibility("login.button.createAccount.cancel");
		wau.clickButton("login.button.createAccount.cancel");
		wau.clickButton("login.link.forgotPassword");
		wau.waitVisibility("login.button.forgorPassword.cancel");
		wau.clickButton("login.button.forgorPassword.cancel");
	}
	
	private void invalidInputs() {
		
		wau.sendInput("login.field.username", "invalidUser@test.com");
		wau.sendInput("login.field.password", "invalidPass");
		wau.clickButton("login.button.login");			
		wau.waitVisibility("login.text.invalidLogin");
		
	}
	
	private void blankInputs() {

		wau.sendInput("login.field.username", "");
		wau.sendInput("login.field.password", "");
		wau.clickButton("login.button.login");			
		wau.waitVisibility("login.text.blankEntry");
		wau.validateText("login.text.blankEntry", DataProperties.getProperty("login.expected.blankCreadentialErrorMsg"));
	}
	
	private void threeWrongAttempts() {
		
		for (int i=1; i<=1; i++) {
			
			wau.clearAndWait("login.field.username");
			wau.sendInput("login.field.username", "invalidUser@test.com");
			wau.clearAndWait("login.field.password");
			wau.sendInput("login.field.password", "invalidPass");
			wau.clickButton("login.button.login");			
			wau.waitVisibility("login.text.invalidLogin");
		}
		wau.waitVisibility("login.text.invalidLogin");
		wau.validateText("login.text.invalidLogin", DataProperties.getProperty("login.expected.invalidCredencialerrMsg"));
	}
}
