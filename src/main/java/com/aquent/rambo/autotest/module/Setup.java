package com.aquent.rambo.autotest.module;

import com.aquent.rambo.autotest.conf.DataProperties;
import com.aquent.rambo.autotest.util.RamboUtil;
import com.aquent.rambo.autotest.util.WebActionUtil;

public class Setup {
	
	private WebActionUtil wau;
	
	public Setup(WebActionUtil wau) {
		this.wau = wau;
	}
	
	// login
	public void loginAdmin() {
		
		wau.sendInput("login.field.username", DataProperties.getProperty("login.username.accountAdmin"));
		wau.sendInput("login.field.password", DataProperties.getProperty("login.password.accountAdmin"));
		wau.clickButton("login.button.login");
		wau.waitVisibility("login.text.success"); 
		wau.validateText("login.text.success", DataProperties.getProperty("login.expected.accountAdmin"));
	}
	
	// logout 
	public void logout() {
		wau.waitVisibility("login.link.logout");
		wau.waitClickable("login.link.logout");
		RamboUtil.pause(5000);
		wau.clickLink("login.link.logout"); 
		RamboUtil.pause(5000);
		wau.waitVisibility("logout.text.success");
		wau.validateText("logout.text.success", DataProperties.getProperty("login.expected.logout"));
	}
	
	// go to projects tab
	public void projectsTab() {
		

		wau.waitVisibility("main.tab.projects");
		wau.clickButton("main.tab.projects");
		if(wau.isDisplay("project.button.listView")==true)
		{
			System.out.println("correct");
			
		}else if(wau.isDisplay("project.button.calenderView")==true)
		{
			wau.waitClickable("project.button.calenderView");
			wau.clickButton("project.button.calenderView");
			wau.waitVisibility("project.button.menuListView");
			wau.clickButton("project.button.menuListView");
			wau.waitVisibility("project.button.listView");
		}else if(wau.isDisplay("project.button.ganntChartView")==true)
		{
			wau.waitClickable("project.button.ganntChartView");
			wau.clickButton("project.button.ganntChartView");
			wau.waitVisibility("project.button.menuListView");
			wau.clickButton("project.button.menuListView");
			wau.waitVisibility("project.button.listView");
		}
		wau.waitVisibility("project.list.grid");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.button.activeProject");
		wau.waitVisibility("project.button.listView");
		wau.waitVisibility("project.button.listViewExportButton");
		wau.waitVisibility("project.button.listViewRefreshButton");
		wau.waitVisibility("project.button.listViewSettingButton");
	}
	
	//go to dashboard tab
	//TODO - Move all left navigation tabs related code here from "Project_tab_navigation" class(similar to project tab), because we will need them for setup of all modules in future
	
	public void dashboardTab() {
		
		wau.clickTab("main.tab.dashboard");
		wau.waitVisibility("main.tab.dashboard");
		
		
	}
	
	public void campaignsTab() {
		
		//TODO
	}
	
	public void requestsTab() {
		
		//TODO
	}
	
	public void myWorkTab() {
		
		//TODO
	}
	
	public void reviewsTab() {
		
		//TODO
	}
	
	public void notesTab() {
		
		//TODO
	}
		
	public void clientsTab() {
		
		//TODO
	}
	
	public void librariesTab() {
		
		//TODO
	}
	
	public void usersTab() {
		
		//TODO
	}
	
	public void estimatesTab() {
		
		//TODO
	}
	
	public void reportsTab() {
		
		//TODO
	}
	
	public void accountTab() {
		
		//TODO
	}
	
	public void recycleBinTab() {
		
		//TODO
	}
}
