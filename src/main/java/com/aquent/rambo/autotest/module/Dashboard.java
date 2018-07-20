/**
 *
 * Copyright: Copyright (c) 2018 by AQUENT, L.L.C.
 * Company: AQUENT, L.L.C.
 *  
 * @created 2-May-2018
 * @version 1.0
 *
 */
package com.aquent.rambo.autotest.module;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aquent.rambo.autotest.conf.DataProperties;
import com.aquent.rambo.autotest.util.RamboUtil;
import com.aquent.rambo.autotest.util.WebActionUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

public class Dashboard
{
	private WebActionUtil wau;
	private ExtentReports extent;
	private Setup setup;
	WebDriver driver;
	public Dashboard(WebDriver driver, ExtentReports extent) {

		wau = new WebActionUtil(driver, extent.createTest("Dashboard Test"));
		setup = new Setup(wau);
		this.driver=driver;
	}

	//Run all tests for project as per the regression test plan
	public void runTest() {

		try {

			//login
			setup.loginAdmin();

			//go to Dashboard tab
			setup.dashboardTab();

			//test project list page
			dashboardModule();

			//logout
			setup.logout();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Dashboard test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	private void dashboardModule() {

		dashboardIconIsPresent();
		
		helpiconfunctionality();
		
		favorites();
		
		minimizeMaximizeMenuBar();
		// and so on (each action to be tested)

	}

	private void dashboardIconIsPresent()
	{
		wau.isPresent("dashboard.button.search");
		wau.isPresent("dashboard.button.favorite");
		wau.isPresent("dashboard.button.help");
		wau.isPresent("dashboard.button.logout");
		wau.isPresent("dashboard.button.refresh1");
		wau.isPresent("dashboard.button.setting");
		wau.validateImage("dashboard.image.logo");
	}

	private void helpiconfunctionality()
	{
		//online help
		wau.clickButton("dashboard.button.help");
		wau.waitVisibility("dashboard.field.onlineHelp");

		String parentWindow = driver.getWindowHandle();

		wau.clickLink("dashboard.field.onlineHelp");

		Set<String> handles = driver.getWindowHandles();

		for (String handle : handles) {

			driver.switchTo().window(handle);
		}
		driver.close();
		driver.switchTo().window(parentWindow);

		//inside Dashboard module contact RoboHead support

		wau.clickButton("dashboard.button.help");
		wau.waitVisibility("dashboard.link.contactSupportLink");
		wau.clickLink("dashboard.link.contactSupportLink");

		wau.switchToFrame("dashboard.form.frame");
		wau.waitVisibility("dashboard.field.userName");
		wau.clearAndWait("dashboard.field.userName");
		wau.sendInput("dashboard.field.userName", DataProperties.getProperty("dashboard.form.yourName"));
		wau.clearAndWait("dashboard.field.email");
		wau.sendInput("dashboard.field.email", DataProperties.getProperty("dashboard.form.yourName")+RamboUtil.randomNumber()+DataProperties.getProperty("dashboard.form.email"));
		wau.clearAndWait("dashboard.field.userHelp");
		wau.sendInput("dashboard.field.userHelp", DataProperties.getProperty("dashboard.form.help"));
		wau.clickTab("dashboard.field.attachement");
		StringSelection stringSelection = new StringSelection("logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		wau.uploadFileFromSystem();
		wau.waitVisibility("dashboard.button.send");
		
		String actual = wau.getElementText("dashboard.button.send");
		
		if(actual.contentEquals(DataProperties.getProperty("dashboard.form.sendButton")))
		{
			wau.waitClickable("dashboard.button.send");
			wau.waitVisibility("dashboard.field.messagePopup");
			wau.clickTab("dashboard.popup.closepopup");
		}else
		{
			wau.clickButton("dashboard.button.cancel");
		}
		wau.switchToDefaultFrame();
		
		// dashboard Submit Enhancement Suggestion

		wau.waitVisibility("dashboard.tab.enhancementSuggestion");
		wau.clickTab("dashboard.tab.enhancementSuggestion");
		wau.switchToFrame("dashboard.form.enhancementSuggestion");
		wau.waitVisibility("dashboard.form.enhancementSuggestion");
		wau.scrollDown(200);
		wau.waitVisibility("dashboard.field.yourName");
		wau.clickTab("dashboard.field.yourName");
		wau.sendInput("dashboard.field.yourName", DataProperties.getProperty("dashboard.form.yourName"));
		wau.clickTab("dashboard.field.phoneNumber");
		wau.sendInput("dashboard.field.phoneNumber", DataProperties.getProperty("dashboard.Form.phoneNo")+RamboUtil.randomNumber());
		wau.scrollDown(200);
		wau.waitVisibility("dashboard.field.yourMailid");
		wau.clickTab("dashboard.field.yourMailid");
		wau.sendInput("dashboard.field.yourMailid", DataProperties.getProperty("dashboard.form.yourName")+RamboUtil.randomNumber()+DataProperties.getProperty("dashboard.form.email"));
		wau.clickTab("dashboard.field.accountURL");
		wau.sendInput("dashboard.field.accountURL", DataProperties.getProperty("dashboard.form.accountURL"));
		wau.scrollDown(200);
		wau.clickTab("dashboard.field.jobTitle");
		wau.sendInput("dashboard.field.jobTitle", DataProperties.getProperty("dashboard.form.jobTitle"));
		wau.clickButton("dashboard.button.userType");
		wau.clickTab("dashboard.field.requestTitle");
		wau.sendInput("dashboard.field.requestTitle", DataProperties.getProperty("dashboard.form.requestTitle"));
		wau.clickTab("dashboard.tab.chooseModule");
		wau.waitVisibility("dashboard.tab.dropdownList");
		wau.waitVisibility("dashboard.tab.dashboard");
		wau.waitClickable("dashboard.tab.dashboard");
		wau.scrollDown(300);
		wau.clickTab("dashboard.field.feature");
		wau.sendInput("dashboard.field.feature", DataProperties.getProperty("dashboard.form.feature"));
		wau.clickTab("dashboard.field.objective");
		wau.sendInput("dashboard.field.objective", DataProperties.getProperty("dashboard.form.objective"));
		wau.waitClickable("dashboard.button.submit");
		wau.waitVisibility("dashboard.button.closeForm");
		wau.clickButton("dashboard.button.closeForm");
	}
	
	private void favorites()
	{
		wau.waitClickable("dashboard.button.favorite");
		wau.waitVisibility("dashboard.form.favoriteList");
		wau.isDisplay("dashboard.form.favoriteList");
		
		
	}
	
	private void minimizeMaximizeMenuBar()
	{
		wau.scrollDown(250);
		wau.waitVisibility("dashboard.tab.collapseOrExpand");
		wau.clickTab("dashboard.tab.collapseOrExpand");
		wau.waitClickable("dashboard.tab.collapseOrExpand");
	}
}













