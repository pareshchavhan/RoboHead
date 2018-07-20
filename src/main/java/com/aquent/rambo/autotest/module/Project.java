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

import static org.testng.Assert.assertEquals;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.aquent.rambo.autotest.conf.DataProperties;
import com.aquent.rambo.autotest.util.RamboUtil;
import com.aquent.rambo.autotest.util.WebActionUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;


public class Project {

	private WebActionUtil wau;
	private ExtentReports extent;
	private Setup setup;


	public Project(WebDriver driver, ExtentReports extent,String name) {
		this.extent=extent;
		wau = new WebActionUtil(driver, extent.createTest("Project Test " +name));
		setup = new Setup(wau);
	}

	// Run all tests for project as per the regression test plan
	public void runTest() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			//test project list page
			projectModule();


		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Project test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runTestCreateProject() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			//test project list page

			createProjectWithCancel();
			createProjetcWithoutMandatoryFields();
			createProjectWithDateValidation();
			createProjetcWithValidData();
			createProjectSaveAsDraftWitoutProjectName();
			createProjectSaveAsDraft();
			createProjectTemplateCancel();
			createProjectTemplateWithoutMandatoryfield();
			createProjectTemplateDateValidation();
			

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Create Project test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runCalenderView() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			verifyCalenderView();
			projectPaging();
			viewProject();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Calender View test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runModifyProject() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			modifyProjectWithCancel();
			modifyProjectWithOutMandatoryField();
			modifyProjectWithDateValidation();
			modifyProjectWithValidData();
			setProjectStatusAsInprogress();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Modify Project test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runCopyProject() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			copyAsNewProjectWithCancel();
			copyAsNewProjectWitoutMandatoryFields();
			copyAsNewProjectWithDateValidation();
			copyAsNewProjectWithValidData();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Copy Project test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runCopyProjectWithRadioButtons() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			copyAsNewProjectWithCheckTaskAndReviewCheckBox();
			//copyAsNewProjectWithCheckTaskCheckBox();//failed to add project
			copyAsNewProjectWithCheckReviewCheckBox();
			copyAsNewProjectWithUncheckBudgetedExpenses();
			copyAsNewProjectWithUncheckTeam();
			copyAsNewProjectWithUncheckFiles();
			copyAsNewProjectWithUncheckTags();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Copy Project with radio buttons test");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runCopyProjectResourcesRadioButtonAndSaveAsDraft() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			verifyCheckResource();
			verifyProjectSheduleTaskBasedOnStartDate();
			verifyProjectSheduleSetTaskDatesManually();
			copyAsNewProjectWithSaveAsDraft();


		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Copy Project with Resources radio button and save as draft");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runCopyProjectTemplate() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			copyAsNewTemplateWithCancel();
			copyAsNewTemplateWithOutMadatoryField();
			copyAsNewTemplateWithDateValidation();
			copyAsNewTemplateWithValidData();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Copy Project Template");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runAddToCampaignArchiveAndAddTofavorite() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			addToCampaignWithCancel();
			addToCampaignWithValidInput();
			projectFavorites();
			archiveProject();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Add To Campaign,Archive,Favorite");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runAddNote() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			addNote();


		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Add Note");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runManageNote() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			manageNotes();
			getLink();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Add To Manage note");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runTaskFunctionality() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			createTask();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Add To Campaign,Archive,Favorite");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runReviewFunctionality() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			projectReview();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Add To Campaign,Archive,Favorite");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}	

	public void runFilterBy() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			projectFilterByFunctionality();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Add To Campaign,Archive,Favorite");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}

	public void runReviewTab() {

		try {

			//login
			setup.loginAdmin();

			//go to Projects tab
			setup.projectsTab();

			review();

		}
		catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Failed to run Add To Campaign,Archive,Favorite");
			e.printStackTrace();
		}
		finally {
			extent.flush();
		}
	}
	
	private void preCondition()
	{
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
	}

	private void projectModule() {

		createProject();

		verifyCalenderView();

		projectPaging();

		viewProject();

		modifyProject();

		copyProject();

		addToCampaign();

		projectFavorites();

		archiveProject();

		addNote();

		manageNotes();

		getLink();

		projectSummary();

		createTask();

		projectReview();

		projectFilterByFunctionality();

		review();

		// and so on (each action to be tested)

	}

	// create project test cases
	private void createProject() {

		createProjectWithCancel();

		createProjetcWithoutMandatoryFields();

		createProjectWithDateValidation();

		createProjetcWithValidData();

		createProjectSaveAsDraftWitoutProjectName();

		createProjectSaveAsDraft();

		createProjectTemplateCancel();

		createProjectTemplateWithoutMandatoryfield();

		createProjectTemplateDateValidation();
	}

	// modify project test cases
	private void modifyProject() {

		modifyProjectWithCancel();

		modifyProjectWithOutMandatoryField();

		modifyProjectWithDateValidation();

		modifyProjectWithValidData();

		setProjectStatusAsInprogress();
	}

	// copy project test cases
	private void copyProject() {

		copyAsNewProjectWithCancel();

		copyAsNewProjectWitoutMandatoryFields();

		copyAsNewProjectWithDateValidation();

		copyAsNewProjectWithValidData();

		copyAsNewProjectWithCheckTaskAndReviewCheckBox();

		//copyAsNewProjectWithCheckTaskCheckBox();//failed to add project in automation

		copyAsNewProjectWithCheckReviewCheckBox();

		copyAsNewProjectWithUncheckBudgetedExpenses();

		copyAsNewProjectWithUncheckTeam();

		copyAsNewProjectWithUncheckFiles();

		copyAsNewProjectWithUncheckTags();

		copyAsNewProjectValidateResourceRadioButton();

		copyAsNewProjectWithSaveAsDraft();

		copyAsNewTemplate();
	}

	private void addToCampaign()
	{
		addToCampaignWithCancel();

		addToCampaignWithValidInput();
	}

	private void createProjectWithCancel()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_05  Create project with cancel");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.isPresent("project.button.newProject");
			wau.isPresent("project.button.activeProject");
			wau.isPresent("project.button.listView");
			wau.isPresent("project.button.export");
			wau.isPresent("project.button.refresh");
			wau.isPresent("project.button.setting");
			wau.waitVisibility("project.button.filterBy");
			wau.isPresent("project.button.filterBy");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.isPresent("project.button.menu.newProject");
			wau.waitClickable("project.button.menu.newProject");
			wau.clickButton("project.button.menu.newProject");
			wau.waitVisibility("project.button.create.save");
			wau.isPresent("project.button.create.save");
			wau.isPresent("project.button.create.saveAsDraft");
			wau.isPresent("project.button.create.cancel");
			//wau.clearAndWait("project.field.create.projectName");
			wau.sendInput("project.field.create.projectName", DataProperties.getProperty("project.create.projectName"));
			wau.clickTab("project.field.projectTimeApprover");
			wau.sendInput("project.field.projectTimeApprover", DataProperties.getProperty("project.create.projectTimeApprover"));
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clickTab("project.field.billingType");
			wau.sendInput("project.field.billingType", DataProperties.getProperty("project.create.billingType"));
			wau.clickTab("project.field.billingStatus");
			wau.sendInput("project.field.billingStatus", DataProperties.getProperty("project.create.billingStatus"));
			wau.clickTab("project.field.dueDate");
			wau.sendInput("project.field.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.button.create.cancel");
			wau.waitClickable("project.button.yes");
			wau.clickButton("project.button.yes");
			wau.waitVisibility("main.tab.projects");
			wau.getLogger().log(Status.PASS, "Verify create with cancel project successfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create with cancel project successfully");
			e.printStackTrace();
		}
		
	}

	private void createProjetcWithoutMandatoryFields()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  Create project without mandatory field");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.isPresent("project.button.menu.newProject");
			wau.waitClickable("project.button.menu.newProject");
			wau.clickButton("project.button.menu.newProject");
			wau.isPresent("project.button.create.save");
			wau.waitVisibility("project.button.create.save");
			wau.sendInput("project.field.create.projectName", DataProperties.getProperty("project.create.projectName"));
			wau.waitClickable("project.button.create.save");
			wau.clickButton("project.button.create.save");
			wau.waitVisibility("project.alertBox.mandatoryField");
			wau.isDisplay("project.alertBox.mandatoryField");
			wau.isPresent("project.button.alertmsg.ok");
			wau.isDisplay("project.text.alertmsg");
			wau.waitVisibility("project.text.alertmsg");
			wau.clickButton("project.button.alertmsg.ok");
			wau.clickButton("project.button.create.cancel");
			wau.clickButton("project.button.yesbutton");
			wau.getLogger().log(Status.PASS, "Verify create project without mandatory field successfully");
			wau.waitVisibility("main.tab.projects");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create project without mandatory field ");
			e.printStackTrace();
		}
		
	}

	private void createProjectWithDateValidation()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_22  Create project with date validation");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.isPresent("project.button.menu.newProject");
			wau.waitClickable("project.button.menu.newProject");
			wau.clickButton("project.button.menu.newProject");
			//wau.clearAndWait("project.field.create.projectName");
			wau.sendInput("project.field.create.projectName", DataProperties.getProperty("project.create.projectName"));
			wau.sendInput("project.field.create.description", DataProperties.getProperty("project.create.projectDescription"));
			wau.clickTab("project.field.create.projectType");
			wau.sendInput("project.field.create.projectType", DataProperties.getProperty("project.create.projectType"));
			wau.pressEnter();
			wau.clickButton("project.field.create.projectDocument");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.text.uploadComplete");
			wau.sendInput("project.field.marketingObjective", DataProperties.getProperty("project.create.projectMarketingObjective"));
			wau.sendInput("project.field.targetAudiance", DataProperties.getProperty("project.create.projectTargetAudiance"));
			wau.clickTab("project.field.projectStatus");
			wau.sendInput("project.field.projectStatus", DataProperties.getProperty("project.create.projectStatus"));
			wau.clickTab("project.field.projectTimeApprover");
			wau.sendInput("project.field.projectTimeApprover", DataProperties.getProperty("project.create.projectTimeApprover"));
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clickTab("project.field.billingType");
			wau.sendInput("project.field.billingType", DataProperties.getProperty("project.create.billingType"));
			wau.clickTab("project.field.billingStatus");
			wau.sendInput("project.field.billingStatus", DataProperties.getProperty("project.create.billingStatus"));
			wau.sendInput("project.field.dueDate", RamboUtil.previousDate());
			wau.clickTab("project.field.typeOfMailer");
			wau.sendInput("project.field.typeOfMailer", DataProperties.getProperty("project.create.typeOfMailer"));
			wau.sendInput("project.field.sizeOfDirectmail", DataProperties.getProperty("project.create.sizeOfDirectMail"));
			wau.sendInput("project.field.colorOfDirectMail", DataProperties.getProperty("project.create.colorsOfDirectMail"));
			wau.sendInput("project.field.quantityOfDirectMail", DataProperties.getProperty("project.create.quantityOfDirectMail"));
			wau.waitClickable("project.field.paperStock.matte");
			wau.clickButton("project.field.paperStock.matte");
			wau.sendInput("project.field.mailDropDate", RamboUtil.EndDates());
			wau.waitClickable("project.button.save");
			wau.clickButton("project.button.save");
			wau.waitVisibility("project.alertBox.invalidDate");
			wau.isDisplay("project.alertBox.invalidDate");
			wau.isDisplay("project.text.dateAlertMsg");
			wau.isPresent("project.button.dateAlertMsg.ok");
			wau.validateText("project.text.dateAlertMsg", DataProperties.getProperty("project.create.dateAlertMsg"));
			wau.clickButton("project.button.dateAlertMsg.ok");
			wau.clickButton("project.button.create.cancel");
			wau.waitVisibility("project.button.yesbutton");
			wau.clickButton("project.button.yesbutton");
			wau.getLogger().log(Status.PASS, "Verify create project with date validation successfully");
			wau.waitVisibility("main.tab.projects");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create project with date validation successfully");
			e.printStackTrace();
		}
		


	}

	private void createProjetcWithValidData()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_04  Create project with valid data");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.isPresent("project.button.menu.newProject");
			wau.waitClickable("project.button.menu.newProject");
			wau.clickButton("project.button.menu.newProject");
			//wau.clearAndWait("project.field.create.projectName");
			wau.sendInput("project.field.create.projectName", DataProperties.getProperty("project.create.projectName"));
			wau.sendInput("project.field.create.description", DataProperties.getProperty("project.create.projectDescription"));
			wau.clickTab("project.field.create.projectType");
			wau.sendInput("project.field.create.projectType", DataProperties.getProperty("project.create.projectType"));
			wau.sendInput("project.field.create.projectType", Keys.ENTER);
			wau.clickButton("project.field.create.projectDocument");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.text.uploadComplete");
			wau.sendInput("project.field.marketingObjective", DataProperties.getProperty("project.create.projectMarketingObjective"));
			wau.sendInput("project.field.targetAudiance", DataProperties.getProperty("project.create.projectTargetAudiance"));
			wau.clickTab("project.field.projectStatus");
			wau.sendInput("project.field.projectStatus", DataProperties.getProperty("project.create.projectStatus"));
			wau.clickTab("project.field.projectTimeApprover");
			wau.sendInput("project.field.projectTimeApprover", DataProperties.getProperty("project.create.projectTimeApprover"));
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clickTab("project.field.billingType");
			wau.sendInput("project.field.billingType", DataProperties.getProperty("project.create.billingType"));
			wau.clickTab("project.field.billingStatus");
			wau.sendInput("project.field.billingStatus", DataProperties.getProperty("project.create.billingStatus"));
			wau.sendInput("project.field.dueDate", RamboUtil.EndDates());
			wau.clickTab("project.field.typeOfMailer");
			wau.sendInput("project.field.typeOfMailer", DataProperties.getProperty("project.create.typeOfMailer"));
			wau.sendInput("project.field.sizeOfDirectmail", DataProperties.getProperty("project.create.sizeOfDirectMail"));
			wau.sendInput("project.field.colorOfDirectMail", DataProperties.getProperty("project.create.colorsOfDirectMail"));
			wau.sendInput("project.field.quantityOfDirectMail", DataProperties.getProperty("project.create.quantityOfDirectMail"));
			wau.waitClickable("project.field.paperStock.matte");
			wau.clickButton("project.field.paperStock.matte");
			wau.sendInput("project.field.mailDropDate", RamboUtil.EndDates());
			wau.waitClickable("project.button.save");
			wau.clickButton("project.button.save");
			wau.implicitWait(20);
			wau.clickButton("project.tab.create.tasks");
			wau.waitVisibility("project.button.create.newTask");
			wau.clickTab("main.tab.projects");
			wau.getLogger().log(Status.PASS, "Verify create project with valid data sucessfully");
			deleteProject();
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create project with valid data");
			e.printStackTrace();
		}
		
	}

	private void createProjectSaveAsDraftWitoutProjectName()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  Create project save as draft without project name");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.isPresent("project.button.menu.newProject");
			wau.waitClickable("project.button.menu.newProject");
			wau.clickButton("project.button.menu.newProject");
			wau.waitVisibility("project.button.saveAsDraft");
			RamboUtil.pause(500);
			wau.clickButtonByJS("project.button.saveAsDraft");
			wau.isDisplay("project.saveAsDraft.alertBox.mandatoryProjectName");
			wau.isDisplay("project.saveAsDraft.text.alertMsg");
			wau.isPresent("project.saveAsDraft.button.ok");
			wau.validateText("project.saveAsDraft.text.alertMsg", DataProperties.getProperty("project.saveAsDraft.errorMsg"));
			wau.clickButton("project.saveAsDraft.button.ok");
			wau.clickButton("project.button.create.cancel");
			wau.clickButton("project.button.yesbutton");
			wau.waitVisibility("main.tab.projects");
			wau.getLogger().log(Status.PASS, "Verify create project save as draft without project name successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create project save as draft without project name");
			e.printStackTrace();
		}
		
	}

	private void createProjectSaveAsDraft()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_26  Create project save as draft");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.isPresent("project.button.menu.newProject");
			wau.waitClickable("project.button.menu.newProject");
			wau.clickButton("project.button.menu.newProject");
			//wau.clearAndWait("project.field.create.projectName");
			wau.sendInput("project.field.create.projectName", DataProperties.getProperty("project.create.saveAsDraft.projectName"));
			wau.sendInput("project.field.create.description", DataProperties.getProperty("project.create.projectDescription"));
			wau.clickTab("project.field.create.projectType");
			wau.sendInput("project.field.create.projectType", DataProperties.getProperty("project.create.projectType"));
			wau.sendInput("project.field.create.projectType", Keys.ENTER);
			wau.clickButton("project.field.create.projectDocument");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.text.uploadComplete");
			wau.sendInput("project.field.marketingObjective", DataProperties.getProperty("project.create.projectMarketingObjective"));
			wau.sendInput("project.field.targetAudiance", DataProperties.getProperty("project.create.projectTargetAudiance"));
			wau.clickTab("project.field.projectStatus");
			wau.sendInput("project.field.projectStatus", DataProperties.getProperty("project.create.projectStatus"));
			wau.clickTab("project.field.projectTimeApprover");
			wau.sendInput("project.field.projectTimeApprover", DataProperties.getProperty("project.create.projectTimeApprover"));
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clickTab("project.field.billingType");
			wau.sendInput("project.field.billingType", DataProperties.getProperty("project.create.billingType"));
			wau.clickTab("project.field.billingStatus");
			wau.sendInput("project.field.billingStatus", DataProperties.getProperty("project.create.billingStatus"));
			wau.sendInput("project.field.dueDate", RamboUtil.EndDates());
			wau.clickTab("project.field.typeOfMailer");
			wau.sendInput("project.field.typeOfMailer", DataProperties.getProperty("project.create.typeOfMailer"));
			wau.sendInput("project.field.sizeOfDirectmail", DataProperties.getProperty("project.create.sizeOfDirectMail"));
			wau.sendInput("project.field.colorOfDirectMail", DataProperties.getProperty("project.create.colorsOfDirectMail"));
			wau.sendInput("project.field.quantityOfDirectMail", DataProperties.getProperty("project.create.quantityOfDirectMail"));
			wau.waitClickable("project.field.paperStock.matte");
			wau.clickButton("project.field.paperStock.matte");
			wau.sendInput("project.field.mailDropDate", RamboUtil.EndDates());
			wau.clickButton("project.button.saveAsDraft");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify create project save as draft successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Ubanel to verify create project save as draft");
			e.printStackTrace();
		}
		

	}

	private void createProjectTemplateCancel() {

		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_24 PM_28 Create project template with cancel");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.waitClickable("project.button.newProjectFromTemplate");
			wau.clickButton("project.button.newProjectFromTemplate");
			wau.isPresent("project.button.template.continue");
			wau.isPresent("project.button.template.cancel");
			wau.clickTab("project.field.template");
			RamboUtil.pause(500);
			wau.sendInput("project.field.template", DataProperties.getProperty("project.create.directMailTemplate"));
			/*wau.waitVisibility("project.template.comboBox.field.templateName");
			wau.clickTab("project.template.comboBox.field.templateName");*/
			wau.sendInput("project.field.template", Keys.ENTER);
			RamboUtil.pause(200);
			wau.clickTab("project.field.newProjectName");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.create.templateProjectName"));
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule"));
			wau.waitVisibility("project.button.template.cancel");
			wau.waitClickable("project.button.template.cancel");
			wau.clickButtonByJS("project.button.template.cancel");
			wau.waitVisibility("project.popup.button.yes");
			wau.clickButton("project.popup.button.yes");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case:  Create project template with cancel successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Test Case:  Create project template with cancel successfully");
			e.printStackTrace();
		}
		
	}

	private void createProjectTemplateWithoutMandatoryfield()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  Create project template without mandatory field");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.isPresent("project.button.newProjectFromTemplate");
			wau.waitClickable("project.button.newProjectFromTemplate");
			wau.clickButton("project.button.newProjectFromTemplate");
			wau.waitVisibility("project.button.template.continue");
			wau.clickTab("project.field.template");
			RamboUtil.pause(500);
			wau.sendInput("project.field.template", DataProperties.getProperty("project.create.text.templateName"));
			wau.sendInput("project.field.template", Keys.ENTER);
			wau.waitClickable("project.button.template.continue");
			wau.clickButton("project.button.template.continue");
			wau.validateColor("project.field.template", DataProperties.getProperty("project.alertmsg.boderColor"));
			wau.clickTab("project.field.newProjectName");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.create.templateProjectName"));
			wau.waitClickable("project.button.template.continue");
			wau.clickButton("project.button.template.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.field.create.projectName");
			RamboUtil.pause(1000);
			wau.clearAndWait("project.field.create.projectName");
			wau.waitClickable("project.button.create.save");
			wau.clickButton("project.button.create.save");
			wau.waitVisibility("project.alertBox.mandatoryField");
			wau.waitVisibility("project.text.alertmsg");
			wau.waitVisibility("project.button.alertmsg.ok");
			wau.clickButton("project.button.alertmsg.ok");
			wau.waitClickable("project.button.create.cancel");
			wau.clickButton("project.button.create.cancel");
			wau.clickButton("project.popup.button.yes");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify create project template without mandatory field successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create project template without mandatory field ");
			e.printStackTrace();
		}
		
	}

	private void createProjectTemplateDateValidation()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_27  Create project template with date validation");
			wau.waitClickable("project.button.newProject");
			wau.clickButton("project.button.newProject");
			wau.waitClickable("project.button.newProjectFromTemplate");
			wau.isPresent("project.button.newProjectFromTemplate");
			wau.clickButton("project.button.newProjectFromTemplate");
			wau.clickTab("project.field.template");
			RamboUtil.pause(500);
			wau.sendInput("project.field.template", DataProperties.getProperty("project.create.directMailTemplate"));
			wau.sendInput("project.field.template", Keys.ENTER);
			wau.waitVisibility("project.radioButton.yes");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.create.templateProjectName"));
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule"));
			wau.waitClickable("project.button.template.continue");
			wau.clickButton("project.button.template.continue");
			RamboUtil.pause(1000);
			wau.waitVisibility("project.button.create.save");
			wau.scrollIntoView("project.field.projectTimeApprover");
			wau.clickTab("project.field.projectTimeApprover");
			RamboUtil.pause(1000);
			wau.sendInput("project.field.projectTimeApprover", DataProperties.getProperty("project.create.projectTimeApprover"));
			wau.sendInput("project.field.projectTimeApprover", Keys.ENTER);
			wau.clearAndWait("project.field.plannedStartDate");
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clickTab("project.field.template.billingType");
			wau.sendInput("project.field.template.billingType", DataProperties.getProperty("project.create.billingType"));
			wau.sendInput("project.field.template.billingStatus", DataProperties.getProperty("project.create.billingStatus"));
			wau.clickTab("project.field.template.dueDate");
			wau.clearAndWait("project.field.template.dueDate");
			wau.sendInput("project.field.template.dueDate", RamboUtil.previousDate());
			wau.clickButton("project.button.create.save");
			wau.isDisplay("project.alertBox.invalidDate");
			wau.isDisplay("project.text.dateAlertMsg");
			wau.isPresent("project.button.dateAlertMsg.ok");
			wau.validateText("project.text.dateAlertMsg", DataProperties.getProperty("project.create.dateAlertMsg"));
			wau.clickButton("project.button.dateAlertMsg.ok");
			wau.waitClickable("project.button.create.cancel");
			wau.clickButton("project.button.create.cancel");
			wau.clickButton("project.popup.button.yes");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify create project template with date validation sucessfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create project template with date validation ");
			e.printStackTrace();
		}
		
	}

	private void verifyCalenderView()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_33  Verify calender view");
			preCondition();
			wau.isPresent("project.button.newProject");
			wau.isPresent("project.button.activeProject");
			wau.isPresent("project.button.listView");
			wau.clickButton("project.button.listView");
			wau.isPresent("project.button.menuCalenderView");
			wau.clickButton("project.button.menuCalenderView");
			wau.waitVisibility("project.calenderPanel.body");
			wau.waitVisibility("project.button.calenderView");
			wau.waitVisibility("project.button.calenderView.refresh");
			wau.isDisplay("project.calenderPanel.body");
			wau.waitClickable("project.calenderView.button.previousMonth");
			wau.waitVisibility("project.calenderView.text.actualMonth");
			wau.waitVisibility("project.calenderView.button.nextMonth");
			wau.fluwait("project.calenderView.button.previousMonth");
			RamboUtil.pause(1500);
			
			//click on previous month
			wau.clickByAction("project.calenderView.button.previousMonth");
			wau.waitVisibility("project.calenderPanel.body");
			wau.clickButton("project.button.calenderView.refresh");
			wau.fluwait("project.calenderView.button.nextMonth");
			RamboUtil.pause(1500);
			
			//click on next month
			wau.clickByAction("project.calenderView.button.nextMonth");
			wau.waitVisibility("project.calenderPanel.body");
			wau.clickButton("project.button.calenderView.refresh");
			wau.waitVisibility("project.calenderPanel.body");
			wau.waitVisibility("project.calenderView.text.actualMonth");
			String currentMonthAndYear = RamboUtil.getMonthAndYear();
			wau.validateText("project.calenderView.text.actualMonth", currentMonthAndYear);

			//wait for project name
			wau.retryingFindElement("project.calenderView.text.projectName");
			
			//get the project name
			String expectedProjectName = (wau.getElementText("project.calenderView.text.projectName")).trim();
			
			//click on the project name
			wau.clickTab("project.calenderView.text.projectName");
			wau.waitVisibility("project.viewProject.text.projectName");
			String actualProjectName = RamboUtil.getExactText((wau.getElementText("project.viewProject.text.projectName")),3,2).trim();
			assertEquals(actualProjectName,expectedProjectName);
			wau.waitVisibility("project.button.calenderView.addTag");
			wau.clickTab("project.button.calenderView.addTag");
			wau.waitVisibility("project.diaglogBox.calenderView.addTag");
			wau.isDisplay("project.diaglogBox.calenderView.addTag");
			wau.waitVisibility("project.diaglogBox.button.cancel");
			wau.clickButton("project.diaglogBox.button.cancel");
			wau.isPresent("project.button.calenderView.saveAsPDF");
			wau.isPresent("project.button.calenderView.manageNotes");
			wau.clickButton("project.button.calenderView.manageNotes");
			wau.waitVisibility("project.dialogBox.calenderView.manageNotes");
			wau.isDisplay("project.dialogBox.calenderView.manageNotes");
			wau.waitVisibility("project.dialogbox.button.closeDialogBox");
			wau.clickButton("project.dialogbox.button.closeDialogBox");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.calenderView");
			wau.clickButton("project.button.calenderView");
			wau.waitVisibility("project.button.menuList");
			wau.clickButton("project.button.menuList");
			wau.waitVisibility("project.button.listView");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify calender view successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify calender view successfully");
			e.printStackTrace();
		}
		
	}

	private void projectPaging() {

		//check for paging control
		wau.waitVisibility("project.label.numberOfPagesAvailable");

		//input last page count
		int maxPages = RamboUtil.getMaxPages(wau.getElementText("project.label.numberOfPagesAvailable"));

		wau.waitVisibility("project.field.pageNumber");
		RamboUtil.pause(1000);
		wau.clearAndWait("project.field.pageNumber");
		wau.sendInput("project.field.pageNumber", maxPages + "");
		wau.sendInput("project.field.pageNumber", Keys.ENTER);
		wau.waitVisibility("project.list.gridView");

		//traverse through the pages backwards
		for (int pageNum=maxPages; pageNum>1; pageNum--) {

			wau.waitClickable("project.list.page.previousbutton");
			RamboUtil.pause(1000);
			wau.clickButtonByJS("project.list.page.previousbutton");
			RamboUtil.pause(2000);
			wau.waitVisibility("project.list.gridView");
		}
	}



	private void viewProject() {

		try {
			wau.getLogger().log(Status.INFO, "Test Case:  PMTC-40");
			preCondition();
			wau.waitVisibility("project.text.projectName");
			String expectedProjectName = wau.getElementText("project.text.projectName").trim();
			System.out.println(expectedProjectName);
			wau.fluwait("project.list.gridView");
			wau.clickTab("project.tab.projectListOfAction");
			wau.isPresent("project.tab.viewproject");
			wau.clickTab("project.tab.viewproject");
			wau.waitVisibility("project.tab.create.details");
			wau.clickButtonByJS("project.tab.create.details");
			wau.waitVisibility("project.text.viewProject.projectName");
			String actualProjectName = RamboUtil.getExactText((wau.getElementText("project.text.viewProject.projectName")), 4, 2).trim();
			System.out.println(actualProjectName);
			assertEquals(expectedProjectName, actualProjectName);
			if(wau.isAvailable("project.button.viewProject.addTag"))
			{
				wau.retryingFindClick("project.button.viewProject.addTag");
			}
			else
			{
				wau.retryingFindClick("project.button.viewProject.addTag");
			}
			wau.isDisplay("project.dialogBox.viewProject.addTag");
			wau.clickButton("project.button.viewCancel");
			wau.isPresent("project.button.viewProject.saveAsPDF");
			if(wau.isAvailable("project.button.viewproject.manageNotes"))
			{
				wau.retryingFindClick("project.button.viewproject.manageNotes");
			}else
			{
				wau.retryingFindClick("project.button.viewproject.manageNotes");
			}
			wau.isDisplay("project.dialogBox.manageNotes");
			wau.waitClickable("project.dialogBox.manageNotes.closePanel");
			wau.clickButton("project.dialogBox.manageNotes.closePanel");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "View project verify successfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify view project verify successfully");
			e.printStackTrace();
		}
		
		// go to hard coded project and test all tabs within that project (as per regression plan)
	}

	private void modifyProjectWithCancel() {

		try {
			wau.getLogger().log(Status.INFO, "Test Case: PMTC-42 verify modify project with cancel button ");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.modifyproject");
			wau.clickTab("project.tab.modifyproject");

			// Modify project screen validation
			wau.isPresent("project.tab.summarytab");
			wau.isPresent("project.tab.tasks");
			wau.isPresent("project.tab.reviews");
			wau.isPresent("project.tab.timeline");
			wau.isPresent("project.tab.finances");
			wau.isPresent("project.tab.team");
			wau.isPresent("project.tab.files");
			wau.isPresent("project.tab.notes");
			wau.isPresent("project.button.actions");
			wau.isPresent("project.button.modifySave");
			wau.isPresent("project.button.modifyCancel");

			wau.waitVisibility("project.field.description");
			wau.clearAndWait("project.field.description");
			wau.sendInput("project.field.description", DataProperties.getProperty("project.create.projectDescription"));
			wau.clearAndWait("project.field.projectType");
			wau.sendInput("project.field.projectType", DataProperties.getProperty("project.create.projectType"));
			wau.clearAndWait("project.field.marketingObjective");
			wau.sendInput("project.field.marketingObjective", DataProperties.getProperty("project.create.projectMarketingObjective"));
			wau.clearAndWait("project.field.targetAudiance");
			wau.sendInput("project.field.targetAudiance", DataProperties.getProperty("project.create.projectTargetAudiance"));
			wau.clearAndWait("project.field.client");
			wau.sendInput("project.field.client", DataProperties.getProperty("project.create.projectClient"));
			wau.clearAndWait("project.field.projectStatus");
			wau.sendInput("project.field.projectStatus", DataProperties.getProperty("project.create.projectStatus"));
			wau.clearAndWait("project.field.projectTimeApprover");
			wau.sendInput("project.field.projectTimeApprover", DataProperties.getProperty("project.create.projectTimeApprover"));
			wau.clearAndWait("project.field.plannedStartDate");
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clearAndWait("project.field.billingType");
			wau.sendInput("project.field.billingType", DataProperties.getProperty("project.create.billingType"));
			wau.clearAndWait("project.field.billingStatus");
			wau.sendInput("project.field.billingStatus", DataProperties.getProperty("project.create.billingStatus"));
			wau.clearAndWait("project.field.dueDate");
			wau.sendInput("project.field.dueDate", RamboUtil.EndDates());
			wau.waitClickable("project.button.modifyCancel");
			wau.clickButton("project.button.modifyCancel");
			wau.waitClickable("project.button.yes");
			wau.clickButton("project.button.yes");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify modify project with cancel button successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify modify project with cancel button");
			e.printStackTrace();
		}
		

	}

	private void modifyProjectWithOutMandatoryField()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:Extra-Validation  PMTC-modify project With out mandatory fields");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.modifyproject");
			wau.clickTab("project.tab.modifyproject");
			wau.waitVisibility("project.field.plannedStartDate");
			wau.scrollIntoView("project.field.plannedStartDate");
			wau.clearAndWait("project.field.plannedStartDate");
			wau.waitClickable("project.button.save");
			wau.clickButton("project.button.save");
			wau.isDisplay("project.alertBox.mandatoryField");
			wau.isDisplay("project.text.alertmsg");
			wau.waitVisibility("project.text.alertmsg");
			wau.isPresent("project.button.alertmsg.ok");
			wau.clickButton("project.button.alertmsg.ok");
			wau.clickButton("project.button.modifyCancel");
			wau.waitVisibility("project.button.yes");
			wau.clickButton("project.button.yes");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify modify project With out mandatory fields successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify modify project With out mandatory fields");
			e.printStackTrace();
		}
		
	}

	private void modifyProjectWithDateValidation()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:Extra-Validation  PMTC-modify project with date validation");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.modifyproject");
			wau.clickTab("project.tab.modifyproject");
			wau.waitVisibility("project.field.plannedStartDate");
			wau.scrollIntoView("project.field.plannedStartDate");
			wau.clearAndWait("project.field.plannedStartDate");
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clearAndWait("project.field.dueDate");
			wau.sendInput("project.field.dueDate", RamboUtil.previousDate());
			wau.waitClickable("project.button.save");
			wau.clickButton("project.button.save");
			wau.isDisplay("project.alertBox.invalidDate");
			wau.isDisplay("project.text.dateAlertMsg");
			wau.waitVisibility("project.text.dateAlertMsg");
			wau.isPresent("project.button.dateAlertMsg.ok");
			wau.clickButton("project.button.dateAlertMsg.ok");
			wau.clickButton("project.button.modifyCancel");
			wau.waitClickable("project.button.yes");
			wau.clickButton("project.button.yes");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify modify project with date validation successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify modify project with date validation");
			e.printStackTrace();
		}
		
}

	private void modifyProjectWithValidData()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_41  PMTC-modify project with valid data");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.modifyproject");
			wau.clickTab("project.tab.modifyproject");
			wau.waitVisibility("project.field.description");
			wau.clearAndWait("project.field.description");
			wau.sendInput("project.field.description", DataProperties.getProperty("project.create.projectDescription"));
			wau.clearAndWait("project.field.projectType");
			wau.sendInput("project.field.projectType", DataProperties.getProperty("project.create.projectType"));
			wau.clearAndWait("project.field.marketingObjective");
			wau.sendInput("project.field.marketingObjective", DataProperties.getProperty("project.create.projectMarketingObjective"));
			wau.clearAndWait("project.field.targetAudiance");
			wau.sendInput("project.field.targetAudiance", DataProperties.getProperty("project.create.projectTargetAudiance"));
			wau.clearAndWait("project.field.client");
			wau.sendInput("project.field.client", DataProperties.getProperty("project.create.projectClient"));
			wau.clearAndWait("project.field.projectStatus");
			wau.sendInput("project.field.projectStatus", DataProperties.getProperty("project.create.projectStatus"));
			wau.clearAndWait("project.field.projectTimeApprover");
			wau.sendInput("project.field.projectTimeApprover", DataProperties.getProperty("project.create.projectTimeApprover"));
			wau.clearAndWait("project.field.plannedStartDate");
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clearAndWait("project.field.billingType");
			wau.sendInput("project.field.billingType", DataProperties.getProperty("project.create.billingType"));
			wau.clearAndWait("project.field.billingStatus");
			wau.sendInput("project.field.billingStatus", DataProperties.getProperty("project.create.billingStatus"));
			wau.clearAndWait("project.field.dueDate");
			wau.sendInput("project.field.dueDate", RamboUtil.EndDates());
			wau.clearAndWait("project.field.typeOfMailer");
			wau.sendInput("project.field.typeOfMailer", DataProperties.getProperty("project.create.typeOfMailer"));
			wau.clearAndWait("project.field.sizeOfDirectmail");
			wau.sendInput("project.field.sizeOfDirectmail", DataProperties.getProperty("project.create.sizeOfDirectMail"));
			wau.clearAndWait("project.field.colorOfDirectMail");
			wau.sendInput("project.field.colorOfDirectMail", DataProperties.getProperty("project.create.colorsOfDirectMail"));
			wau.clearAndWait("project.field.quantityOfDirectMail");
			wau.sendInput("project.field.quantityOfDirectMail", DataProperties.getProperty("project.create.quantityOfDirectMail"));
			//wau.clickButton("project.field.paperStock.matte");
			wau.clearAndWait("project.field.mailDropDate");
			wau.sendInput("project.field.mailDropDate", RamboUtil.EndDates());
			wau.clickButton("project.button.save");
			if(wau.isDisplay("project.modifyProject.dialogBox")==true)
			{
				wau.waitClickable("project.modifyProject.dialogBox.submitButton");
				wau.clickButton("project.modifyProject.dialogBox.submitButton");
			}
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify modify project with valid data successfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify modify project with valid data");
			e.printStackTrace();
		}
		
	}

	private void setProjectStatusAsInprogress() 
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_43  PMTC-Verify set project status as In progress");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.setprojectstatus");
			wau.isPresent("project.tab.setprojectstatus");
			//wau.mouseHover("project.tab.setprojectstatus");
			wau.clickButton("project.tab.setprojectstatus");
			wau.isPresent("project.tab.inProgress");
			wau.isPresent("project.tab.onHold");
			wau.isPresent("project.tab.complete");
			wau.isPresent("project.tab.cancelled");
			wau.waitVisibility("project.tab.inProgress");
			wau.waitClickable("project.tab.inProgress");
			wau.clickByAction("project.tab.inProgress");
			wau.getLogger().log(Status.PASS, "Verify set project status as In progress successfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify set project status as In progress ");
			e.printStackTrace();
		}
		
	}

	private void copyAsNewProjectWithCancel()
	{
		try {

			wau.getLogger().log(Status.INFO, "Test Case:PM_44,63  PMTC-copy as new project with cancel");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.field.newProjectName");
			wau.isPresent("project.button.isCopyTask");
			wau.isPresent("project.button.isCopyReview");
			wau.isPresent("project.button.isCopyBudgetedExpenses");
			wau.isPresent("project.button.isCopyProjectTeam");
			wau.isPresent("project.button.continue");
			wau.isPresent("project.tab.copyAsNewProject.cancel");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButton("project.tab.copyAsNewProject.cancel");
			wau.waitClickable("project.button.yesbutton");
			wau.clickButton("project.button.yesbutton");
			wau.waitVisibility("main.tab.projects");
			wau.getLogger().log(Status.PASS, "Test Case: Verify PMTC-copy as new project with cancel succssfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify Copy As New Project Cancel Button");
			e.printStackTrace();
		}

	}

	private void copyAsNewProjectWitoutMandatoryFields()
	{
		try {

			wau.getLogger().log(Status.INFO, "Test Case:PM_62  PMTC-copy as new project without mandatory fields");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.field.newProjectName");
			wau.waitClickable("project.button.continue");
			wau.clickButtonByJS("project.button.continue");
			wau.validateColor("project.field.newProjectName", DataProperties.getProperty("project.alertmsg.boderColor"));
			wau.clickTab("project.field.newProjectName");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitVisibility("project.field.projectShedule");
			}

			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitVisibility("project.field.projectReview");
			}
			RamboUtil.pause(1000);
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.basedOnProjectStartDate"));
			wau.pressEnter();
			wau.clickTab("project.field.projectReview");
			wau.sendInput("project.field.projectReview", DataProperties.getProperty("project.create.projectReview.basedOnProjectStartDate"));
			wau.pressEnter();
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.save");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clearAndWait("project.field.create.projectName");
			wau.clickButton("project.button.save");
			wau.waitVisibility("project.alertBox.mandatoryField");
			wau.isDisplay("project.alertBox.mandatoryField");
			wau.waitVisibility("project.text.alertmsg");
			wau.isPresent("project.button.alertmsg.ok");
			wau.clickButton("project.button.alertmsg.ok");
			wau.clickButtonByJS("project.button.copyAsNewProject.cancel");
			wau.waitVisibility("project.button.yes");
			wau.clickButton("project.button.yes");
			wau.waitVisibility("main.tab.projects");
			wau.getLogger().log(Status.PASS, "Test Case: Verify PMTC-copy as new project without mandatory fields successfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project without mandatory field");
			e.printStackTrace();
		}

	}

	private void copyAsNewProjectWithDateValidation()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_45  PMTC-copy as new project with date validation");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTask");

			}else
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already unchecked");

			}

			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");

			}else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");

			}
			wau.waitVisibility("project.field.newProjectName");
			wau.clickTab("project.field.newProjectName");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.waitVisibility("project.field.plannedStartDate");
			wau.clearAndWait("project.field.plannedStartDate");
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.waitVisibility("project.field.plannedStartDate");
			wau.clearAndWait("project.field.dueDate");
			wau.sendInput("project.field.dueDate", RamboUtil.previousDate());
			wau.waitClickable("project.button.continue");
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.waitClickable("project.button.save");
			wau.clickButton("project.button.save");
			wau.waitVisibility("project.alertBox.mandatoryField");
			wau.waitVisibility("project.text.copyAsNewProject.dateAlertMsg");
			wau.isPresent("project.button.copyAsNewProject.ok");
			wau.clickButton("project.button.copyAsNewProject.ok");
			wau.waitClickable("project.button.copyAsNewProject.cancel");
			wau.clickButton("project.button.copyAsNewProject.cancel");
			wau.waitVisibility("project.button.yes");
			wau.clickButton("project.button.yes");
			wau.waitVisibility("main.tab.projects");
			wau.getLogger().log(Status.PASS, "Test Case: Verify PMTC-copy as new project with date validation successfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with date validation");
			e.printStackTrace();
		}

	}

	private void copyAsNewProjectWithValidData()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_61  PMTC-copy as new project with valid data");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTask");

			}else
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already unchecked");

			}

			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");

			}else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");

			}
			wau.waitVisibility("project.field.newProjectName");
			wau.isPresent("project.button.isCopyTask");
			wau.isPresent("project.button.isCopyReview");
			wau.isPresent("project.button.isCopyBudgetedExpenses");
			wau.isPresent("project.button.isCopyProjectTeam");
			wau.isPresent("project.button.isCopyFiles");
			wau.isPresent("project.button.isCopyTags");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.waitClickable("project.button.continue");
			wau.clickTab("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButton("project.button.save");

			if(wau.isDisplay("project.alertMsg.popup.projectAdded")==true)
			{
				wau.waitVisibility("project.alertMsg.popup.projectAdded");
				wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			}else
			{
				RamboUtil.pause(18000);
			}

			wau.waitVisibility("project.tab.create.details");
			wau.waitVisibility("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.button.create.newTask");
			wau.isPresent("project.button.create.newTask");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case: Verify PMTC-copy as new project with valid data successfully");
			deleteProject();

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with valid data");
			e.printStackTrace();
		}
	}

	private void copyAsNewProjectWithCheckTaskAndReviewCheckBox()
	{
		try {

			wau.getLogger().log(Status.INFO, "Test Case:  PMTC- Copy as new project with check Task and Review radio button");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.button.continue");
			wau.waitVisibility("project.button.isCopyTask");
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitVisibility("project.field.projectShedule");
			}

			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitVisibility("project.field.projectReview");
			}
			RamboUtil.pause(1000);
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.basedOnProjectStartDate"));
			wau.pressEnter();
			wau.clickTab("project.field.projectReview");
			wau.sendInput("project.field.projectReview", DataProperties.getProperty("project.create.projectReview.basedOnProjectStartDate"));
			wau.pressEnter();
			wau.waitClickable("project.button.continue");
			wau.clickButton("project.button.continue");
			RamboUtil.pause(500);
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButtonByJS("project.button.save");

			if(wau.isDisplay("project.alertMsg.popup.projectAdded")==true)
			{
				wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			}
			else
			{
				RamboUtil.pause(18000);
			}
			wau.waitClickable("project.tab.create.details");
			wau.clickButton("project.tab.create.details");
			wau.waitClickable("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.button.create.newTask");
			wau.isPresent("project.button.create.newTask");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case:  PMTC- Copy as new project with check Task and Review radio button successfully");
			deleteProject();


		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with check Task and Review radio button");
			e.printStackTrace();
		}

	}

	private void copyAsNewProjectWithCheckTaskCheckBox()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_47  PMTC- Copy as new project with check Task radio button");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitClickable("project.button.isCopyTask");
			wau.waitClickable("project.button.isCopyReview");
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitVisibility("project.field.projectShedule");
			}

			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitInvisibility("project.field.projectReview");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.basedOnReferenceTaskStartDate"));
			wau.pressEnter();
			wau.waitVisibility("project.field.copyAsNewProject.referenceTask");
			wau.clickTab("project.field.copyAsNewProject.referenceTask");
			wau.sendInput("project.field.copyAsNewProject.referenceTask", DataProperties.getProperty("project.create.copyAsNewProject.referenceTask"));
			wau.pressEnter();
			wau.sendInput("project.field.copyAsNewProject.ReferenceDate", RamboUtil.EndDates());
			wau.waitVisibility("project.button.continue");
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButtonByJS("project.button.save");
			if(wau.isDisplay("project.alertMsg.popup.projectAdded")==true)
			{
				wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			}
			else
			{
				RamboUtil.pause(10000);
			}
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.button.create.newTask");
			wau.isPresent("project.button.create.newTask");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case:  PMTC- Copy as new project with check Task radio button successfully");
			deleteProject();

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with check Task radio button");
			e.printStackTrace();
		}

	}

	private void copyAsNewProjectWithCheckReviewCheckBox()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_46  PMTC- Copy as new project with check Review radio button");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.button.continue");
			wau.isPresent("project.button.isCopyTask");
			wau.waitVisibility("project.button.isCopyTask");
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitInvisibility("project.field.projectShedule");
			}else
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already unchecked");
			}

			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitVisibility("project.field.projectReview");
			}
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickTab("project.field.projectReview");
			wau.sendInput("project.field.projectReview", DataProperties.getProperty("project.create.projectReview.basedOnProjectStartDate"));
			wau.pressEnter();
			wau.waitClickable("project.button.continue");
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButton("project.button.save");
			if(wau.isDisplay("project.popupMsg.alertBox.addProject")==true)
			{
				wau.waitInvisibility("project.popupMsg.alertBox.addProject");
			}
			else 
			{
				RamboUtil.pause(18000);
			}

			wau.waitVisibility("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.button.create.newTask");
			wau.isPresent("project.button.create.newTask");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case:  PMTC- Copy as new project with check Review radio button successfully");
			deleteProject();

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with check Review radio button");
			e.printStackTrace();
		}
	}

	private void copyAsNewProjectWithUncheckBudgetedExpenses()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_48  PMTC- Copy as new project with uncheck budgeted expences");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.button.continue");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitInvisibility("project.field.projectShedule");
			}else
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitInvisibility("project.field.projectReview");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyBudgetedExpenses", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyBudgetedExpenses");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Budgedted expenses radio button is already uncheked");
			}
			wau.waitClickable("project.button.continue");
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButton("project.button.save");
			if(wau.isDisplay("project.alertMsg.popup.projectAdded"))
			{
				wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			}
			else
			{
				RamboUtil.pause(18000);
			}
			wau.waitVisibility("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.text.copyAsNewProject.taskRecord");
			wau.clickTab("project.tab.copyAsNewProject.reviews");
			wau.waitVisibility("project.text.copyAsNewProject.reviewRecord");
			wau.clickTab("project.tab.copyAsNewProject.finances");
			wau.waitVisibility("project.text.copyAsNewProject.financesRecord");
			wau.clickTab("project.tab.create.details");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case:  PMTC- Verify Copy as new project with uncheck budgeted expences successfully");
			deleteProject();

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with uncheck budgeted expences");
			e.printStackTrace();
		}

	}

	private void copyAsNewProjectWithUncheckTeam()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_49  PMTC- Copy as new project with uncheck team");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.button.continue");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitInvisibility("project.field.projectShedule");
			}else
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitInvisibility("project.field.projectReview");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyBudgetedExpenses", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyBudgetedExpenses");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Budgedted expenses radio button is already uncheked");
			}
			if(wau.getAttribute("project.button.isCopyProjectTeam", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyProjectTeam");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Team radio button is already uncheked");
			}
			wau.waitClickable("project.button.continue");
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButton("project.button.save");
			wau.waitVisibility("project.alertMsg.popup.projectAdded");
			wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			wau.waitVisibility("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.text.copyAsNewProject.taskRecord");
			wau.clickTab("project.tab.copyAsNewProject.reviews");
			wau.waitVisibility("project.text.copyAsNewProject.reviewRecord");
			wau.clickTab("project.tab.copyAsNewProject.finances");
			wau.waitVisibility("project.text.copyAsNewProject.financesRecord");
			wau.clickButton("project.button.copyAsNewProject.team");
			wau.waitVisibility("project.button.copyAsNewProject.addGroup");
			wau.clickTab("project.tab.create.details");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case: Verify PMTC- Copy as new project with uncheck Team radio button successfully");
			deleteProject();

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with uncheck Team radio button");
		}

	}

	private void copyAsNewProjectWithUncheckFiles()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_50  PMTC- Copy as new project with uncheck files");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.button.continue");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitInvisibility("project.field.projectShedule");
			}else
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitInvisibility("project.field.projectReview");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyBudgetedExpenses", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyBudgetedExpenses");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Budgedted expenses radio button is already uncheked");
			}
			if(wau.getAttribute("project.button.isCopyProjectTeam", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyProjectTeam");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Team radio button is already uncheked");
			}
			if(wau.getAttribute("project.button.isCopyFiles", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyFiles");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Files radio button is already uncheked");
			}
			wau.waitClickable("project.button.continue");
			wau.clickButtonByJS("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButton("project.button.save");

			if(wau.isDisplay("project.alertMsg.popup.projectAdded")==true)
			{
				wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			}else
			{
				RamboUtil.pause(10000);
			}

			wau.waitVisibility("project.alertMsg.popup.projectAdded");
			wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			wau.waitVisibility("project.tab.create.details");
			wau.waitVisibility("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.text.copyAsNewProject.taskRecord");
			wau.clickTab("project.tab.copyAsNewProject.reviews");
			wau.waitVisibility("project.text.copyAsNewProject.reviewRecord");
			wau.clickTab("project.tab.copyAsNewProject.finances");
			wau.waitVisibility("project.text.copyAsNewProject.financesRecord");
			wau.clickTab("project.tab.copyAsNewProject.file");
			wau.waitVisibility("project.text.copyAsNewProject.fileRecord");
			wau.clickTab("project.tab.create.details");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case:  PMTC- Verify Copy as new project with uncheck files successfully");
			deleteProject();

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with uncheck Files radio button");
			e.printStackTrace();
		}
	}

	private void copyAsNewProjectWithUncheckTags()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_51  PMTC- Copy as new project with uncheck tags");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.button.continue");
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitInvisibility("project.field.projectShedule");
			}else
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitInvisibility("project.field.projectReview");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			if(wau.getAttribute("project.button.isCopyBudgetedExpenses", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyBudgetedExpenses");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Budgedted expenses radio button is already uncheked");
			}
			if(wau.getAttribute("project.button.isCopyProjectTeam", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyProjectTeam");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Team radio button is already uncheked");
			}
			if(wau.getAttribute("project.button.isCopyFiles", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyFiles");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Files radio button is already uncheked");
			}
			if(wau.getAttribute("project.button.isCopyTags", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyTags");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "Tags radio button is already uncheked");
			}
			wau.waitClickable("project.button.continue");
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.create.saveAsDraft");
			wau.waitVisibility("project.button.save");
			wau.waitClickable("project.button.save");
			wau.isTextToBePresent("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickButton("project.button.save");
			if(wau.isDisplay("project.alertMsg.popup.projectAdded")==true)
			{
				wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			}
			else
			{
				RamboUtil.pause(5000);
			}
			wau.waitVisibility("project.tab.create.details");
			wau.waitVisibility("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.waitVisibility("project.text.copyAsNewProject.taskRecord");
			wau.clickTab("project.tab.copyAsNewProject.reviews");
			wau.waitVisibility("project.text.copyAsNewProject.reviewRecord");
			wau.clickTab("project.tab.copyAsNewProject.finances");
			wau.waitVisibility("project.text.copyAsNewProject.financesRecord");
			wau.clickTab("project.tab.copyAsNewProject.file");
			wau.waitVisibility("project.text.copyAsNewProject.fileRecord");
			wau.clickTab("project.tab.create.details");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.mouseHover("project.text.copyAsNewProject.tagsRecord");
			wau.validateColor("project.text.copyAsNewProject.tagsRecord", DataProperties.getProperty("project.copyAsNewProject.taskBackgroundColor"));
			wau.getLogger().log(Status.PASS, "Verify Copy as new project with uncheck Tags radio successfully");
			deleteProject();

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project with uncheck Tags radio button");
			e.printStackTrace();
		}

		
	}

	private void copyAsNewProjectValidateResourceRadioButton()
	{
		verifyCheckResource();

		verifyProjectSheduleTaskBasedOnStartDate();

		verifyProjectSheduleSetTaskDatesManually();

	}

	private void verifyCheckResource()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_52  PMTC- Copy as new project with validate resources radio button");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.radioButton.yes");
			wau.isCheck("project.radioButton.yes");
			wau.waitVisibility("project.button.continue");
			String copyTask = "true";
			String copyReview = "true";
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(copyTask))
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitVisibility("project.field.projectShedule");
			}

			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(copyReview))
			{
				wau.clickButtonByJS("project.button.isCopyReview");
				wau.waitInvisibility("project.field.projectReview");
			}
			else
			{
				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			wau.sendInput("project.field.newProjectName", DataProperties.getProperty("project.menu.copyAsNewProjectName"));
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.setTaskDatesManually"));
			wau.pressEnter();
			wau.isPresent("project.link.copyAsNewProject.showEstimated");
			wau.clickLink("project.link.copyAsNewProject.showEstimated");
			wau.waitVisibility("project.text.copyAsNewProject.showEstimatedAlertMsg");
			wau.clickButton("project.button.copyAsNewProject.showEstimatedAlertMsg.ok");
			wau.clickTab("project.field.copyAsNewProject.projectOwner");
			wau.sendInput("project.field.copyAsNewProject.projectOwner", DataProperties.getProperty("Project.create.copyAsNewProject.projectOwner"));
			wau.sendInput("project.field.copyAsNewProject.projectOwner", Keys.ENTER);
			RamboUtil.pause(1000);
			wau.waitVisibility("project.text.copyAsNewProject.noConflicts");
			wau.clickLink("project.link.copyAsNewProject.showEstimated");
			wau.waitVisibility("project.dialogBox.copyAsNewProject.userResource");
			wau.isDisplay("project.dialogBox.copyAsNewProject.userResource");
			wau.waitVisibility("project.dialogBox.copyAsNewProject.userResourceClosePanel");
			wau.clickButton("project.dialogBox.copyAsNewProject.userResourceClosePanel");
			RamboUtil.pause(1000);
			wau.waitVisibility("project.button.continue");
			wau.clearAndWait("project.field.copyAsNewProject.projectOwner");
			RamboUtil.pause(1000);
			wau.clearAndWait("project.field.plannedStartDate");
			wau.clearAndWait("project.field.dueDate");
			wau.waitInvisibility("project.link.copyAsNewProject.showEstimated");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.setTaskDatesManually"));
			wau.clickButton("project.button.create.cancel");
			wau.waitClickable("project.popup.button.yes");
			wau.clickButton("project.popup.button.yes");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case: Verify PMTC- Copy as new project with validate resources radio button successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verufy copy as new project with validate resources radio button");
			e.printStackTrace();
		}

	}

	private void verifyProjectSheduleTaskBasedOnStartDate()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_53,54  PMTC- Copy as new project with verify with task based on start date");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.radioButton.yes");
			wau.isCheck("project.radioButton.yes");
			wau.waitVisibility("project.button.continue");
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitVisibility("project.field.projectShedule");
			}
			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");

			}else
			{

				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			wau.clearAndWait("project.field.dueDate");
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.basedOnProjectStartDate"));
			String plannedStartDate = wau.getAttributeValue("project.field.plannedStartDate");
			System.out.println(plannedStartDate);
			String convertedPlannedDate=RamboUtil.getConvertedDate(plannedStartDate);
			wau.clickTab("project.field.copyAsNewProject.projectOwner");
			wau.sendInput("project.field.copyAsNewProject.projectOwner", DataProperties.getProperty("Project.create.copyAsNewProject.projectOwner"));
			wau.sendInput("project.field.copyAsNewProject.projectOwner", Keys.ENTER);
			RamboUtil.pause(1000);
			wau.waitVisibility("project.text.copyAsNewProject.noConflicts");
			wau.clickLink("project.link.copyAsNewProject.showEstimated");
			wau.waitVisibility("project.dialogBox.copyAsNewProject.userResource");
			wau.isDisplay("project.dialogBox.copyAsNewProject.userResource");
			wau.waitVisibility("project.dialogBox.copyAsNewProject.userResourceClosePanel");
			String userResourceDate = wau.getElementText("project.dialogBox.copyAsNewProject.userResourceDate");
			String startDate=RamboUtil.getUserResourceStartDate(userResourceDate);
			assertEquals(convertedPlannedDate, startDate);
			wau.clickButton("project.dialogBox.copyAsNewProject.userResourceClosePanel");
			RamboUtil.pause(1000);
			wau.waitVisibility("project.button.continue");
			wau.clickButton("project.button.create.cancel");
			wau.waitClickable("project.popup.button.yes");
			wau.clickButton("project.popup.button.yes");
			wau.getLogger().log(Status.PASS, "Verify Copy as new project with verify with task based on start date successfully");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verfy copy as new project with task based on start date");
		}


	}

	private void verifyProjectSheduleSetTaskDatesManually()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_56,57,58  PMTC- Copy as new project with verify with task based on due date");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.radioButton.yes");
			wau.isCheck("project.radioButton.yes");
			wau.waitVisibility("project.button.continue");
			RamboUtil.pause(1000);
			if(wau.getAttribute("project.button.isCopyTask", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.getLogger().log(Status.PASS, "copy task radio button is already checked");
			}else
			{
				wau.clickButtonByJS("project.button.isCopyTask");
				wau.waitVisibility("project.field.projectShedule");
			}
			if(wau.getAttribute("project.button.isCopyReview", DataProperties.getProperty("project.button.copyAsNewProject.radioButton")).contentEquals(DataProperties.getProperty("project.text.copyAsNewProject")))
			{
				wau.clickButtonByJS("project.button.isCopyReview");

			}else
			{

				wau.getLogger().log(Status.PASS, "copy review radio button is already unchecked");
			}
			RamboUtil.pause(1000);
			wau.clearAndWait("project.field.plannedStartDate");
			wau.sendInput("project.create.copyProject.projectName", DataProperties.getProperty("project.create.projectName"));
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.setTaskDatesManually"));
			//wau.sendInput("project.field.projectShedule", Keys.ENTER);
			//wau.clickTab("project.field.create.projectName");
			String plannedDueDate = wau.getAttributeValue("project.field.dueDate");
			String convertedDueDate = RamboUtil.getConvertedDate(plannedDueDate);
			wau.clickTab("project.field.copyAsNewProject.projectOwner");
			wau.sendInput("project.field.copyAsNewProject.projectOwner", DataProperties.getProperty("Project.create.copyAsNewProject.projectOwner"));
			wau.sendInput("project.field.copyAsNewProject.projectOwner", Keys.ENTER);
			RamboUtil.pause(1000);
			wau.waitVisibility("project.text.copyAsNewProject.noConflicts");
			wau.clickLink("project.link.copyAsNewProject.showEstimated");
			wau.waitVisibility("project.dialogBox.copyAsNewProject.userResource");
			wau.isDisplay("project.dialogBox.copyAsNewProject.userResource");
			RamboUtil.pause(1000);
			wau.waitVisibility("project.dialogBox.copyAsNewProject.userResourceClosePanel");
			String userResourceDate = wau.getElementText("project.dialogBox.copyAsNewProject.userResourceDate");
			String dueDate=RamboUtil.getUserResourceDueDate(userResourceDate);
			assertEquals(convertedDueDate, dueDate);
			wau.clickButton("project.dialogBox.copyAsNewProject.userResourceClosePanel");
			wau.waitVisibility("project.button.continue");
			wau.clickButton("project.button.create.cancel");
			wau.waitClickable("project.popup.button.yes");
			wau.clickButton("project.popup.button.yes");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Test Case: Verify PMTC- Copy as new project with verify with task based on due date successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new oroject with verify with task based on due date successfully");
			e.printStackTrace();
		}

	}

	private void copyAsNewProjectWithSaveAsDraft()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_64  PMTC- Copy as new project save as draft");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsNewProject");
			wau.waitClickable("project.tab.copyAsNewProject");
			wau.clickButton("project.tab.copyAsNewProject");
			wau.waitVisibility("project.radioButton.yes");
			wau.isCheck("project.radioButton.yes");
			wau.waitVisibility("project.button.continue");
			wau.sendInput("project.field.create.projectName", DataProperties.getProperty("project.create.projectName"));
			wau.clickTab("project.field.projectShedule");
			wau.sendInput("project.field.projectShedule", DataProperties.getProperty("project.create.projectShedule.basedOnProjectStartDate"));
			wau.clickTab("project.field.projectReview");
			wau.sendInput("project.field.projectReview", DataProperties.getProperty("project.create.projectReview.basedOnProjectStartDate"));
			wau.clickButton("project.button.continue");
			wau.waitVisibility("project.button.save");
			wau.isDisplay("project.button.saveAsDraft");
			wau.waitClickable("project.button.saveAsDraft");
			RamboUtil.pause(2000);
			wau.clickButton("project.button.saveAsDraft");
			wau.getLogger().log(Status.PASS, "Verify copy as new project with save as draft successfully");
			wau.waitVisibility("project.button.newProject");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify copy as new project save as draft");
		}
	}

	private void copyAsNewTemplate() {

		copyAsNewTemplateWithCancel();

		copyAsNewTemplateWithOutMadatoryField();

		copyAsNewTemplateWithDateValidation();

		copyAsNewTemplateWithValidData();

	}

	private void copyAsNewTemplateWithCancel()
	{
		try {

			wau.getLogger().log(Status.INFO, "Test Case:PM_67  PMTC- Copy as new template with cancel");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsTemplate");
			wau.clickButton("project.tab.copyAsTemplate");
			wau.waitVisibility("project.button.save");
			wau.isPresent("project.button.isCopyTask");
			wau.isPresent("project.button.isCopyReview");
			wau.isPresent("project.button.isCopyBudgetedExpenses");
			wau.isPresent("project.button.isCopyProjectTeam");
			wau.isPresent("project.button.continue");
			wau.clickButton("project.button.create.cancel");
			wau.waitVisibility("project.popup.button.no");
			wau.clickButton("project.popup.button.no");
			wau.waitVisibility("project.field.copyAsTemplate.templateName");
			wau.sendInput("project.field.copyAsTemplate.templateName", DataProperties.getProperty("project.field.copyAsNewTemplate.templateName"));
			wau.clickButton("project.button.save");
			//wau.isTextToBePresent("project.field.projectName", DataProperties.getProperty("project.field.copyAsNewTemplate.templateName"));
			wau.waitVisibility("project.button.save");
			wau.waitVisibility("project.button.create.cancel");
			RamboUtil.pause(2000);
			wau.clickButton("project.button.create.cancel");
			wau.waitVisibility("project.popup.button.yes");
			wau.clickButton("project.popup.button.yes");
			wau.getLogger().log(Status.PASS,"Verify copy as new project template with cancel button successfully");
			wau.waitVisibility("main.tab.projects");
			wau.waitVisibility("project.button.newProject");


		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL,"Unable to verify copy as new project template with cancel button");
			e.printStackTrace();
		}

	}

	private void copyAsNewTemplateWithOutMadatoryField()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  PMTC- Copy as new template without mandatory fields");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsTemplate");
			wau.clickButton("project.tab.copyAsTemplate");
			wau.waitVisibility("project.button.save");
			wau.clickButton("project.button.save");
			wau.validateColor("project.field.copyAsTemplate.templateName", DataProperties.getProperty("project.alertmsg.boderColor"));
			wau.clickTab("project.field.copyAsTemplate.templateName");
			wau.sendInput("project.field.copyAsTemplate.templateName", DataProperties.getProperty("project.field.copyAsNewTemplate.templateName"));
			wau.clickButton("project.button.save");
			wau.isTextToBePresent("project.field.projectName", DataProperties.getProperty("project.field.copyAsNewTemplate.templateName"));
			wau.waitVisibility("project.button.save");
			wau.clearAndWait("project.field.create.projectName");
			wau.clickButton("project.button.save");
			wau.waitVisibility("project.alertBox.mandatoryField");
			wau.isDisplay("project.alertBox.mandatoryField");
			wau.waitVisibility("project.copyAsNewTemplate.requiredField.alertMsg");
			wau.isPresent("project.copyAsNewTemplate.button.ok");
			wau.clickButton("project.copyAsNewTemplate.button.ok");
			wau.clickButton("project.button.create.cancel");
			wau.waitVisibility("project.popup.button.yes");
			wau.clickButton("project.popup.button.yes");
			wau.getLogger().log(Status.PASS,"Verify copy as new project template without mandatory field");
			wau.waitVisibility("main.tab.projects");
			wau.waitVisibility("project.button.newProject");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL,"Unable to verify copy as new project template without mandatory field");
			e.printStackTrace();
		}
	}

	private void copyAsNewTemplateWithDateValidation()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_66  PMTC- Copy as new template with date validation");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsTemplate");
			wau.clickButton("project.tab.copyAsTemplate");
			wau.waitVisibility("project.button.save");
			wau.sendInput("project.field.copyAsTemplate.templateName", DataProperties.getProperty("project.field.copyAsNewProject.projectName"));
			wau.clearAndWait("project.field.plannedStartDate");
			wau.sendInput("project.field.plannedStartDate", RamboUtil.startDates());
			wau.clearAndWait("project.field.dueDate");
			wau.sendInput("project.field.dueDate", RamboUtil.previousDate());
			wau.isUncheck("project.button.isCopyTask");
			wau.isUncheck("project.button.isCopyReview");
			wau.clickButton("project.button.save");
			//RamboUtil.pause(2000);
			wau.isTextToBePresent("project.field.projectName", DataProperties.getProperty("project.field.copyAsNewTemplate.templateName"));
			wau.waitVisibility("project.button.copyAsNewProject.cancel");
			wau.waitClickable("project.button.create.save");
			wau.clickButtonByJS("project.button.create.save");
			wau.waitVisibility("project.alertBox.invalidDate");
			wau.waitVisibility("project.text.dateAlertMsg");
			wau.isPresent("project.button.dateAlertMsg.ok");
			wau.clickButton("project.button.dateAlertMsg.ok");
			wau.clickButton("project.button.copyAsNewProject.cancel");
			wau.waitVisibility("project.popup.button.yes");
			wau.clickButton("project.popup.button.yes");
			wau.getLogger().log(Status.PASS,"Verify copy as new project template with date validation");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL,"Unable to verify copy as new project template with date validation");
			e.printStackTrace();
		}
	}

	private void copyAsNewTemplateWithValidData()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_65  PMTC- Copy as new template with valid data");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.copyAsTemplate");
			wau.clickButton("project.tab.copyAsTemplate");
			wau.waitVisibility("project.button.save");
			wau.sendInput("project.field.copyAsTemplate.templateName", DataProperties.getProperty("project.field.copyAsNewProject.projectName"));
			wau.isUncheck("project.button.isCopyTask");
			wau.isUncheck("project.button.isCopyReview");
			wau.clickButton("project.button.save");
			wau.isTextToBePresent("project.field.projectName", DataProperties.getProperty("project.field.copyAsNewTemplate.templateName"));
			wau.waitVisibility("project.button.copyAsNewProject.cancel");
			wau.waitClickable("project.button.create.save");
			wau.clickButtonByJS("project.button.create.save");
			if(wau.isDisplay("project.alertMsg.popup.projectAdded")==true)
			{
				wau.waitInvisibility("project.alertMsg.popup.projectAdded");
			}else
			{
				RamboUtil.pause(5000);
			}
			wau.waitVisibility("project.tab.create.tasks");
			wau.waitClickable("project.tab.create.tasks");
			wau.clickTab("project.tab.create.tasks");
			wau.clickTab("main.tab.projects");
			wau.getLogger().log(Status.PASS, "Verify copy as new project template with valid data");
			wau.waitVisibility("project.button.newProject");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to veriy copy as new project template with valid data");
			e.printStackTrace();
		}

	}

	private void deleteProject()
	{
		RamboUtil.pause(1000);
		preCondition();
		wau.waitVisibility("project.list.gridView");
		if(wau.isAvailable("project.tab.projectListOfAction"))
		{
			wau.clickTab("project.tab.projectListOfAction");
		}
		else
		{
			wau.clickTab("project.tab.projectListOfAction");
		}

		wau.waitVisibility("project.tab.deleteProject");
		wau.clickButton("project.tab.deleteProject");
		wau.waitVisibility("project.text.alertMsg.deleteProject");
		wau.waitInvisibility("project.text.alertMsg.deleteProject");

	}

	private void addToCampaignWithCancel()
	{
		wau.getLogger().log(Status.INFO, "Test Case:PM_69  PMTC- Add to campaign with cancel");
		preCondition();
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.addToCampaign");
		wau.clickButton("project.tab.addToCampaign");
		wau.waitVisibility("project.addToCampaign.popup.text");
		wau.waitVisibility("project.addToCampaign.add");
		wau.clickButton("project.addToCampaign.add");
		wau.validateColor("project.addToCampaign.selectCampaign", DataProperties.getProperty("project.alertmsg.boderColor"));
		wau.clickTab("project.addToCampaign.selectCampaign");
		wau.sendInput("project.addToCampaign.selectCampaign", DataProperties.getProperty("project.field.campaignName"));
		wau.sendInput("project.addToCampaign.selectCampaign", Keys.ENTER);
		wau.clickButton("project.addToCampaign.cancel");
		wau.clickTab("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void addToCampaignWithValidInput()
	{
		wau.getLogger().log(Status.INFO, "Test Case:Pm_68,70  PMTC- Add to campaign with valid input");
		preCondition();
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.addToCampaign");
		wau.clickButton("project.tab.addToCampaign");
		wau.waitVisibility("project.addToCampaign.popup.text");
		wau.waitVisibility("project.addToCampaign.add");
		wau.clickTab("project.addToCampaign.selectCampaign");
		wau.sendInput("project.addToCampaign.selectCampaign", DataProperties.getProperty("project.field.campaignName"));
		wau.sendInput("project.addToCampaign.selectCampaign", Keys.ENTER);
		wau.waitVisibility("project.addToCampaign.add");
		wau.clickButton("project.addToCampaign.add");
		if(wau.isDisplay("project.alertMsg.addCampaign"))
		{
			wau.waitInvisibility("project.alertMsg.addCampaign");
		}
		else
		{
			RamboUtil.pause(5000);
		}
		wau.clickTab("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.goToCampaign");
		wau.clickTab("project.tab.goToCampaign");
		wau.waitVisibility("project.tab.goToCampaign.details");
		wau.clickTab("project.tab.goToCampaign.details");
		wau.waitClickable("main.tab.projects");
		wau.clickButton("main.tab.projects");
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.removeFromCampaign");
		RamboUtil.pause(1000);
		wau.clickButton("project.tab.removeFromCampaign");
		RamboUtil.pause(1000);
		wau.waitVisibility("project.button.newProject");
		if(wau.isAvailable("project.tab.projectListOfAction"))
		{
			wau.clickTab("project.tab.projectListOfAction");
		}else
		{
			wau.clickTab("project.tab.projectListOfAction");
		}
		wau.waitVisibility("project.tab.addToCampaign");
		wau.waitClickable("main.tab.projects");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void projectFavorites() {

		wau.getLogger().log(Status.INFO, "Test Case:PM_39,71  PMTC-verify with add to favorite functinality");
		String projectName = wau.getElementText("project.text.projectName");
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.addtofavoritelist");
		wau.clickButton("project.tab.addtofavoritelist");
		wau.waitVisibility("dashboard.button.favorite");
		wau.clickButton("dashboard.button.favorite");
		String expectedProjectName = RamboUtil.getAddTofavoriteListProjectName(wau.getElementText("project.text.addToFavorite.projectName"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(projectName, expectedProjectName);
		wau.waitClickable("project.addToFavorite.button.delete");
		wau.clickButton("project.addToFavorite.button.delete");
		wau.clickButton("main.tab.projects");

	}

	private void archiveProject()
	{
		wau.getLogger().log(Status.INFO, "Test Case:PM_71  PMTC-verify with add to archive project functionality");
		preCondition();
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.archiveProject");
		wau.clickButton("project.tab.archiveProject");
		wau.waitVisibility("project.archiveProject.text.alertMsg");
		wau.waitInvisibility("project.archiveProject.text.alertMsg");
		wau.clickButton("project.button.activeProject");
		wau.waitVisibility("project.button.archiveproject");
		wau.clickButton("project.button.archiveproject");
		RamboUtil.pause(500);
		wau.waitVisibility("project.tab.projectListOfAction");
		wau.clickButtonByJS("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.unArchiveProject");
		wau.clickButton("project.tab.unArchiveProject");
		wau.waitVisibility("project.activeProject.text.alertMsg");
		wau.waitInvisibility("project.activeProject.text.alertMsg");
		wau.clickButton("project.button.archiveproject");
		wau.waitVisibility("project.button.activeProject");
		wau.clickButton("project.button.activeProject");
		wau.waitVisibility("project.tab.projectListOfAction");
		wau.waitVisibility("project.button.newProject");
		wau.getLogger().log(Status.PASS, "Verify with add note to archive project successfully");

	}

	private void addNote()
	{
		addNoteWithoutMandatoryFields();

		addNoteWithValidInput();

		addNoteWithPrivateMessage();

		addNoteWithSendEmail();
	}

	private void addNoteWithoutMandatoryFields()
	{
		wau.getLogger().log(Status.INFO, "Test Case:PM_72,74  PMTC-verify with add note with cancel");
		preCondition();
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.addNote");
		wau.clickButton("project.tab.addNote");
		wau.waitVisibility("project.addNote.popup");
		wau.waitVisibility("project.addNote.popup.privateMessageButton");
		wau.waitVisibility("project.addNote.popup.sendEmailButton");
		wau.waitVisibility("project.addNote.popup.addNoteButton");
		wau.waitVisibility("project.addNote.popup.cancelButton");
		wau.clickButton("project.addNote.popup.addNoteButton");
		wau.validateColor("project.addNote.popup.messageBox", DataProperties.getProperty("project.alertmsg.boderColor"));
		wau.clickButton("project.addNote.popup.cancelButton");
	}


	private void addNoteWithValidInput()
	{
		wau.getLogger().log(Status.INFO, "Test Case:PM_73  PMTC-verify with add note with valid inputs");
		preCondition();
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.addNote");
		wau.clickButton("project.tab.addNote");
		wau.waitVisibility("project.addNote.popup");
		wau.waitVisibility("project.addNote.popup.addNoteButton");
		wau.sendInput("project.addNote.popup.messageBox", DataProperties.getProperty("project.addNote.text.messageBox"));
		wau.clickButton("project.addNote.popup.fileUploadButton");
		RamboUtil.pause(2000);
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		wau.uploadFileFromSystem();
		wau.waitVisibility("project.text.uploadComplete");
		wau.clickButton("project.addNote.popup.addNoteButton");
		wau.waitVisibility("project.addNote.text.addedNote");
		wau.waitInvisibility("project.addNote.text.addedNote");
		wau.waitVisibility("project.button.newProject");
		wau.waitClickable("project.button.newProject");
		wau.clickTab("project.text.projectName");
		wau.waitVisibility("project.tab.notes");
		wau.waitClickable("project.tab.notes");
		wau.scrollIntoView("project.tab.notes");
		wau.clickButtonByJS("project.tab.notes");
		wau.waitVisibility("project.text.addNoteText");
		wau.validateText("project.text.addNoteText", DataProperties.getProperty("project.addNote.text.messageBox"));
		wau.clickLink("project.link.addnote.ViewEntireThread");
		wau.waitVisibility("project.addNote.button.delete");
		wau.scrollIntoView("project.addNote.button.delete");
		wau.clickButtonByJS("project.addNote.button.delete");
		wau.waitVisibility("project.addNote.text.deleteNote");
		wau.waitInvisibility("project.addNote.text.deleteNote");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void addNoteWithPrivateMessage()
	{
		wau.getLogger().log(Status.INFO, "Test Case:PM_75,76  PMTC-verify with add note with private message");
		preCondition();
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.addNote");
		wau.clickButton("project.tab.addNote");
		wau.waitVisibility("project.addNote.popup");
		wau.waitVisibility("project.addNote.popup.addNoteButton");
		wau.clickButton("project.addNote.popup.privateMessageButton");
		wau.waitVisibility("project.addNote.popup.uncheckSendEmailButton");
		wau.clickButton("project.addNote.popup.uncheckSendEmailButton");
		wau.sendInput("project.addNote.popup.messageBox", DataProperties.getProperty("project.addNote.text.messageBox"));
		wau.clickButton("project.addNote.popup.SelectUser");
		wau.pressEnter();
		wau.clickButton("project.addNote.popup.fileUploadButton");
		RamboUtil.pause(2000);
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		wau.uploadFileFromSystem();
		wau.waitVisibility("project.text.uploadComplete");
		wau.clickButton("project.addNote.popup.addNoteButton");
		wau.waitVisibility("project.addNote.text.addedNote");
		wau.waitInvisibility("project.addNote.text.addedNote");
		wau.waitVisibility("project.button.newProject");
		wau.clickTab("project.text.projectName");
		wau.waitVisibility("project.tab.notes");
		wau.waitClickable("project.tab.notes");
		wau.clickButton("project.tab.notes");
		wau.waitClickable("project.addNote.button.refreshButton");
		wau.clickButton("project.addNote.button.refreshButton");
		RamboUtil.pause(1000);
		wau.waitVisibility("project.text.addNoteText");
		wau.validateText("project.text.addNoteText", DataProperties.getProperty("project.addNote.text.messageBox"));
		wau.clickLink("project.link.addnote.ViewEntireThread");
		wau.waitVisibility("project.addNote.button.delete");
		wau.clickButton("project.addNote.button.delete");
		wau.waitVisibility("project.addNote.text.deleteNote");
		wau.waitInvisibility("project.addNote.text.deleteNote");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void addNoteWithSendEmail()
	{
		wau.getLogger().log(Status.INFO, "Test Case:PM_77  PMTC-verify with add note with send email");
		preCondition();
		wau.clickTab("project.tab.projectListOfAction");
		wau.waitVisibility("project.tab.addNote");
		wau.clickButton("project.tab.addNote");
		wau.waitVisibility("project.addNote.popup");
		wau.waitVisibility("project.addNote.popup.addNoteButton");
		wau.clickButton("project.addNote.popup.sendEmailButton");
		wau.sendInput("project.addNote.popup.messageBox", DataProperties.getProperty("project.addNote.text.messageBox"));
		RamboUtil.pause(2000);
		wau.clickButtonByJS("project.addNote.popup.selectUserTrigger");
		try {
			wau.waitVisibility("project.addNote.popup.nameTester");
			wau.clickButton("project.addNote.popup.nameTester");
		}
		catch (Exception e) {
			wau.clickButtonByJS("project.addNote.popup.selectUserTrigger");
			wau.waitVisibility("project.addNote.popup.nameTester");
			wau.clickButton("project.addNote.popup.nameTester");
		}
		wau.waitVisibility("project.addNote.tagField.userName");
		wau.clickButton("project.addNote.popup.fileUploadButton");
		RamboUtil.pause(2000);
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		wau.uploadFileFromSystem();
		wau.waitVisibility("project.text.uploadComplete");
		wau.clickButton("project.addNote.popup.addNoteButton");
		if(wau.isDisplay("project.addNote.text.addedNote")==true)
		{
			wau.waitInvisibility("project.addNote.text.addedNote");
		}else
		{
			RamboUtil.pause(10000);
			wau.waitInvisibility("project.addNote.text.addedNote");
		}
		RamboUtil.pause(1000);
		wau.waitVisibility("project.button.newProject");
		wau.clickTab("project.text.projectName");
		wau.waitVisibility("project.tab.notes");
		wau.waitClickable("project.tab.notes");
		wau.clickButtonByJS("project.tab.notes");
		wau.waitVisibility("project.text.addNoteText");
		wau.validateText("project.text.addNoteText", DataProperties.getProperty("project.addNote.text.messageBox"));
		wau.waitVisibility("project.link.addnote.ViewEntireThread");
		wau.waitClickable("project.link.addnote.ViewEntireThread");
		wau.clickLink("project.link.addnote.ViewEntireThread");
		wau.waitVisibility("project.addNote.button.delete");
		wau.clickButtonByJS("project.addNote.button.delete");
		wau.waitVisibility("project.addNote.text.deleteNote");
		wau.waitInvisibility("project.addNote.text.deleteNote");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void manageNotes()
	{
		manageNotesWithReply();

		manageNotesWithDelete();

		manageNotesWithEntireThreadOption();
	}

	private void manageNotesWithReply()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_78  PMTC-verify with manage note with reply");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.manageNotes");
			wau.clickButton("project.tab.manageNotes");
			wau.waitVisibility("project.manageNotes.popup");
			wau.waitVisibility("project.manageNote.popup.addNoteButton");
			wau.waitVisibility("project.manageNote.popup.viewAllButton");
			wau.clickButton("project.manageNote.popup.addNoteButton");
			wau.waitVisibility("project.addNote.popup.messageBox");
			wau.sendInput("project.addNote.popup.messageBox", DataProperties.getProperty("project.addNote.text.messageBox"));
			wau.clickButton("project.addNote.popup.fileUploadButton");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.addNote.text.uploadComplete");
			wau.waitClickable("project.addNote.popup.addNoteButton");
			wau.clickButton("project.addNote.popup.addNoteButton");
			wau.waitVisibility("project.addNote.text.addedNote");
			wau.waitInvisibility("project.addNote.text.addedNote");
			wau.waitVisibility("project.link.manageNotes.reply");
			wau.clickButton("project.link.manageNotes.reply");
			wau.waitVisibility("project.manageNotes.textArea");
			/*wau.clickButton("project.manageNotes.button.cancel");
			wau.waitVisibility("project.link.manageNotes.reply");
			wau.clickButton("project.link.manageNotes.reply");
			wau.isPresent("project.manageNotes.button.addNote");
			wau.isPresent("project.manageNotes.button.cancel");*/
			wau.sendInput("project.manageNotes.textArea", DataProperties.getProperty("project.manageNotes.text.textarea"));
			wau.clickButton("project.manageNotes.button.addNote");
			wau.waitVisibility("project.manageNote.alertMsg.reply");
			wau.waitInvisibility("project.manageNote.alertMsg.reply");
			wau.waitVisibility("project.link.manageNotes.viewEntireThread");
			wau.waitVisibility("project.button.closePanel");
			wau.clickButtonByJS("project.button.closePanel");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify with manage note with reply successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unbale to verify with manage note with reply");
		}

	}

	private void manageNotesWithDelete()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_79  PMTC-verify with manage note with delete");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.manageNotes");
			wau.clickButton("project.tab.manageNotes");
			wau.waitVisibility("project.manageNotes.popup");
			wau.waitVisibility("project.link.manageNotes.delete");
			wau.isPresent("project.link.manageNotes.delete");
			wau.clickButton("project.link.manageNotes.delete");
			wau.waitVisibility("project.manageNotes.alertMsg.deleteNote");
			wau.waitInvisibility("project.manageNotes.alertMsg.deleteNote");
			wau.clickButton("project.button.closePanel");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify with manage note with delete successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify manage note with delete");
		}


	}

	private void manageNotesWithEntireThreadOption()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_80,81  PMTC-verify with manage note with entire thread option");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.manageNotes");
			wau.clickButton("project.tab.manageNotes");
			wau.waitVisibility("project.manageNotes.popup");
			wau.waitVisibility("project.manageNote.popup.addNoteButton");
			wau.waitVisibility("project.manageNote.popup.viewAllButton");
			wau.clickButton("project.manageNote.popup.addNoteButton");
			wau.waitVisibility("project.addNote.popup.messageBox");
			wau.sendInput("project.addNote.popup.messageBox", DataProperties.getProperty("project.addNote.text.messageBox"));
			wau.clickButton("project.addNote.popup.fileUploadButton");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.addNote.text.uploadComplete");
			wau.waitClickable("project.addNote.popup.addNoteButton");
			wau.clickButton("project.addNote.popup.addNoteButton");
			wau.waitVisibility("project.addNote.text.addedNote");
			wau.waitInvisibility("project.addNote.text.addedNote");
			wau.waitVisibility("project.link.manageNotes.viewEntireThread");
			wau.clickButton("project.link.manageNotes.viewEntireThread");
			wau.waitVisibility("project.manageNotes.deleteButton");
			wau.waitVisibility("project.manageNotes.editButton");
			wau.waitVisibility("project.manageNotes.replyButton");
			wau.waitVisibility("project.manageNotes.getLinkButton");

			wau.clickButton("project.manageNotes.editButton");
			wau.clearAndWait("project.manageNotes.textArea");
			wau.sendInput("project.manageNotes.textArea", DataProperties.getProperty("project.manageNote.text.editMessage"));
			wau.waitVisibility("project.manageNote.button.updateNote");
			wau.clickButton("project.manageNote.button.updateNote");
			wau.waitVisibility("project.manageNote.alertMsg.updateNote");
			wau.waitInvisibility("project.manageNote.alertMsg.updateNote");

			wau.waitVisibility("project.manageNotes.getLinkButton");
			wau.clickButton("project.manageNotes.getLinkButton");
			wau.waitVisibility("project.manageNote.popup.copyLinkCancelButton");
			wau.clickButton("project.manageNote.popup.copyLinkCancelButton");
			wau.waitVisibility("project.manageNotes.getLinkButton");
			wau.clickButton("project.manageNotes.getLinkButton");
			wau.waitVisibility("project.manageNote.popup.copyClipboardButton");
			wau.clickButton("project.manageNote.popup.copyClipboardButton");
			wau.waitVisibility("project.manageNote.alertMsg.copyLink");
			wau.waitInvisibility("project.manageNote.alertMsg.copyLink");

			wau.waitVisibility("project.manageNotes.replyButton");
			wau.clickButton("project.manageNotes.replyButton");
			wau.waitVisibility("project.manageNote.popup.replyMessageTextBox");
			wau.isPresent("project.manageNote.popup.replyCancelButton");
			wau.clickButton("project.manageNote.popup.replyCancelButton");
			wau.waitVisibility("project.manageNotes.replyButton");
			wau.clickButton("project.manageNotes.replyButton");
			wau.waitVisibility("project.manageNote.popup.replyAddNoteButton");
			wau.isPresent("project.manageNote.popup.replyAddNoteButton");
			wau.clickButton("project.manageNote.popup.replyAddNoteButton");
			wau.validateColor("project.manageNote.popup.replyMessageTextBox", DataProperties.getProperty("project.alertmsg.boderColor"));
			wau.sendInput("project.manageNote.popup.replyMessageTextBox", DataProperties.getProperty("project.manageNote.text.replymessage"));
			wau.clickButton("project.manageNote.popup.replyAddNoteButton");
			wau.waitVisibility("project.manageNote.alertMsg.reply");
			wau.waitInvisibility("project.manageNote.alertMsg.reply");

			wau.waitVisibility("project.manageNotes.deleteButton");
			wau.clickButton("project.manageNotes.deleteButton");
			wau.waitVisibility("project.manageNotes.alertMsg.deleteNote");
			wau.waitInvisibility("project.manageNotes.alertMsg.deleteNote");
			wau.waitVisibility("project.button.closePanel");
			wau.clickButton("project.button.closePanel");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify with manage note with entire thread option successfully");

		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify manage note with entire thread option");
		}

	}

	private void getLink()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:PM_85,85  PMTC-verify with get link ");
			preCondition();
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.getLink");
			wau.clickButton("project.tab.getLink");
			wau.waitVisibility("project.getLink.popup");
			wau.waitVisibility("project.getLink.button.copyClipboard");
			wau.waitVisibility("project.getLink.button.cancel");
			wau.clickButton("project.getLink.button.cancel");
			wau.waitVisibility("project.tab.projectListOfAction");
			wau.clickTab("project.tab.projectListOfAction");
			wau.waitVisibility("project.tab.getLink");
			wau.clickButton("project.tab.getLink");
			wau.waitVisibility("project.getLink.popup");
			wau.waitVisibility("project.getLink.button.copyClipboard");
			wau.clickButton("project.getLink.button.copyClipboard");
			wau.waitVisibility("project.getLink.alertMsg.copyClipboard");
			wau.waitInvisibility("project.getLink.alertMsg.copyClipboard");
			wau.waitVisibility("project.button.newProject");
			wau.getLogger().log(Status.PASS, "Verify with get link successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify with get link ");
		}

	}

	private void projectSummary()
	{
		projectSummaryNavigation();

		projectSummarySettingIconFunctionality();
	}

	private void projectSummaryNavigation()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-verify with project summary navigation ");
		wau.clickButton("project.name.summaryAction");
		wau.waitVisibility("project.tab.summary");
		wau.clickButton("project.tab.summary");
		String recentActivity = wau.getElementText("project.summary.recentActivity");
		System.out.println(recentActivity);
		wau.clickTab("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void projectSummarySettingIconFunctionality()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-PM_89 verify with project summary setting icon functionality ");
		wau.waitVisibility("project.name.summaryAction");
		wau.clickButtonByJS("project.name.summaryAction");
		wau.waitVisibility("project.tab.summary");
		wau.waitClickable("project.tab.summary");
		wau.clickTab("project.tab.summary");
		wau.waitVisibility("project.summary.button.settingIcon");
		wau.waitClickable("project.summary.button.settingIcon");
		wau.scrollIntoView("project.summary.button.settingIcon");
		wau.clickButtonByJS("project.summary.button.settingIcon");
		wau.waitVisibility("project.summary.settingIcon.window");
		wau.waitClickable("project.summary.settingIcon.cancelButton");
		wau.clickButton("project.summary.settingIcon.cancelButton");
		wau.waitVisibility("project.summary.button.settingIcon");
		wau.waitClickable("project.summary.button.settingIcon");
		wau.clickButton("project.summary.button.settingIcon");
		wau.waitVisibility("project.summary.settingIcon.window");
		wau.waitClickable("project.summary.settingIcon.applyButton");
		wau.waitVisibility("project.summary.settingIcon.burndownChart");
		wau.waitVisibility("project.summary.settingIcon.totalCost");
		wau.scrollIntoView("project.summary.settingIcon.burndownChart");
		wau.clickButtonByJS("project.summary.settingIcon.burndownChart");
		wau.scrollIntoView("project.summary.settingIcon.totalCost");
		wau.clickButtonByJS("project.summary.settingIcon.totalCost");
		wau.clickButton("project.summary.settingIcon.applyButton");
		wau.waitVisibility("project.summary.button.settingIcon");
		wau.waitVisibility("project.summary.text.burndownChart");
		wau.waitVisibility("project.summary.text.totalCost");
		wau.waitVisibility("project.summary.button.settingIcon");
		wau.waitClickable("project.summary.button.settingIcon");
		wau.clickButton("project.summary.button.settingIcon");
		wau.waitVisibility("project.summary.settingIcon.window");
		wau.waitClickable("project.summary.settingIcon.applyButton");
		wau.waitVisibility("project.summary.settingIcon.burndownChart");
		wau.waitVisibility("project.summary.settingIcon.totalCost");
		wau.scrollIntoView("project.summary.settingIcon.burndownChart");
		wau.clickButtonByJS("project.summary.settingIcon.burndownChart");
		wau.scrollIntoView("project.summary.settingIcon.totalCost");
		wau.clickButtonByJS("project.summary.settingIcon.totalCost");
		wau.clickButton("project.summary.settingIcon.applyButton");
		wau.waitInvisibility("project.summary.text.burndownChart");
		wau.waitInvisibility("project.summary.text.totalCost");
		wau.waitVisibility("main.tab.projects");
		wau.clickTab("main.tab.projects");

	}

	private void createTask()
	{
		createTaskWithoutMandatoryFields();

		createTaskWithDateValidation();

		createTaskWithMandatoryFields();

		exportProjectToPDF();

		exportTaskListView();

		exportTaskShedulingView();

		modifyTask();

		setTaskStatus();

		taskAddToFavorites();

		addNoteOnTaskWithSendEmail();

		addNoteOnTaskWithPrivateMessage();

		manageNoteOnTask();

		getLinktask();

		taskAsendingAndDecendingOrder();

		pageNavigationTaskTab();

		projectReviewTabNavigation();
	}

	private void createTaskWithoutMandatoryFields()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  PMTC-91,92 verify with create task without mandatory fields ");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.tab.task.projectName");
			wau.clickButton("project.tab.task.projectName");
			wau.waitVisibility("project.tab.tasks");
			wau.clickTab("project.tab.tasks");
			wau.waitVisibility("project.button.task.newTask");
			wau.waitVisibility("project.button.task.importTask");
			wau.waitVisibility("project.button.task.shedulingView");
			wau.waitVisibility("project.button.task.exportGanntChart");
			wau.waitVisibility("project.button.task.refresh");
			wau.clickButton("project.button.task.newTask");
			wau.waitVisibility("project.button.task.save");
			wau.waitVisibility("project.button.task.cancel");
			wau.waitVisibility("project.button.task.saveAndAddAnother");
			wau.clickButton("project.button.task.save");
			wau.waitVisibility("project.task.alertMsg.popup");
			wau.waitVisibility("project.task.alertMsg");
			wau.waitVisibility("project.task.alertMsg.okButton");
			wau.clickButton("project.task.alertMsg.okButton");
			wau.sendInput("project.field.task.taskName", DataProperties.getProperty("project.createTask.taskName"));
			wau.clickButton("project.button.task.save");
			wau.waitVisibility("project.task.alertMsg.popup");
			wau.waitVisibility("project.task.alertMsg");
			wau.waitVisibility("project.task.alertMsg.okButton");
			wau.clickButton("project.task.alertMsg.okButton");
			wau.clickButton("project.button.task.cancel");
			wau.clickButton("project.task.warningMsg.YesButton");
			wau.getLogger().log(Status.PASS, "Verify with create task without mandatory fields successfully");
			wau.waitVisibility("main.tab.projects");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify with create task without mandatory fields ");
		}

	}

	private void createTaskWithDateValidation()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  PMTC-Extra validation verify with create task with date validation ");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.tab.task.projectName");
			wau.clickButtonByJS("project.tab.task.projectName");
			wau.waitVisibility("project.tab.tasks");
			wau.clickTab("project.tab.tasks");
			wau.waitVisibility("project.button.task.newTask");
			wau.clickButton("project.button.task.newTask");
			wau.waitVisibility("project.button.task.save");
			wau.sendInput("project.field.task.taskName", DataProperties.getProperty("project.createTask.taskName"));
			wau.scrollIntoView("project.field.task.startDate");
			wau.sendInput("project.field.task.startDate", RamboUtil.startDates());
			wau.scrollIntoView("project.field.task.dueDate");
			wau.sendInput("project.field.task.dueDate", RamboUtil.previousDate());
			wau.clickButtonByJS("project.button.task.save");
			if(wau.isDisplay("project.task.alertMsg.startDateIsOnWeekend")==true)
			{
				wau.clickButton("project.task.alertMsg.startDateIsOnweeked.okButton");
				wau.clearAndWait("project.field.task.startDate");
				wau.sendInput("project.field.task.startDate", RamboUtil.changeDate(2));
				wau.clickButtonByJS("project.button.task.save");
			}else if(wau.isDisplay("project.task.alertMsg.dueDateIsOnWeekend")==true)
			{
				wau.clickButton("project.task.alertMsg.dueDateIsOnWeekend.okButton");
				wau.clearAndWait("project.field.task.dueDate");
				wau.sendInput("project.field.task.dueDate", RamboUtil.changeDate(2));
				wau.clickButtonByJS("project.button.task.save");
			}else if(wau.isDisplay("project.task.alertMsg.startDateIsOnHollyday")==true)
			{
				wau.clickButton("project.task.alertMsg.startDateIsOnHollyday.okButton");
				wau.clearAndWait("project.field.task.startDate");
				wau.sendInput("project.field.task.startDate", RamboUtil.changeDate(2));
				wau.clickButtonByJS("project.button.task.save");
			}else if(wau.isDisplay("project.task.alertMsg.dueDateIsOnHollyday")==true)
			{
				wau.clickButton("project.task.alertMsg.dueDateIsOnHollyday.okButton");
				wau.clearAndWait("project.field.task.dueDate");
				wau.sendInput("project.field.task.dueDate", RamboUtil.changeDate(2));
				wau.clickButtonByJS("project.button.task.save");
			}

			wau.waitVisibility("project.task.alertMsg.popup");
			wau.waitVisibility("project.task.alertMsg.datevalidation");
			wau.isPresent("project.task.dateAlertMsg.okButton");
			wau.clickButton("project.task.dateAlertMsg.okButton");
			wau.clickButton("project.button.task.cancel");
			wau.waitVisibility("project.task.warningMsg.YesButton");
			wau.clickButton("project.task.warningMsg.YesButton");
			wau.getLogger().log(Status.PASS, "Verify with create task with date validation ");
			wau.waitVisibility("main.tab.projects");
			wau.clickTab("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify with create task with date validation ");
		}


	}

	private void createTaskWithMandatoryFields()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-90 verify with create task with mandatory fields ");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButtonByJS("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.clickButton("project.button.task.newTask");
		wau.waitVisibility("project.button.task.save");
		wau.sendInput("project.field.task.taskName", DataProperties.getProperty("project.createTask.taskName"));
		wau.clickTab("project.field.task.assignTo");
		wau.sendInput("project.field.task.assignTo", DataProperties.getProperty("project.createTask.assignedTo"));
		wau.sendInput("project.field.task.assignTo", Keys.ENTER);
		wau.clickTab("project.field.task.taskRole");
		wau.sendInput("project.field.task.taskRole", DataProperties.getProperty("project.createTask.taskRole"));
		wau.sendInput("project.field.task.taskRole", Keys.ENTER);
		wau.sendInput("project.field.task.taskId", DataProperties.getProperty("project.createTask.taskId"));
		wau.sendInput("project.field.task.startDate", RamboUtil.startDates());
		wau.sendInput("project.field.task.dueDate", RamboUtil.EndDates());
		RamboUtil.pause(1000);
		wau.clickTab("project.field.task.predecessor");
		wau.sendInput("project.field.task.predecessor", DataProperties.getProperty("project.createTask.predecessor"));
		wau.sendInput("project.field.task.predecessor", Keys.ENTER);
		wau.clearAndWait("project.field.task.taskStatus");
		wau.clickTab("project.field.task.taskStatus");
		wau.sendInput("project.field.task.taskStatus", DataProperties.getProperty("project.createTask.taskStatus"));
		wau.sendInput("project.field.task.taskStatus", Keys.ENTER);
		wau.clickButtonByJS("project.button.task.save");
		if(wau.isDisplay("project.task.warningMsg")==true)
		{
			if(wau.isDisplay("project.task.warningMsg.sheduleOverlap")==true)
			{
				wau.clickButton("project.task.button.submit");
			}else if(wau.isDisplay("project.task.warningMsg.taskDateExceed")==true)
			{
				wau.clickButtonByJS("project.task.button.submit");
			}
		}else {}
		wau.waitInvisibility("project.task.warningMsg.addedTask");
		deleteTask();


	}

	private void deleteTask()
	{
		RamboUtil.pause(1000);
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickTab("project.task.projectTaskAction");
		wau.waitVisibility("project.projectTaskAction.tab.delete");
		wau.clickButton("project.projectTaskAction.tab.delete");
		wau.waitVisibility("project.task.warningMsg.deleteTask");
		wau.waitInvisibility("project.task.warningMsg.deleteTask");
		wau.clickTab("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void exportProjectToPDF()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-93 verify export project to PDf ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.isPresent("project.createTask.button.actions");
		wau.clickButton("project.createTask.button.actions");
		wau.waitVisibility("project.createTask.actions.saveAsPDF");
		wau.clickButton("project.createTask.actions.saveAsPDF");

	}

	private void exportTaskListView()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-94 verify export task list");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.button.task.shedulingView");
		wau.clickButton("project.button.task.shedulingView");
		wau.waitVisibility("project.button.task.menuListView");
		wau.clickButton("project.button.task.menuListView");
		wau.clickButton("project.button.task.exportTaskList");
		RamboUtil.pause(5000);
		wau.getLogger().log(Status.PASS, "Download task list file successfully");
		String downloadPath = "C:\\Users\\jkj\\Downloads";
		String ExpectedFileName = "Task List.xlsx";
		RamboUtil.verifyFileDownload(downloadPath,ExpectedFileName);
		wau.getLogger().log(Status.PASS, "Verify download task list file successfully");
		RamboUtil.isFileDownloaded(downloadPath, ExpectedFileName);
		wau.getLogger().log(Status.PASS, "Downloaded task list file deleted successfully");
		wau.clickButton("project.button.task.listView");
		wau.waitVisibility("project.button.task.shedulingView");
		wau.clickButton("project.button.task.shedulingView");
		wau.clickTab("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void exportTaskShedulingView()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-95 verify export task sheduling view");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.button.task.shedulingView");
		//wau.clickButton("project.button.task.exportGanntChart");//
	}

	private void modifyTask()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-96 verify modify task ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickButton("project.task.projectTaskAction");
		wau.waitVisibility("project.projectTaskAction.modifyTask");
		wau.clickButtonByJS("project.projectTaskAction.modifyTask");
		wau.waitVisibility("project.field.task.taskName");
		wau.waitVisibility("project.button.task.save");
		RamboUtil.pause(1000);
		wau.clearAndWait("project.field.task.taskName");
		wau.sendInput("project.field.task.taskName", DataProperties.getProperty("project.field.modifyTask.taskName"));
		wau.clickButtonByJS("project.button.task.save");
		wau.waitVisibility("project.task.alertMsg.taskUpdate");
		wau.getLogger().log(Status.PASS, "Modify task successfully");
		wau.clickTab("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void setTaskStatus()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-97 verify set task status ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickButton("project.task.projectTaskAction");
		wau.waitVisibility("project.projectTaskAction.setTaskStatus");
		wau.mouseHover("project.projectTaskAction.setTaskStatus");
		wau.waitVisibility("project.projectTaskAction.setTaskStatus.inProgress");
		wau.clickButtonByJS("project.projectTaskAction.setTaskStatus.inProgress");
		wau.waitVisibility("project.task.alertMsg.taskStatusUpdate");
		wau.waitInvisibility("project.task.alertMsg.taskStatusUpdate");
		wau.getLogger().log(Status.PASS, "Set task status successfully");
		wau.waitVisibility("project.field.task.taskStatus");
		String expectedStatus = wau.getElementText("project.field.task.taskStatus");
		wau.clickButtonByJS("project.field.task.projectName");
		wau.waitVisibility("project.task.taskDetailsWindow");
		wau.waitVisibility("project.task.taskDetailsWindow.status");
		wau.waitVisibility("project.task.taskDetailsWindow.statusName");
		wau.validateText("project.task.taskDetailsWindow.statusName", expectedStatus);
		wau.clickButton("project.task.taskDetailsWindow.closePanel");
		wau.getLogger().log(Status.PASS, "Set task status successfully");
		wau.clickTab("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void taskAddToFavorites()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-98 verify add task to favorite ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickButton("project.task.projectTaskAction");
		wau.waitVisibility("project.projectTaskAction.tab.addToFavorites");
		wau.clickButtonByJS("project.projectTaskAction.tab.addToFavorites");
		wau.waitVisibility("project.task.alertMsg.taskAddToFavorite");
		wau.waitInvisibility("project.task.alertMsg.taskAddToFavorite");
		String expectedTaskName = wau.getElementText("project.field.task.projectName");
		wau.clickButtonByJS("project.button.favoritesList");
		wau.waitVisibility("project.task.addToFavoriteList.taskName");
		String actualtaskName = RamboUtil.getAddToFavoriteListTaskName(wau.getElementText("project.task.addToFavoriteList.taskName"));
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualtaskName, expectedTaskName);
		wau.waitClickable("project.addToFavorite.button.delete");
		wau.clickButton("project.addToFavorite.button.delete");
		wau.clickButton("main.tab.projects");

	}

	private void addNoteOnTaskWithSendEmail()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-99 verify add note on task send email ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickButton("project.task.projectTaskAction");
		wau.waitVisibility("project.projectTaskAction.tab.addNote");
		wau.clickButtonByJS("project.projectTaskAction.tab.addNote");
		wau.waitVisibility("project.task.addNote.popup");
		wau.waitVisibility("project.task.addNote.sendEmailbutton");
		wau.waitVisibility("project.task.addNote.addNoteButton");
		wau.waitVisibility("project.task.addNote.cancelButton");
		wau.sendInput("project.task.addNote.messageBox", DataProperties.getProperty("project.field.addNote.emailNote"));
		wau.clickButton("project.task.addNote.fileUploadButton");
		RamboUtil.pause(2000);
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		wau.uploadFileFromSystem();
		wau.waitVisibility("project.task.addNote.uploadComplete");
		wau.clickButtonByJS("project.task.addNote.addNoteButton");
		wau.waitVisibility("project.task.addNote.noteAdded");
		wau.waitInvisibility("project.task.addNote.noteAdded");
		wau.waitVisibility("main.tab.projects");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void addNoteOnTaskWithPrivateMessage()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-100 verify add note on task with private message ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickButton("project.task.projectTaskAction");
		wau.waitVisibility("project.projectTaskAction.tab.addNote");
		wau.clickButtonByJS("project.projectTaskAction.tab.addNote");
		wau.waitVisibility("project.task.addNote.popup");
		wau.clickButton("project.task.addNote.privateMessage");
		wau.clickButton("project.task.addNote.sendEmailbutton");
		wau.sendInput("project.task.addNote.messageBox", DataProperties.getProperty("project.field.addNote.privateMessage"));
		wau.clickButton("project.task.addNote.fileUploadButton");
		RamboUtil.pause(2000);
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		wau.uploadFileFromSystem();
		wau.waitVisibility("project.task.addNote.uploadComplete");
		wau.clickButtonByJS("project.task.addNote.addNoteButton");
		wau.waitVisibility("project.task.addNote.noteAdded");
		wau.waitInvisibility("project.task.addNote.noteAdded");
		wau.waitVisibility("main.tab.projects");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void manageNoteOnTask()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-101 verify manage note on task ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickButton("project.task.projectTaskAction");
		wau.waitVisibility("project.projectTaskAction.tab.manageNote");
		wau.clickButtonByJS("project.projectTaskAction.tab.manageNote");
		wau.waitVisibility("project.task.manageNote.popup");
		wau.waitVisibility("project.link.task.manageNote.replyButton");
		wau.waitVisibility("project.link.task.manageNote.deleteButton");
		wau.waitVisibility("project.link.task.manageNote.viewEntireThread");
		wau.waitVisibility("project.button.task.manageNote.closePanel");
		wau.clickButtonByJS("project.link.task.manageNote.viewEntireThread");
		wau.waitVisibility("project.task.manageNotes.deleteButton");
		wau.waitVisibility("project.task.manageNotes.editButton");
		wau.waitVisibility("project.task.manageNotes.replyButton");
		wau.waitVisibility("project.task.manageNotes.getLinkButton");

		wau.clickButtonByJS("project.task.manageNotes.editButton");
		wau.waitVisibility("project.task.manageNote.updateTextMessage");
		wau.waitVisibility("project.task.manageNote.updateNoteButton");
		wau.clearAndWait("project.task.manageNote.updateTextMessage");
		wau.sendInput("project.task.manageNote.updateTextMessage", DataProperties.getProperty("project.task.manageNote.field.updateMessage"));
		wau.clickButtonByJS("project.task.manageNote.updateNoteButton");
		wau.waitVisibility("project.task.manageNote.alertMsg.updateNote");
		wau.waitInvisibility("project.task.manageNote.alertMsg.updateNote");

		wau.waitVisibility("project.task.manageNotes.replyButton");
		wau.clickButtonByJS("project.task.manageNotes.replyButton");
		wau.waitVisibility("project.task.manageTask.replyMessage");
		wau.waitVisibility("project.task.manageTask.replyAddNoteButton");
		wau.sendInput("project.task.manageTask.replyMessage", DataProperties.getProperty("project.task.manageNote.field.replyMessage"));
		wau.clickButtonByJS("project.task.manageTask.replyAddNoteButton");
		wau.waitVisibility("project.task.manageNote.alertMsg.reply");
		wau.waitInvisibility("project.task.manageNote.alertMsg.reply");

		wau.waitVisibility("project.task.manageNotes.getLinkButton");
		wau.clickButtonByJS("project.task.manageNotes.getLinkButton");
		wau.waitVisibility("project.task.manageNote.popup.getLink");
		wau.waitVisibility("project.task.manageNote.popup.copyClipboardButton");
		wau.waitVisibility("project.task.manageNote.popup.copyLinkCancelButton");
		wau.clickButton("project.task.manageNote.popup.copyClipboardButton");
		wau.waitVisibility("project.task.manageNote.alertMsg.copyLink");
		wau.waitInvisibility("project.task.manageNote.alertMsg.copyLink");
		wau.openTab();
		wau.pasteValue();
		wau.pressEnter();
		RamboUtil.pause(7000);
		wau.closeTab();

		wau.waitVisibility("project.task.manageNotes.deleteButton");
		wau.clickButtonByJS("project.task.manageNotes.deleteButton");
		wau.waitVisibility("project.task.manageNotes.alertMsg.deleteNote");
		wau.waitInvisibility("project.task.manageNotes.alertMsg.deleteNote");
		wau.waitVisibility("project.button.task.manageNote.closePanel");
		wau.clickButtonByJS("project.button.task.manageNote.closePanel");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void getLinktask()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-102 verify get link task ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.clickButton("project.task.projectTaskAction");
		wau.waitVisibility("project.task.button.getLink");
		wau.clickButtonByJS("project.task.button.getLink");
		wau.waitVisibility("project.task.getLink.popup");
		wau.waitVisibility("project.task.getLink.copyClipBoardButton");
		wau.waitVisibility("project.task.getLink.copyLinkCancelButton");
		wau.clickButton("project.task.getLink.copyClipBoardButton");
		wau.openTab();
		wau.pasteValue();
		wau.pressEnter();
		RamboUtil.pause(7000);
		wau.closeTab();
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void taskAsendingAndDecendingOrder()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-104-105 verify task asending and decending order ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.task.projectTaskAction");
		wau.waitVisibility("project.task.tab.taskID");
		wau.clickButton("project.task.tab.taskID");
		List<WebElement> taskNames = wau.getList("project.taskList.taskName");
		int noOfTask = taskNames.size();
		System.out.println(noOfTask);
		for (WebElement taskName : taskNames) {
			System.out.println(taskName);
		}
	}

	private void pageNavigationTaskTab()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-106 verify task page navigation ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.tasks");
		wau.clickTab("project.tab.tasks");
		wau.waitVisibility("project.button.task.newTask");
		wau.waitVisibility("project.button.task.shedulingView");
		wau.clickButton("project.button.task.shedulingView");
		wau.waitVisibility("project.button.task.menuListView");
		wau.clickButton("project.button.task.menuListView");
		wau.waitVisibility("project.taskList.page.text");
		int maxTaskListPages = RamboUtil.getMaxPages(wau.getElementText("project.taskList.page.text"));
		System.out.println(maxTaskListPages);
		wau.sendInput("project.taskList.pageTextBox.number", maxTaskListPages + "");
		wau.sendInput("project.taskList.pageTextBox.number", Keys.ENTER);
		for (int pageNum=maxTaskListPages; pageNum>=1; pageNum--) {

			wau.clickButton("project.taskList.page.previous");

		}
	}

	private void projectReview()
	{
		projectReviewTabNavigation();

		createfeedBackReviewFunctionality();

		deleteReview();
	}

	private void projectReviewTabNavigation()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-107 verify review page navigation ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButton("project.tab.task.projectName");
		wau.waitVisibility("project.tab.reviews");
		wau.clickButtonByJS("project.tab.reviews");
		wau.waitVisibility("project.review.button.newReview");
		wau.waitVisibility("project.review.button.activeReview");
		wau.waitVisibility("project.review.button.listView");
		wau.waitVisibility("project.review.button.exportListView");
		wau.waitVisibility("project.review.button.refreshButton");
		wau.waitVisibility("project.review.button.settingButton");
		wau.clickButton("project.review.headercolumn.review");
		wau.waitVisibility("project.review.button.listView");
		RamboUtil.pause(1000);
		wau.clickButton("project.review.button.listView");
		wau.waitVisibility("project.review.button.menuThumbnailView");
		wau.clickButton("project.review.button.menuThumbnailView");
		wau.waitVisibility("project.review.button.thumbnailView");
		wau.waitClickable("project.review.button.thumbnailView");
		RamboUtil.pause(1000);
		wau.clickButton("project.review.button.thumbnailView");
		wau.waitVisibility("project.review.button.menuListView");
		wau.clickButton("project.review.button.menuListView");
		RamboUtil.pause(1000);
		wau.waitVisibility("project.review.listView");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void createfeedBackReviewFunctionality()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-108 verify create review ");
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButtonByJS("project.tab.task.projectName");
		wau.waitVisibility("project.tab.reviews");
		wau.clickButtonByJS("project.tab.reviews");
		wau.waitVisibility("project.review.button.newReview");
		wau.clickButton("project.review.button.newReview");
		wau.waitVisibility("project.review.button.save");
		wau.waitVisibility("project.review.button.cancel");
		wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
		wau.clickTab("project.field.review.type");
		wau.sendInput("project.field.review.type", DataProperties.getProperty("project.createReview.reviewType"));
		wau.sendInput("project.field.review.type", Keys.ENTER);
		wau.clickTab("project.field.review.status");
		RamboUtil.pause(500);
		wau.clearAndWait("project.field.review.status");
		wau.sendInput("project.field.review.status", DataProperties.getProperty("project.createReview.reviewStatus"));
		//wau.sendInput("project.field.review.status", Keys.ENTER);
		RamboUtil.pause(500);
		wau.clickTab("project.field.review.dueDate");
		wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
		RamboUtil.pause(500);
		wau.sendInput("project.field.review.emailAddress", DataProperties.getProperty("project.createReview.emailAddress"));
		wau.sendInput("project.field.review.emailAddress", Keys.ENTER);
		wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
		wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
		wau.clickButton("project.field.review.uploadFile");
		RamboUtil.pause(2000);
		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		wau.uploadFileFromSystem();
		wau.waitVisibility("project.review.reviewProgressBar");
		wau.scrollIntoView("project.review.reviewProgressBar");
		wau.waitVisibility("project.review.file");
		wau.clickButton("project.review.button.save");
		wau.waitVisibility("project.review.reviewList");
		wau.waitVisibility("project.review.alertMsg.addedReview");
		wau.waitInvisibility("project.review.alertMsg.addedReview");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");
	}

	private void deleteReview()
	{
		RamboUtil.pause(500);
		wau.waitVisibility("project.button.newProject");
		wau.waitVisibility("project.tab.task.projectName");
		wau.clickButtonByJS("project.tab.task.projectName");
		wau.waitVisibility("project.tab.reviews");
		wau.clickButtonByJS("project.tab.reviews");
		wau.waitVisibility("project.review.button.newReview");
		wau.waitVisibility("project.review.reviewList");
		wau.waitVisibility("project.review.projectReviewAction");
		wau.clickTab("project.review.projectReviewAction");
		wau.waitVisibility("project.review.reviewAction.reviewDelete");
		wau.clickButton("project.review.reviewAction.reviewDelete");
		wau.waitVisibility("project.review.alertMsg.deletedReview");
		wau.waitInvisibility("project.review.alertMsg.deletedReview");
		wau.clickButton("main.tab.projects");
		wau.waitVisibility("project.button.newProject");

	}

	private void projectFilterByFunctionality()
	{
		filterByWithFavoriteFunctinality();

		filterByWithTagsFunctionality();

		filterByWithColumnFunctionality();
	}

	private void filterByCountNumberOfProjects(String name)
	{
		RamboUtil.pause(200);
		int maxPages = RamboUtil.getMaxPages(wau.getElementText("project.label.numberOfPagesAvailable"));
		System.out.println(maxPages);
		int count=0;
		int totalCount=0;

		for(int i=1;i<=maxPages;i++)
		{
			RamboUtil.pause(500);
			List<WebElement> list =wau.getList("project.projectList.ProjectName");
			count = list.size();
			System.out.println(count);
			totalCount = totalCount+count;
			System.out.println(totalCount);
			String value = wau.getAttribute("project.list.page.next",DataProperties.getProperty("project.button.next"));
			if(value.contentEquals("false"))
			{
				wau.clickButtonByJS("project.list.page.next");
			}else {}
		}
		wau.getLogger().log(Status.PASS, "Total no of "+name+" project are " +totalCount);
	}

	private void filterByWithFavoriteFunctinality()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-109 verify filter by favorite functionality ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.favoriteButton");
		wau.clickButton("project.button.filterBy.favoriteButton");
		wau.waitVisibility("project.list.gridView");
		String name = "favorites";
		filterByCountNumberOfProjects(name);
		wau.waitVisibility("project.text.message.filterByFavoriteApplied");
		wau.waitVisibility("project.button.filterByFavoriteApplied.close");
		wau.clickButton("project.button.filterByFavoriteApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Filter with favorite projects applied successfully");
	}

	private void filterByWithTagsFunctionality()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-110 verify filter by tags functionality ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.tagsButton");
		wau.clickButton("project.button.filterBy.tagsButton");
		wau.waitVisibility("project.popup.filterByTags");
		wau.waitVisibility("project.popup.filterByTags.cancelButton");
		wau.waitVisibility("project.popup.filterByTags.submitButton");
		wau.waitVisibility("project.popup.filterByTags.checkRadioButton");
		wau.clickButton("project.popup.filterByTags.checkRadioButton");
		wau.clickButtonByJS("project.popup.filterByTags.submitButton");
		wau.waitVisibility("project.list.gridView");
		String name = "tags";
		filterByCountNumberOfProjects(name);
		wau.waitVisibility("project.text.message.filterByTagsApplied");
		wau.waitVisibility("project.button.filterByTagsApplied.close");
		wau.clickButton("project.button.filterByTagsApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Filter with tags projects applied successfully");
	}

	private void filterByWithColumnFunctionality()
	{
		filterByWithoutMandatoryFields();

		projectNamewithIsOption();

		projectNameWithIsNotOption();

		projectNameWithContainsOptions();

		projectNameWithDoesNotContainsOptions();

		projectNameWithBeginsWithBeginsWithOption();

		projectNameWithEndsWithOption();

		projectPlannedDateWithIsOnOption();

		projectPlanneddDateWithIsBeforeOption();

		projectPlannedDateWithIsAfterOption();

		projectPlannedDateWithIsBetweenOptionDateValidation();

		projectPlannedDateWithIsBetweenOption();

		projectPlannedDateWithinXDaysBeforeCurrentDateOption();

		projectPlannedDateWithinXDaysAfterCurrentDateOption();

		projectDueDateWithIsOnOption();

		projectDueDateWithIsBeforeOption();

		projectDueDateWithIsAfterOption();

		projectDueDateWithIsBetweenOptionDateValidation();

		projectDueDateWithIsBetweenOption();

		projectDueDateWithinXDaysBeforeCurrentDateOption();

		projectDueDateWithinXDaysAfterCurrentDateOption();

		projectClientWithIncludeOption();

		projectClientWithDoesNotIncludeOption();

		projectStatusWithIncludesOption();

		projectStatusWithDoesNotIncludesOption();
	}

	private void filterByWithoutMandatoryFields()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-Extra Validation verify filter by without mandatory fields ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.alertPopup.filterBy");
		wau.waitVisibility("project.text.errorMessage.filterBy");
		wau.waitClickable("project.button.errorMessage.filterBy.okButton");
		wau.clickButton("project.button.errorMessage.filterBy.okButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectName");
		wau.clickTab("project.text.columnList.projectName");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isOption"))
		{
			wau.clickButton("project.filterByColumn.isOption");
		}else
		{
			wau.clickTab("project.select.option");
			wau.clickButton("project.filterByColumn.isOption");
		}

		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.alertPopup.filterBy");
		wau.waitVisibility("project.text.errorMessage.filterBy");
		wau.waitClickable("project.button.errorMessage.filterBy.okButton");
		wau.clickButton("project.button.errorMessage.filterBy.okButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.alertPopup.filterBy");
		wau.waitVisibility("project.text.errorMessage.filterBy");
		wau.waitClickable("project.button.errorMessage.filterBy.okButton");
		wau.clickButton("project.button.errorMessage.filterBy.okButton");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.clickButton("project.popup.filterByColumn.cancelButton");
		wau.getLogger().log(Status.PASS, "verify filter by without mandatory fields successfully ");
	}

	private void projectNamewithIsOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-111 verify filter by column project name with 'Is' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectName");
		wau.clickTab("project.text.columnList.projectName");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isOption"))
		{
			wau.clickTab("project.filterByColumn.isOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isOption");
		}
		RamboUtil.pause(200);
		wau.waitVisibility("project.filterByColumn.keywords");
		wau.sendInput("project.filterByColumn.keywords", DataProperties.getProperty("project.text.isOption"));
		String expectedProjectName = wau.getAttributeValue("project.filterByColumn.keywords");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.list.gridView");
		filterByUtility(expectedProjectName);
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project name with 'IS' option applyed successfully ");
	}

	public void filterByUtility(String expectedProjectName)
	{
		RamboUtil.pause(200);
		int maxPages = RamboUtil.getMaxPages(wau.getElementText("project.label.numberOfPagesAvailable"));
		System.out.println(maxPages);
		int count=0;
		int totalCount=0;

		for(int i=1;i<=maxPages;i++)
		{
			RamboUtil.pause(500);
			List<WebElement> list =wau.getList("project.projectList.ProjectName");
			count = list.size();
			System.out.println(count);
			totalCount = totalCount+count;
			System.out.println(totalCount);
			String value = wau.getAttribute("project.list.page.next",DataProperties.getProperty("project.button.next"));
			for (WebElement projectName : list) 
			{

				String name = projectName.getText();
				if(name.contentEquals(expectedProjectName))
				{
					System.out.println(name);
					wau.getLogger().log(Status.INFO,"Project name is present in the list");
				}

				else if(name.contains(expectedProjectName))
				{
				}

			}

			if(value.contentEquals("false"))
			{
				wau.clickButtonByJS("project.list.page.next");
			}else {}
		}
		wau.getLogger().log(Status.PASS, "Total no of project are " +totalCount);
	}

	private void projectNameWithIsNotOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-112 verify filter by column project name with 'Is Not' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectName");
		wau.clickTab("project.text.columnList.projectName");
		RamboUtil.pause(200);
		wau.waitVisibility("project.select.option");
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		//RamboUtil.pause(200);
		if(wau.isAvailable("project.filterByColumn.isNotOption"))
		{
			wau.clickTab("project.filterByColumn.isNotOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isNotOption");
		}
		wau.waitVisibility("project.filterByColumn.keywords");
		wau.sendInput("project.filterByColumn.keywords", DataProperties.getProperty("project.text.isNotOption"));
		String expectedProjectName = wau.getAttributeValue("project.filterByColumn.keywords");
		System.out.println(expectedProjectName);
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(500);
		filterByUtility(expectedProjectName);

		wau.waitVisibility("project.list.page.previous");
		wau.waitClickable("project.list.page.previous");
		wau.clickButtonByJS("project.list.page.previous");

		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project name with 'IS NOT' option applyed successfully ");
	}

	private void projectNameWithContainsOptions()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-113 verify filter by column project name with 'Contains' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectName");
		wau.clickTab("project.text.columnList.projectName");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.containsOption"))
		{
			wau.clickTab("project.filterByColumn.containsOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.containsOption");
		}
		wau.waitVisibility("project.filterByColumn.keywords");
		wau.sendInput("project.filterByColumn.keywords", DataProperties.getProperty("project.text.containsOption"));
		String expectedProjectName = wau.getAttributeValue("project.filterByColumn.keywords");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.list.gridView");
		filterByUtility(expectedProjectName);
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project name with 'Contains' option applyed successfully ");
	}

	private void projectNameWithDoesNotContainsOptions()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-114 verify filter by column project name with 'Does Not Contains' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectName");
		wau.clickTab("project.text.columnList.projectName");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.containsOption"))
		{
			wau.clickTab("project.filterByColumn.doesNotContainOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.doesNotContainOption");
		}
		wau.waitVisibility("project.filterByColumn.keywords");
		wau.sendInput("project.filterByColumn.keywords", DataProperties.getProperty("project.text.doesNotContains"));
		String expectedProjectName = wau.getAttributeValue("project.filterByColumn.keywords");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.waitClickable("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.list.gridView");
		filterByUtility(expectedProjectName);
		wau.waitClickable("project.list.page.previousbutton");
		wau.clickButton("project.list.page.previousbutton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");

		wau.getLogger().log(Status.PASS, "Project name with 'Does Not Contains' option applyed successfully ");
	}

	private void projectNameWithBeginsWithBeginsWithOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-115 verify filter by column project name with 'Begins With' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectName");
		wau.clickTab("project.text.columnList.projectName");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.containsOption"))
		{
			wau.clickTab("project.filterByColumn.beginsWithOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.beginsWithOption");
		}
		wau.waitVisibility("project.filterByColumn.keywords");
		wau.sendInput("project.filterByColumn.keywords", DataProperties.getProperty("project.text.beginsWithOption"));
		String expectedProjectName = wau.getAttributeValue("project.filterByColumn.keywords");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.list.gridView");
		filterByUtility(expectedProjectName);
		String value = wau.getAttribute("project.list.page.previous",DataProperties.getProperty("project.button.previous"));
		if(value.contentEquals("false"))
		{
			wau.waitClickable("project.list.page.previousbutton");
			wau.clickButton("project.list.page.previousbutton");
		}else {}

		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project name with 'Begins With' option applyed successfully ");
	}

	private void projectNameWithEndsWithOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-116 verify filter by column project name with 'Ends With' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectName");
		wau.clickTab("project.text.columnList.projectName");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.containsOption"))
		{
			wau.clickTab("project.filterByColumn.endsWithOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.endsWithOption");
		}
		wau.waitVisibility("project.filterByColumn.keywords");
		wau.sendInput("project.filterByColumn.keywords", DataProperties.getProperty("project.text.endsWithOption"));
		String expectedProjectName = wau.getAttributeValue("project.filterByColumn.keywords");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.list.gridView");
		filterByUtility(expectedProjectName);
		String value = wau.getAttribute("project.list.page.previous",DataProperties.getProperty("project.button.previous"));
		if(value.contentEquals("false"))
		{
			wau.waitClickable("project.list.page.previousbutton");
			wau.clickButton("project.list.page.previousbutton");
		}else {}
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project name with 'Ends With' option applied successfully ");
	}

	private void filterByPlannedDateUtility()
	{
		int maxPages = RamboUtil.getMaxPages(wau.getElementText("project.label.numberOfPagesAvailable"));

		int count=0;
		int totalCount=0;

		for(int i=1;i<=maxPages;i++)
		{
			RamboUtil.pause(500);
			List<WebElement> list =wau.getList("project.projectList.plannedDate");
			count = list.size();

			totalCount = totalCount+count;

		}
		wau.getLogger().log(Status.PASS, "Total number of projects are " +totalCount);
		String value = wau.getAttribute("project.list.page.previous",DataProperties.getProperty("project.button.previous"));
		if(value.contentEquals("false"))
		{
			wau.waitClickable("project.list.page.previousbutton");
			wau.clickButton("project.list.page.previousbutton");
		}else {}

	}

	private void clickCalenderDay(String calenderDay)
	{
		List<WebElement> days =wau.getList("project.filterByColumn.datePicker.calenderdays");
		for (WebElement day : days) {

			String actualday = day.getText();
			if(actualday.contentEquals(calenderDay))
			{
				day.click();
				break;
			}
		}
	}
	private void projectPlannedDateWithIsOnOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-122 verify filter by column project planned date with 'Is On' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.plannedDate");
		wau.clickTab("project.text.columnList.plannedDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isOnOption"))
		{
			wau.clickTab("project.filterByColumn.isOnOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isOnOption");
		}
		wau.waitVisibility("project.filterByColumn.plannedDate");
		wau.clickButton("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.alertPopup.filterBy");
		wau.waitVisibility("project.text.errorMessage.filterBy");
		wau.isPresent("project.button.errorMessage.filterBy.okButton");
		wau.clickButton("project.button.errorMessage.filterBy.okButton");
		wau.waitVisibility("project.filterByColumn.plannedDate");
		wau.clickTab("project.filterByColumn.plannedDate");
		String day = "13";
		clickCalenderDay(day);
		wau.sendInput("project.filterByColumn.plannedDate", DataProperties.getProperty("project.field.filterByColumn.plannedDate"));
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project planned date with 'Is On' option applied successfully ");
	}

	private void projectPlanneddDateWithIsBeforeOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-123 verify filter by column project planned date with 'Is Before' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.plannedDate");
		wau.clickTab("project.text.columnList.plannedDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isBeforeOption"))
		{
			wau.clickTab("project.filterByColumn.isBeforeOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isBeforeOption");
		}
		wau.waitVisibility("project.filterByColumn.plannedDate");
		wau.clickTab("project.filterByColumn.plannedDate");
		String day = "12";
		clickCalenderDay(day);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project planned date with 'Is Before' option applied successfully ");

	}

	private void projectPlannedDateWithIsAfterOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-124 verify filter by column project planned date with 'Is After' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.plannedDate");
		wau.clickTab("project.text.columnList.plannedDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isAfterOption"))
		{
			wau.clickTab("project.filterByColumn.isAfterOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isAfterOption");
		}
		wau.waitVisibility("project.filterByColumn.plannedDate");
		wau.clickTab("project.filterByColumn.plannedDate");
		String day = "12";
		clickCalenderDay(day);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project planned date with 'Is After' option applied successfully ");
	}

	private void isBetweenOptionStartDate(String startDay)
	{
		List<WebElement> daysStart =wau.getList("project.filterByColumn.isbetweenStart.calenderDays");
		int countStart = daysStart.size();
		System.out.println(countStart);
		for (WebElement day : daysStart) {

			String actualday1 = day.getText();
			System.out.println(actualday1);
			if(actualday1.contentEquals(startDay))
			{
				day.click();
				break;
			}
		}
	}

	private void isBetweenOptionEndDate(String endDay)
	{
		List<WebElement> daysEnd = wau.getList("project.filterByColumn.isBetweenEnd.calenderDays");
		int countEnd = daysEnd.size();
		System.out.println(countEnd);
		for (WebElement day : daysEnd) {

			String actualday2 = day.getText();
			System.out.println(actualday2);
			if(actualday2.contentEquals(endDay))
			{
				day.click();
				break;
			}
		}
	}

	private void projectPlannedDateWithIsBetweenOptionDateValidation()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-Extra Validation verify filter by column project planned date with 'Is Between' option with date validation");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.plannedDate");
		wau.clickTab("project.text.columnList.plannedDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isbetweenOption"))
		{
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		wau.waitVisibility("project.filterByColumn.isbetweenStartdate");
		wau.clickButton("project.filterByColumn.isbetweenStartdate");
		String startDay = "17";
		isBetweenOptionStartDate(startDay);
		RamboUtil.pause(200);
		wau.waitVisibility("project.filterByColumn.isbetweenEndDate");
		wau.clickButton("project.filterByColumn.isbetweenEndDate");
		String endDay = "5";
		isBetweenOptionEndDate(endDay);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.filterByColumn.isBetweenOption.dateErropopup");
		wau.waitVisibility("project.filterByColumn.isBetweenOption.dateErrorMsg");
		wau.isPresent("project.filterByColumn.isBetweenOption.errorPopupOkButton");
		wau.clickButton("project.filterByColumn.isBetweenOption.errorPopupOkButton");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.clickButton("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "verify filter by column project planned date with 'Is Between' option with date validation successfully");

	}

	private void projectPlannedDateWithIsBetweenOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-Extra-Validation verify filter by column project planned date with 'Is Between' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.plannedDate");
		wau.clickTab("project.text.columnList.plannedDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isbetweenOption"))
		{
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		wau.waitVisibility("project.filterByColumn.isbetweenStartdate");
		wau.clickButton("project.filterByColumn.isbetweenStartdate");
		String startDay = "5";
		isBetweenOptionStartDate(startDay);
		RamboUtil.pause(200);
		wau.waitVisibility("project.filterByColumn.isbetweenEndDate");
		wau.clickButton("project.filterByColumn.isbetweenEndDate");
		String endDay = "17";
		isBetweenOptionEndDate(endDay);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project planned date with 'Is Between' option applied successfully ");
	}

	private void projectPlannedDateWithinXDaysBeforeCurrentDateOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-125 verify filter by column project planned date 'Is Within X Days Before Current Date' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.plannedDate");
		wau.clickTab("project.text.columnList.plannedDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isBeforeCurrentDate"))
		{
			wau.clickTab("project.filterByColumn.isBeforeCurrentDate");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isBeforeCurrentDate");
		}
		wau.waitVisibility("project.filterByColumn.isBeforeCurrentDate.xDays");
		wau.sendInput("project.filterByColumn.isBeforeCurrentDate.xDays", DataProperties.getProperty("project.field.filterByColumn.isBeforeCurrent.xDays"));
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project planned date 'Is Within X Days Before Current Date' option applied successfully ");
	}

	private void projectPlannedDateWithinXDaysAfterCurrentDateOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-126 verify filter by column project planned date 'Is Within X Days After Current Date' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.plannedDate");
		wau.clickTab("project.text.columnList.plannedDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isAfterCurrentDate"))
		{
			wau.clickTab("project.filterByColumn.isAfterCurrentDate");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isAfterCurrentDate");
		}
		wau.waitVisibility("project.filterByColumn.isAfterCurrentDate.xDays");
		wau.sendInput("project.filterByColumn.isAfterCurrentDate.xDays", DataProperties.getProperty("project.field.filetrByColumn.isAfterCurrent.xDays"));
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project planned date 'Is Within X Days After Current Date' option applied successfully ");
	}

	private void projectDueDateWithIsOnOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-127 verify filter by column project due date with 'Is On' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.dueDate");
		wau.clickTab("project.text.columnList.dueDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isOnOption"))
		{
			wau.clickTab("project.filterByColumn.isOnOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isOnOption");
		}
		wau.waitVisibility("project.filterByColumn.dueDate");
		wau.clickTab("project.filterByColumn.dueDate");

		String day = "27";
		clickCalenderDay(day);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project due date with 'Is On' option applied successfully ");
	}

	private void projectDueDateWithIsBeforeOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-128 verify filter by column project due date with 'Is Before' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.dueDate");
		wau.clickTab("project.text.columnList.dueDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isBeforeOption"))
		{
			wau.clickTab("project.filterByColumn.isBeforeOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isBeforeOption");
		}
		wau.waitVisibility("project.filterByColumn.dueDate");
		wau.clickTab("project.filterByColumn.dueDate");

		String day = "12";
		clickCalenderDay(day);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project due date with 'Is Before' option applied successfully ");
	}

	private void projectDueDateWithIsAfterOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-129 verify filter by column project due date with 'Is After' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.dueDate");
		wau.clickTab("project.text.columnList.dueDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isAfterOption"))
		{
			wau.clickTab("project.filterByColumn.isAfterOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isAfterOption");
		}
		wau.waitVisibility("project.filterByColumn.dueDate");
		wau.clickTab("project.filterByColumn.dueDate");

		String day = "10";
		clickCalenderDay(day);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project due date with 'Is After' option applied successfully ");
	}

	private void projectDueDateWithIsBetweenOptionDateValidation()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-Extra Validation verify filter by column project due date with 'Is Between' option with date validation");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.dueDate");
		wau.clickTab("project.text.columnList.dueDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isbetweenOption"))
		{
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		wau.waitVisibility("project.filterByColumn.isbetweenStartdate");
		wau.clickButton("project.filterByColumn.isbetweenStartdate");
		String startDay = "17";
		isBetweenOptionStartDate(startDay);
		RamboUtil.pause(200);
		wau.waitVisibility("project.filterByColumn.isbetweenEndDate");
		wau.clickButton("project.filterByColumn.isbetweenEndDate");
		String endDay = "5";
		isBetweenOptionEndDate(endDay);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.filterByColumn.isBetweenOption.dateErropopup");
		wau.waitVisibility("project.filterByColumn.isBetweenOption.dateErrorMsg");
		wau.isPresent("project.filterByColumn.isBetweenOption.errorPopupOkButton");
		wau.clickButton("project.filterByColumn.isBetweenOption.errorPopupOkButton");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.clickButton("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "verify filter by column project due date with 'Is Between' option with date validation successfully");
	}

	private void projectDueDateWithIsBetweenOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-Extra-Validation verify filter by column project due date with 'Is Between' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.dueDate");
		wau.clickTab("project.text.columnList.dueDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isbetweenOption"))
		{
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isbetweenOption");
		}
		wau.waitVisibility("project.filterByColumn.isbetweenStartdate");
		wau.clickButton("project.filterByColumn.isbetweenStartdate");
		String startDay = "5";
		isBetweenOptionStartDate(startDay);
		RamboUtil.pause(200);
		wau.waitVisibility("project.filterByColumn.isbetweenEndDate");
		wau.clickButton("project.filterByColumn.isbetweenEndDate");
		String endDay = "17";
		isBetweenOptionEndDate(endDay);
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project due date with 'Is Between' option applied successfully ");
	}

	private void projectDueDateWithinXDaysBeforeCurrentDateOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-130 verify filter by column project planned date 'Is Within X Days Before Current Date' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.dueDate");
		wau.clickTab("project.text.columnList.dueDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isBeforeCurrentDate"))
		{
			wau.clickTab("project.filterByColumn.isBeforeCurrentDate");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isBeforeCurrentDate");
		}
		wau.waitVisibility("project.filterByColumn.isBeforeCurrentDate.xDays");
		wau.sendInput("project.filterByColumn.isBeforeCurrentDate.xDays", DataProperties.getProperty("project.field.filterByColumn.isBeforeCurrent.xDays"));
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project due date 'Is Within X Days Before Current Date' option applied successfully ");
	}

	private void projectDueDateWithinXDaysAfterCurrentDateOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-131 verify filter by column project due date 'Is Within X Days After Current Date' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.dueDate");
		wau.clickTab("project.text.columnList.dueDate");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.isAfterCurrentDate"))
		{
			wau.clickTab("project.filterByColumn.isAfterCurrentDate");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.isAfterCurrentDate");
		}
		wau.waitVisibility("project.filterByColumn.isAfterCurrentDate.xDays");
		wau.sendInput("project.filterByColumn.isAfterCurrentDate.xDays", DataProperties.getProperty("project.field.filetrByColumn.isAfterCurrent.xDays"));
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		filterByPlannedDateUtility();
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project due date 'Is Within X Days After Current Date' option applied successfully ");
	}

	private void projectClientWithIncludeOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-132 verify filter by column project client 'Include' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.cloumnList.client");
		wau.clickButton("project.text.cloumnList.client");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.includes"))
		{
			wau.clickTab("project.filterByColumn.includes");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.includes");
		}
		wau.waitVisibility("project.filterByColumn.clientName");
		wau.sendInput("project.filterByColumn.clientName", DataProperties.getProperty("project.field.filterByColumn.clientName"));
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project client with 'Includes' option applied successfully ");
	}

	private void projectClientWithDoesNotIncludeOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-133 verify filter by column project client ' Does not Includes' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.cloumnList.client");
		wau.clickButton("project.text.cloumnList.client");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.doesNotIncludes"))
		{
			wau.clickTab("project.filterByColumn.doesNotIncludes");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.doesNotIncludes");
		}
		wau.waitVisibility("project.filterByColumn.clientName");
		wau.sendInput("project.filterByColumn.clientName", DataProperties.getProperty("project.field.filterByColumn.clientName"));
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project client with 'Does not Includes' option applied successfully ");
	}

	private void projectStatusWithIncludesOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-134 verify filter by column project status 'Includes' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectStatus");
		wau.clickButton("project.text.columnList.projectStatus");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.includes"))
		{
			wau.clickTab("project.filterByColumn.includes");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.includes");
		}
		wau.waitVisibility("project.filterByColumn.statusName");
		RamboUtil.pause(1000);
		wau.clickButton("project.filterByColumn.statusTrigger");
		RamboUtil.pause(2000);
		wau.waitVisibility("project.filterByColumn.statusName.cancelled");
		wau.waitVisibility("project.filterByColumn.statusName.complete");
		wau.waitVisibility("project.filterByColumn.statusName.inProgress");
		wau.waitVisibility("project.filterByColumn.statusName.onHold");
		wau.waitVisibility("project.filterByColumn.statusName.projectStarted");
		wau.clickTab("project.filterByColumn.statusName.inProgress");
		RamboUtil.pause(1000);
		wau.clickTab("project.filterByColumn.statusName.cancelled");
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project status with 'Includes' option applied successfully ");
	}

	private void projectStatusWithDoesNotIncludesOption()
	{
		wau.getLogger().log(Status.INFO, "Test Case:  PMTC-135 verify filter by column project status 'Does not Includes' option ");
		wau.waitVisibility("project.button.filterBy");
		wau.clickButton("project.button.filterBy");
		wau.waitVisibility("project.button.filterBy.columnButton");
		wau.clickButton("project.button.filterBy.columnButton");
		wau.waitVisibility("project.popup.filterByColumn");
		wau.waitVisibility("project.popup.filterByColumn.cancelButton");
		wau.waitVisibility("project.popup.filterByColumn.submitButton");
		wau.clickButton("project.field.columnList");
		wau.waitVisibility("project.text.columnList.projectStatus");
		wau.clickButton("project.text.columnList.projectStatus");
		RamboUtil.pause(200);
		wau.waitClickable("project.select.option");
		wau.clickTab("project.select.option");
		if(wau.isAvailable("project.filterByColumn.doesNotIncludes"))
		{
			wau.clickTab("project.filterByColumn.doesNotIncludes");
		}
		else
		{
			wau.clickTab("project.select.option");
			wau.clickTab("project.filterByColumn.doesNotIncludes");
		}
		wau.waitVisibility("project.filterByColumn.statusName");
		RamboUtil.pause(1000);
		wau.clickButton("project.filterByColumn.statusTrigger");
		RamboUtil.pause(2000);
		wau.waitVisibility("project.filterByColumn.statusName.cancelled");
		wau.waitVisibility("project.filterByColumn.statusName.complete");
		wau.waitVisibility("project.filterByColumn.statusName.inProgress");
		wau.waitVisibility("project.filterByColumn.statusName.onHold");
		wau.waitVisibility("project.filterByColumn.statusName.projectStarted");
		wau.clickTab("project.filterByColumn.statusName.inProgress");
		RamboUtil.pause(1000);
		wau.clickTab("project.filterByColumn.statusName.cancelled");
		wau.clickButton("project.filterByColumn.statusName.onHold");
		wau.clickButtonByJS("project.popup.filterByColumn.submitButton");
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.list.gridView");
		RamboUtil.pause(200);
		wau.waitVisibility("project.text.message.filterByColumnApplied");
		wau.waitVisibility("project.button.filterByColumnApplied.close");
		wau.clickButton("project.button.filterByColumnApplied.close");
		wau.waitVisibility("project.list.gridView");
		wau.getLogger().log(Status.PASS, "Project status with 'Does not Includes' option applied successfully ");
	}

	private void review()
	{
		revieWithOutMandatoryField();

		createReviewWithSearchEmailOption();

		createReviewWithCheckReviewOptions();

		createReviewWithAddWebsiteByURL();

		createReviewWithUploadWebsiteAsZip();//file format issue

		createReviewWithAddFilesFromProject();
		
		createReviewWithAddFilesFromLibrary();

		performActionsOnUploadedFile();
		
		toggleArchiveAndActiveReview();
		
		viewReviewAction();
		 
		viewReviewWithAddFilesFromProject();
		
		viewReviewWithAddFilesFromLibrary();
		
		dowloadReview();
	}
	
	private void reviewTabPreCondition()
	{
		wau.waitVisibility("project.tab.reviews");
		wau.clickButtonByJS("project.tab.reviews");
		if(wau.isDisplay("project.review.button.newReview")==true && wau.isDisplay("project.review.button.activeReview")==true 
				&& wau.isDisplay("project.review.button.listView")==true)
		{
			System.out.println("Review precondition match");
		}else if(wau.isDisplay("project.review.button.archiveReview")==true)
		{
			wau.waitClickable("project.review.button.archiveReview");
			wau.clickButton("project.review.button.archiveReview");
			wau.waitVisibility("project.review.button.menuActiveReview");
			wau.clickButton("project.review.button.menuActiveReview");
			wau.waitVisibility("project.review.button.activeReview");
		}else if(wau.isDisplay("project.review.button.thumbnailView")==true)
		{
			wau.waitClickable("project.review.button.thumbnailView");
			wau.clickButton("project.review.button.thumbnailView");
			wau.waitVisibility("project.review.button.menuListView");
			wau.clickButton("project.review.button.menuListView");
			wau.waitVisibility("project.review.button.listView");
		}
	}

	private void revieWithOutMandatoryField()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  PMTC-138,139 verify review functionality witout mandatory fields");
			preCondition();
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			reviewTabPreCondition();
			
			
			//verify thumbnail view
			wau.clickButton("project.review.button.listView");
			wau.waitVisibility("project.review.button.menuThumbnailView");
			wau.clickButton("project.review.button.menuThumbnailView");
			wau.waitVisibility("project.review.thumbnailView.reviewActionButton");
			wau.waitVisibility("project.review.button.thumbnailView");
			wau.clickButton("project.review.button.thumbnailView");
			wau.waitVisibility("project.review.button.menuListView");
			wau.clickButton("project.review.button.menuListView");
			wau.waitVisibility("project.review.button.listView");
			
			wau.waitVisibility("project.review.button.newReview");
			wau.waitVisibility("project.review.button.activeReview");
			wau.waitVisibility("project.review.button.listView");
			wau.waitVisibility("project.review.button.exportListView");
			wau.waitVisibility("project.review.button.refreshButton");
			wau.waitVisibility("project.review.button.settingButton");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");
			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			wau.clickButton("project.review.button.save");
			wau.waitVisibility("project.review.alertMsg.popup");
			wau.waitVisibility("project.review.alertMsg.mandatoryField");
			wau.waitVisibility("project.review.alertMsg.okButton");
			wau.clickButton("project.review.alertMsg.okButton");
			wau.waitVisibility("project.review.button.cancel");
			wau.clickButton("project.review.button.cancel");
			wau.waitVisibility("project.review.button.yes");
			wau.clickButton("project.review.button.yes");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.getLogger().log(Status.PASS, "Verify review functionality without mandatory fields successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify review functionality without mandatory fields");
			e.printStackTrace();
		}

	}

	private void createReviewWithSearchEmailOption()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 140 verify create review with search email option");
			RamboUtil.pause(1000);
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButtonByJS("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.newReview");
			wau.waitVisibility("project.review.button.activeReview");
			wau.waitVisibility("project.review.button.listView");
			wau.waitVisibility("project.review.button.exportListView");
			wau.waitVisibility("project.review.button.refreshButton");
			wau.waitVisibility("project.review.button.settingButton");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");

			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			if(wau.isDisplay("project.field.review.type.commentsOrFeedback")==true)
			{
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}else
			{
				wau.clickTab("project.field.review.type");
				wau.waitVisibility("project.field.review.type.commentsOrFeedback");
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}
			wau.clickTab("project.field.review.status");
			if(wau.isDisplay("project.filed.reviewStatus.inProgress"))
			{
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			else
			{
				wau.clickTab("project.field.review.status");
				wau.waitVisibility("project.filed.reviewStatus.inProgress");
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			//wau.clickButton("project.field.review.startDate");
			wau.clearAndWait("project.field.review.startDate");
			wau.sendInput("project.field.review.startDate", RamboUtil.startDates());
			wau.clickButton("project.field.review.dueDate");
			wau.clearAndWait("project.field.review.dueDate");
			wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.field.review.emailSearch.button");
			wau.waitVisibility("project.field.review.emailSearch.popup");
			wau.waitVisibility("project.field.review.emailSearch.popup.selectGroup");
			wau.waitVisibility("project.button.review.emailSearch.popup.cancelButton");
			wau.waitVisibility("project.button.review.emailSearch.popup.addButton");
			wau.clickButton("project.review.emailSearch.popup.selectUserRadioButton");
			wau.clickButton("project.button.review.emailSearch.popup.addButton");
			wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
			wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
			wau.clickButton("project.field.review.uploadFile");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.review.file");
			wau.waitVisibility("project.review.button.save");
			wau.clickButton("project.review.button.save");
			if(wau.isDisplay("project.review.alertMsg.addedReview")==true)
			{
				wau.waitInvisibility("project.review.alertMsg.addedReview");
			}else
			{
				RamboUtil.pause(15000);
			}
			wau.waitVisibility("project.review.reviewHeader");
			wau.clickButtonByJS("project.review.reviewHeader");
			RamboUtil.pause(500);
			wau.clickButtonByJS("project.review.reviewHeader");
			wau.getLogger().log(Status.PASS, "Verify create review with search email option successfully");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			deleteReview();
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create review with search email option");
			e.printStackTrace();
		}
	}

	private void createReviewWithCheckReviewOptions()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 141,142,143 verify create review with check review options ");
			RamboUtil.pause(1000);
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButtonByJS("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.newReview");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");

			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			if(wau.isDisplay("project.field.review.type.commentsOrFeedback")==true)
			{
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}else
			{
				wau.clickTab("project.field.review.type");
				wau.waitVisibility("project.field.review.type.commentsOrFeedback");
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}
			wau.clickTab("project.field.review.status");
			if(wau.isDisplay("project.filed.reviewStatus.inProgress"))
			{
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			else
			{
				wau.clickTab("project.field.review.status");
				wau.waitVisibility("project.filed.reviewStatus.inProgress");
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			wau.clickButton("project.field.review.startDate");
			wau.clearAndWait("project.field.review.startDate");
			wau.sendInput("project.field.review.startDate", RamboUtil.startDates());
			wau.clickButton("project.field.review.dueDate");
			wau.clearAndWait("project.field.review.dueDate");
			wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.field.review.emailSearch.button");
			wau.waitVisibility("project.field.review.emailSearch.popup");
			wau.waitVisibility("project.field.review.emailSearch.popup.selectGroup");
			wau.waitVisibility("project.button.review.emailSearch.popup.cancelButton");
			wau.waitVisibility("project.button.review.emailSearch.popup.addButton");
			wau.clickButton("project.review.emailSearch.popup.selectUserRadioButton");
			wau.clickButton("project.button.review.emailSearch.popup.addButton");
			wau.waitVisibility("project.review.reviewOptions.secondRadioButton");
			wau.clickButton("project.review.reviewOptions.secondRadioButton");
			wau.clickButton("project.review.reviewOptions.fourthRadioOption");
			wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
			wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
			wau.clickButton("project.field.review.uploadFile");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\logo.png");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.review.file");
			wau.waitVisibility("project.review.button.save");
			wau.clickButton("project.review.button.save");
			if(wau.isDisplay("project.review.alertMsg.addedReview")==true)
			{
				wau.waitInvisibility("project.review.alertMsg.addedReview");
			}else
			{
				RamboUtil.pause(15000);
			}
			wau.waitVisibility("project.review.reviewHeader");
			wau.clickButtonByJS("project.review.reviewHeader");
			RamboUtil.pause(500);
			wau.clickButtonByJS("project.review.reviewHeader");
			wau.getLogger().log(Status.PASS, "Verify create review with check review options successfully");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			deleteReview();
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create review with check review options ");
		}
	}

	private void createReviewWithAddWebsiteByURL()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 144 verify create review with add web site by Url ");
			RamboUtil.pause(1000);
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButtonByJS("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.newReview");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");

			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			if(wau.isDisplay("project.field.review.type.commentsOrFeedback")==true)
			{
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}else
			{
				wau.clickTab("project.field.review.type");
				wau.waitVisibility("project.field.review.type.commentsOrFeedback");
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}
			wau.clickTab("project.field.review.status");
			if(wau.isDisplay("project.filed.reviewStatus.inProgress"))
			{
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			else
			{
				wau.clickTab("project.field.review.status");
				wau.waitVisibility("project.filed.reviewStatus.inProgress");
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			wau.clickButton("project.field.review.startDate");
			wau.clearAndWait("project.field.review.startDate");
			wau.sendInput("project.field.review.startDate", RamboUtil.startDates());
			wau.clickButton("project.field.review.dueDate");
			wau.clearAndWait("project.field.review.dueDate");
			wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.field.review.emailSearch.button");
			wau.waitVisibility("project.field.review.emailSearch.popup");
			wau.waitVisibility("project.field.review.emailSearch.popup.selectGroup");
			wau.waitVisibility("project.button.review.emailSearch.popup.cancelButton");
			wau.waitVisibility("project.button.review.emailSearch.popup.addButton");
			wau.clickButton("project.review.emailSearch.popup.selectUserRadioButton");
			wau.clickButton("project.button.review.emailSearch.popup.addButton");
			wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
			wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
			wau.clickButton("project.review.addContent.comboBoxButton");
			if(wau.isDisplay("project.review.addContent.addWebSiteByURL")==true)
			{
				wau.waitVisibility("project.review.addContent.addWebSiteByURL");
				wau.clickButton("project.review.addContent.addWebSiteByURL");
			}else
			{
				wau.clickButton("project.review.addContent.comboBoxButton");
				wau.waitVisibility("project.review.addContent.addWebSiteByURL");
				wau.clickButton("project.review.addContent.addWebSiteByURL");
			}
			RamboUtil.pause(500);
			wau.waitVisibility("project.review.addContent.addWebSiteByUrl.popup");
			wau.waitVisibility("project.review.addContent.addWebSiteByUrl.text");
			wau.waitVisibility("project.review.addContent.addWebSiteByUrl.enterUrl");
			wau.waitClickable("project.review.addConyent.addWebSiteByUrl.uploadButton");
			wau.waitClickable("project.review.addContent.addWebSiteByUrl.cancelButton");
			wau.clearAndWait("project.review.addContent.addWebSiteByUrl.enterUrl");
			wau.sendInput("project.review.addContent.addWebSiteByUrl.enterUrl", DataProperties.getProperty("project.createReview.addContent.webSiteURL"));
			wau.clickButton("project.review.addConyent.addWebSiteByUrl.uploadButton");
			wau.waitVisibility("project.review.file");
			wau.waitVisibility("project.review.button.save");
			wau.clickButton("project.review.button.save");
			if(wau.isDisplay("project.review.alertMsg.addedReview")==true)
			{
				wau.waitInvisibility("project.review.alertMsg.addedReview");
			}else
			{
				RamboUtil.pause(15000);
			}
			wau.waitVisibility("project.review.reviewHeader");
			wau.clickButtonByJS("project.review.reviewHeader");
			RamboUtil.pause(500);
			wau.clickButtonByJS("project.review.reviewHeader");
			wau.getLogger().log(Status.PASS, "Verify create review with add website by Url successfully");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			deleteReview();
			
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to create review with add website by Url ");
		}
	}

	private void createReviewWithUploadWebsiteAsZip()
	{
		try {
			preCondition();
			wau.getLogger().log(Status.INFO, "PMTC: 145 verify create review with upload web site as zip ");
			RamboUtil.pause(1000);
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButtonByJS("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.newReview");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");

			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			if(wau.isDisplay("project.field.review.type.commentsOrFeedback")==true)
			{
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}else
			{
				wau.clickTab("project.field.review.type");
				wau.waitVisibility("project.field.review.type.commentsOrFeedback");
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}
			wau.clickTab("project.field.review.status");
			if(wau.isDisplay("project.filed.reviewStatus.inProgress"))
			{
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			else
			{
				wau.clickTab("project.field.review.status");
				wau.waitVisibility("project.filed.reviewStatus.inProgress");
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			wau.waitVisibility("project.field.review.startDate");
			wau.clickButton("project.field.review.startDate");
			wau.clearAndWait("project.field.review.startDate");
			wau.sendInput("project.field.review.startDate", RamboUtil.startDates());
			wau.clickButton("project.field.review.dueDate");
			wau.clearAndWait("project.field.review.dueDate");
			wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.field.review.emailSearch.button");
			wau.waitVisibility("project.field.review.emailSearch.popup");
			wau.waitVisibility("project.field.review.emailSearch.popup.selectGroup");
			wau.waitVisibility("project.button.review.emailSearch.popup.cancelButton");
			wau.waitVisibility("project.button.review.emailSearch.popup.addButton");
			wau.clickButton("project.review.emailSearch.popup.selectUserRadioButton");
			wau.clickButton("project.button.review.emailSearch.popup.addButton");
			wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
			wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
			wau.clickButton("project.review.addContent.comboBoxButton");
			if(wau.isDisplay("project.review.addContent.uploadWebSiteAsZip")==true)
			{
				wau.waitVisibility("project.review.addContent.uploadWebSiteAsZip");
				wau.clickButton("project.review.addContent.uploadWebSiteAsZip");
			}else
			{
				wau.clickButton("project.review.addContent.comboBoxButton");
				wau.waitVisibility("project.review.addContent.uploadWebSiteAsZip");
				wau.clickButton("project.review.addContent.uploadWebSiteAsZip");
			}
			wau.waitVisibility("project.review.addContent.uploadWebSiteAsZip.popup");
			wau.waitVisibility("project.review.addContent.uploadWebSiteAsZip.text");
			wau.clickButton("project.review.addContent.uploadWebSiteAsZip.SelectFilesButton");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\test.zip");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.review.addContent.uploadWebSiteAsZip.removeButton");
			wau.waitClickable("project.review.addContent.uploadWebSiteAsZip.uploadButton");
			wau.clickButton("project.review.addContent.uploadWebSiteAsZip.uploadButton");
			wau.retryingFindElement("project.review.file");
			wau.waitVisibility("project.review.text.fileName");
			wau.waitVisibility("project.review.button.save");
			wau.clickButton("project.review.button.save");
			if(wau.isDisplay("project.review.alertMsg.addedReview")==true)
			{
				wau.waitInvisibility("project.review.alertMsg.addedReview");
			}else
			{
				RamboUtil.pause(15000);
			}
			wau.waitVisibility("project.review.reviewHeader");
			wau.clickButtonByJS("project.review.reviewHeader");
			RamboUtil.pause(500);
			wau.clickButtonByJS("project.review.reviewHeader");
			wau.getLogger().log(Status.PASS, "Verify create review with upload web site as zip successfully");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			deleteReview();
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to create review with upload web site as zip successfully");
			e.printStackTrace();
		}
	}

	private void createReviewWithAddFilesFromProject() 
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  PMTC-147 verify review with add files from project");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButtonByJS("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.newReview");
			wau.waitVisibility("project.review.button.activeReview");
			wau.waitVisibility("project.review.button.listView");
			wau.waitVisibility("project.review.button.exportListView");
			wau.waitVisibility("project.review.button.refreshButton");
			wau.waitVisibility("project.review.button.settingButton");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");

			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			if(wau.isDisplay("project.field.review.type.commentsOrFeedback")==true)
			{
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}else
			{
				wau.clickTab("project.field.review.type");
				wau.waitVisibility("project.field.review.type.commentsOrFeedback");
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}
			wau.clickTab("project.field.review.status");
			if(wau.isDisplay("project.filed.reviewStatus.inProgress"))
			{
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			else
			{
				wau.clickTab("project.field.review.status");
				wau.waitVisibility("project.filed.reviewStatus.inProgress");
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			wau.clickButton("project.field.review.startDate");
			wau.clearAndWait("project.field.review.startDate");
			wau.sendInput("project.field.review.startDate", RamboUtil.startDates());
			wau.clickButton("project.field.review.dueDate");
			wau.clearAndWait("project.field.review.dueDate");
			wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.field.review.emailSearch.button");
			wau.waitVisibility("project.field.review.emailSearch.popup");
			wau.waitVisibility("project.field.review.emailSearch.popup.selectGroup");
			wau.waitVisibility("project.button.review.emailSearch.popup.cancelButton");
			wau.waitVisibility("project.button.review.emailSearch.popup.addButton");
			wau.clickButton("project.review.emailSearch.popup.selectUserRadioButton");
			wau.clickButton("project.button.review.emailSearch.popup.addButton");
			wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
			wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
			wau.clickButton("project.review.addContent.comboBoxButton");
			if(wau.isDisplay("project.review.addContent.addFilesFromProject")==true)
			{
				wau.clickButton("project.review.addContent.addFilesFromProject");
			}
			else
			{
				wau.clickButton("project.review.addContent.comboBoxButton");
				wau.waitVisibility("project.review.addContent.addFilesFromProject");
				wau.clickButton("project.review.addContent.addFilesFromProject");
			}
			wau.waitVisibility("project.review.addContent.addFilesFromProject.popup");
			wau.waitVisibility("project.review.addContent.addFilesFromProject.text");
			wau.waitVisibility("project.review.addContent.addFilesFromeProject.selectFileName");
			wau.waitClickable("project.review.addContent.addFilesFromProject.selectButton");
			wau.sendInput("project.review.addContent.addFilesFromProject.fileName", DataProperties.getProperty("project.createReview.addContent.fileName"));
			wau.sendInput("project.review.addContent.addFilesFromProject.fileName", Keys.ENTER);
			wau.clickButton("project.review.addContent.addFilesFromProject.selectButton");
			wau.waitVisibility("project.review.file");
			wau.waitVisibility("project.review.button.save");
			wau.clickButton("project.review.button.save");
			if(wau.isDisplay("project.review.alertMsg.addedReview")==true)
			{
				wau.waitInvisibility("project.review.alertMsg.addedReview");
			}else
			{
				RamboUtil.pause(15000);
			}
			wau.waitVisibility("project.review.reviewHeader");
			wau.clickButtonByJS("project.review.reviewHeader");
			RamboUtil.pause(500);
			wau.clickButtonByJS("project.review.reviewHeader");
			
			wau.getLogger().log(Status.PASS, "Verify create review with add files from project successfully");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			deleteReview();
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create review with add files from project ");
			e.printStackTrace();
		}
	}
	
	private void createReviewWithAddFilesFromLibrary()
	{
		try {
			wau.getLogger().log(Status.INFO, "Test Case:  PMTC-148 verify review with add files from library");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButtonByJS("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.newReview");
			wau.waitVisibility("project.review.button.activeReview");
			wau.waitVisibility("project.review.button.listView");
			wau.waitVisibility("project.review.button.exportListView");
			wau.waitVisibility("project.review.button.refreshButton");
			wau.waitVisibility("project.review.button.settingButton");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");

			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			if(wau.isDisplay("project.field.review.type.commentsOrFeedback")==true)
			{
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}else
			{
				wau.clickTab("project.field.review.type");
				wau.waitVisibility("project.field.review.type.commentsOrFeedback");
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}
			wau.clickTab("project.field.review.status");
			if(wau.isDisplay("project.filed.reviewStatus.inProgress"))
			{
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			else
			{
				wau.clickTab("project.field.review.status");
				wau.waitVisibility("project.filed.reviewStatus.inProgress");
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			wau.clickButton("project.field.review.startDate");
			wau.clearAndWait("project.field.review.startDate");
			wau.sendInput("project.field.review.startDate", RamboUtil.startDates());
			wau.clickButton("project.field.review.dueDate");
			wau.clearAndWait("project.field.review.dueDate");
			wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.field.review.emailSearch.button");
			wau.waitVisibility("project.field.review.emailSearch.popup");
			wau.waitVisibility("project.field.review.emailSearch.popup.selectGroup");
			wau.waitVisibility("project.button.review.emailSearch.popup.cancelButton");
			wau.waitVisibility("project.button.review.emailSearch.popup.addButton");
			wau.clickButton("project.review.emailSearch.popup.selectUserRadioButton");
			wau.clickButton("project.button.review.emailSearch.popup.addButton");
			wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
			wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
			wau.clickButton("project.review.addContent.comboBoxButton");
			if(wau.isDisplay("project.review.addContent.addFilesFromLibrary")==true)
			{
				wau.clickButton("project.review.addContent.addFilesFromLibrary");
			}else
			{
				wau.clickButton("project.review.addContent.comboBoxButton");
				wau.clickButton("project.review.addContent.addFilesFromLibrary");
			}
				wau.waitVisibility("project.review.addContent.addFilesFromlibrary.popup");
				wau.waitVisibility("project.review.addContent.addFilesFromLibrary.text");
				wau.waitVisibility("project.review.addContent.addFilesFromLibrary.data");
				wau.clickButton("project.review.addContent.addFilesFromLibrary.data");
				wau.waitVisibility("project.review.addContent.addFilesFromLibrary.selectButton");
				wau.clickButton("project.review.addContent.addFilesFromLibrary.selectButton");
				wau.waitVisibility("project.review.file");
				wau.waitVisibility("project.review.button.save");
				wau.clickButton("project.review.button.save");
				if(wau.isDisplay("project.review.alertMsg.addedReview")==true)
				{
					wau.waitInvisibility("project.review.alertMsg.addedReview");
				}else
				{
					RamboUtil.pause(15000);
				}
				wau.waitVisibility("project.review.reviewHeader");
				wau.clickButtonByJS("project.review.reviewHeader");
				RamboUtil.pause(500);
				wau.clickButtonByJS("project.review.reviewHeader");
				
				wau.getLogger().log(Status.PASS, "Verify create review with add files from library successfully");
				wau.clickButton("main.tab.projects");
				wau.waitVisibility("project.button.newProject");
				wau.waitVisibility("project.list.gridView");
				deleteReview();
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify create review with add files from library");
			e.printStackTrace();
		}
	}

	private void performActionsOnUploadedFile()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 149,150 verify create review tab perform action on uploaded files ");
			RamboUtil.pause(1000);
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.newReview");
			wau.clickButton("project.review.button.newReview");
			wau.waitVisibility("project.review.button.save");
			wau.waitVisibility("project.review.button.cancel");

			wau.sendInput("project.field.review.reviewName", DataProperties.getProperty("project.createReview.reviewName"));
			wau.clickTab("project.field.review.type");
			if(wau.isDisplay("project.field.review.type.commentsOrFeedback")==true)
			{
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}else
			{
				wau.clickTab("project.field.review.type");
				wau.waitVisibility("project.field.review.type.commentsOrFeedback");
				wau.clickButton("project.field.review.type.commentsOrFeedback");
			}
			wau.clickTab("project.field.review.status");
			if(wau.isDisplay("project.filed.reviewStatus.inProgress"))
			{
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			else
			{
				wau.clickTab("project.field.review.status");
				wau.waitVisibility("project.filed.reviewStatus.inProgress");
				wau.clickButton("project.filed.reviewStatus.inProgress");
			}
			wau.clickButton("project.field.review.startDate");
			wau.clearAndWait("project.field.review.startDate");
			wau.sendInput("project.field.review.startDate", RamboUtil.startDates());
			wau.clickButton("project.field.review.dueDate");
			wau.clearAndWait("project.field.review.dueDate");
			wau.sendInput("project.field.review.dueDate", RamboUtil.EndDates());
			wau.clickButton("project.field.review.emailSearch.button");
			wau.waitVisibility("project.field.review.emailSearch.popup");
			wau.waitVisibility("project.field.review.emailSearch.popup.selectGroup");
			wau.waitVisibility("project.button.review.emailSearch.popup.cancelButton");
			wau.waitVisibility("project.button.review.emailSearch.popup.addButton");
			wau.clickButton("project.review.emailSearch.popup.selectUserRadioButton");
			wau.clickButton("project.button.review.emailSearch.popup.addButton");
			wau.waitVisibility("project.review.reviewOptions.secondRadioButton");
			wau.clickButton("project.review.reviewOptions.secondRadioButton");
			wau.clickButton("project.review.reviewOptions.fourthRadioOption");
			wau.sendInput("project.field.review.emailNotificationSubject", DataProperties.getProperty("project.createReview.emailNotificationSubject"));
			wau.sendInput("project.field.review.emailNotificationMessage", DataProperties.getProperty("project.createReview.emailNotificationMessage"));
			wau.clickButton("project.field.review.uploadFile");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\TestSuiteData.ods");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.review.file");
			
			//file action rename option
			wau.waitVisibility("project.review.fileAction.button");
			wau.clickButton("project.review.fileAction.button");
			wau.waitVisibility("project.review.fileAction.renameButton");
			wau.clickButton("project.review.fileAction.renameButton");
			wau.waitVisibility("project.review.rename.popup");
			wau.waitVisibility("project.review.rename.popupText");
			wau.waitVisibility("project.review.rename.popup.field");
			wau.waitClickable("project.review.rename.popup.updateButton");
			wau.waitClickable("project.review.rename.popup.cancelButton");
			wau.clearAndWait("project.review.rename.popup.field");
			wau.sendInput("project.review.rename.popup.field", DataProperties.getProperty("project.createReview.fileAction.renameFile"));
			String updateFileName = wau.getAttributeValue("project.review.rename.popup.field");
			System.out.println(updateFileName);
			wau.clickButton("project.review.rename.popup.updateButton");
			wau.waitVisibility("project.review.fileAction.button");
			wau.waitVisibility("project.review.text.fileName");
			wau.validateText("project.review.text.fileName", updateFileName);
			
			//file action set as default thumbnail option
			wau.waitVisibility("project.review.fileAction.button");
			wau.clickButton("project.review.fileAction.button");
			wau.waitVisibility("project.review.fileAction.setAsDefaultThumbnailButton");
			wau.clickButton("project.review.fileAction.setAsDefaultThumbnailButton");
			
			//file action delete all version
			RamboUtil.pause(500);
			wau.waitVisibility("project.review.fileAction.button");
			wau.clickButton("project.review.fileAction.button");
			wau.waitVisibility("project.review.fileAction.deleteAllVersion");
			wau.clickButton("project.review.fileAction.deleteAllVersion");
			wau.waitVisibility("project.review.fileAction.deleteAllversion.yesButton");
			wau.clickButton("project.review.fileAction.deleteAllversion.yesButton");
			
			RamboUtil.pause(500);
			wau.waitVisibility("project.review.button.cancel");
			wau.clickButton("project.review.button.cancel");
			wau.waitVisibility("project.review.button.yes");
			wau.clickButton("project.review.button.yes");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			
			wau.getLogger().log(Status.PASS, "Verify perform action on uploaded files successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify perform action on uploaded files");
			e.printStackTrace();
		}

	}
	
	private void toggleArchiveAndActiveReview()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 151 verify toggle active and archive review ");
			RamboUtil.pause(1000);
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.activeReview");
			RamboUtil.pause(300);
			wau.clickButton("project.review.button.activeReview");
			wau.waitVisibility("project.review.button.menuArchiveReview");
			RamboUtil.pause(300);
			wau.clickButton("project.review.button.menuArchiveReview");
			wau.waitVisibility("project.review.button.archiveReview");
			RamboUtil.pause(300);
			wau.clickButton("project.review.button.archiveReview");
			wau.waitVisibility("project.review.button.menuActiveReview");
			RamboUtil.pause(300);
			wau.clickButton("project.review.button.menuActiveReview");
			wau.waitVisibility("project.review.button.activeReview");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.getLogger().log(Status.PASS, "Verify toggle active and archive review successfully");
			
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify toggle active and archive review");
			e.printStackTrace();
		}
	}
	
	private void viewReviewAction()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 152,153,154 verify view review ");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.button.activeReview");
			wau.waitVisibility("project.review.reviewGridView");
			wau.waitVisibility("project.review.reviewActionButton");
			wau.clickButton("project.review.reviewActionButton");
			wau.waitVisibility("project.review.reviewAction.viewReview");
			wau.clickButton("project.review.reviewAction.viewReview");
			wau.waitVisibility("project.review.viewReview.reviewActionsButton");
			wau.waitVisibility("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.manageVersionButton");
			
			wau.waitClickable("project.review.viewReview.addVersionButton");
			wau.retryingFindClick("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.addVersionPopup");
			wau.waitVisibility("project.review.addVersionPopup.cancelButton");
			wau.waitVisibility("project.review.addVersionPopup.addButton");
			wau.retryingFindElement("project.review.addVersionPopup.selectFile");
			wau.clickButton("project.review.addVersionPopup.cancelButton");
			wau.waitInvisibility("project.review.viewReview.addVersionPopup");
			
			wau.clickButton("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.addVersionPopup");
			wau.waitClickable("project.review.addVersionPopup.selectFile");
			wau.clickButton("project.review.addVersionPopup.selectFile");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\TestSuiteData.ods");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.review.addVersionPopup.reviewProgressBar");
			wau.waitClickable("project.review.addVersionPopup.addButton");
			wau.clickButton("project.review.addVersionPopup.addButton");
			wau.waitVisibility("project.review.addVersionPopup.reviewVersionAdded");
			wau.waitInvisibility("project.review.addVersionPopup.reviewVersionAdded");
			
			wau.waitVisibility("project.tab.reviews");
			wau.clickButton("project.tab.reviews");
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			
			wau.getLogger().log(Status.PASS, "verify view review successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify view review");
			e.printStackTrace();
		}
	}
	
	private void viewReviewWithAddFilesFromProject()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 155,156 verify view review with add files from project ");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.reviewAction.viewReview");
			wau.clickButton("project.review.reviewAction.viewReview");
			wau.waitVisibility("project.review.viewReview.reviewActionsButton");
			wau.waitVisibility("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.manageVersionButton");
			
			wau.waitClickable("project.review.viewReview.addVersionButton");
			wau.retryingFindClick("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.addVersionPopup");
			wau.waitVisibility("project.review.addVersionPopup.cancelButton");
			wau.waitVisibility("project.review.addVersionPopup.addButton");
			wau.retryingFindElement("project.review.addVersionPopup.selectFile");
			wau.clickButton("project.review.addVersionPopup.cancelButton");
			wau.waitInvisibility("project.review.viewReview.addVersionPopup");
			
			wau.clickButton("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.addVersionPopup");
			wau.waitVisibility("project.review.viewReview.addContentListButton");
			wau.retryingFindClick("project.review.viewReview.addContentListButton");
			wau.waitVisibility("project.review.viewReview.addFileFromProject");
			wau.clickButton("project.review.viewReview.addFileFromProject");
			wau.waitClickable("project.review.addVersionPopup.selectFile");
			wau.clickButton("project.review.addVersionPopup.selectFile");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\TestSuiteData.ods");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.review.addVersionPopup.reviewProgressBar");
			wau.waitClickable("project.review.addVersionPopup.addButton");
			wau.clickButton("project.review.addVersionPopup.addButton");
			wau.waitVisibility("project.review.addVersionPopup.reviewVersionAdded");
			wau.waitInvisibility("project.review.addVersionPopup.reviewVersionAdded");
			
			wau.waitVisibility("project.tab.reviews");
			wau.clickButton("project.tab.reviews");
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.getLogger().log(Status.PASS, "verify view review with add files from project successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify view review with add files from project");
		}
	}
	
	private void viewReviewWithAddFilesFromLibrary()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC: 157,158 verify view review with add files from Liabrary ");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.reviewAction.viewReview");
			wau.clickButton("project.review.reviewAction.viewReview");
			wau.waitVisibility("project.review.viewReview.reviewActionsButton");
			wau.waitVisibility("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.manageVersionButton");
			
			wau.waitClickable("project.review.viewReview.addVersionButton");
			wau.retryingFindClick("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.addVersionPopup");
			wau.waitVisibility("project.review.addVersionPopup.cancelButton");
			wau.waitVisibility("project.review.addVersionPopup.addButton");
			wau.retryingFindElement("project.review.addVersionPopup.selectFile");
			wau.clickButton("project.review.addVersionPopup.cancelButton");
			wau.waitInvisibility("project.review.viewReview.addVersionPopup");
			
			wau.clickButton("project.review.viewReview.addVersionButton");
			wau.waitVisibility("project.review.viewReview.addVersionPopup");
			wau.waitVisibility("project.review.viewReview.addContentListButton");
			wau.retryingFindClick("project.review.viewReview.addContentListButton");
			wau.waitVisibility("project.review.viewReview.addFileFromLibrary");
			wau.clickButton("project.review.viewReview.addFileFromLibrary");
			wau.waitClickable("project.review.addVersionPopup.selectFile");
			wau.clickButton("project.review.addVersionPopup.selectFile");
			RamboUtil.pause(2000);
			StringSelection stringSelection = new StringSelection(System.getProperty("user.dir")+"\\Path\\TestSuiteData.ods");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			wau.uploadFileFromSystem();
			wau.waitVisibility("project.review.addVersionPopup.reviewProgressBar");
			wau.waitClickable("project.review.addVersionPopup.addButton");
			wau.clickButton("project.review.addVersionPopup.addButton");
			wau.waitVisibility("project.review.addVersionPopup.reviewVersionAdded");
			wau.waitInvisibility("project.review.addVersionPopup.reviewVersionAdded");
			
			wau.waitVisibility("project.tab.reviews");
			wau.clickButton("project.tab.reviews");
			wau.waitClickable("main.tab.projects");
			wau.clickButton("main.tab.projects");
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.getLogger().log(Status.PASS, "verify view review with add files from library successfully");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify view review with add files from library");
		}

	}
	
	private void dowloadReview()
	{
		try {
			wau.getLogger().log(Status.INFO, " PMTC:159 verify view review with download review file");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.reviewAction.viewReview");
			wau.clickButton("project.review.reviewAction.viewReview");
			wau.waitVisibility("project.review.viewReview.reviewActionsButton");
			wau.waitVisibility("project.review.viewReview.downloadIconButton");
			wau.clickButtonByJS("project.review.viewReview.downloadIconButton");
			String downloadPath = "C:\\Users\\jkj\\Downloads";
			String ExpectedFileName = "logo.png";
			RamboUtil.verifyFileDownload(downloadPath,ExpectedFileName);
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify download review file");
		}
	}
	
	private void openMarkUpReview()
	{
		try {
			wau.getLogger().log(Status.INFO, "PMTC:161 verify view review with open markup review");
			preCondition();
			wau.waitVisibility("project.button.newProject");
			wau.waitVisibility("project.list.gridView");
			wau.waitVisibility("project.text.projectName");
			wau.clickButton("project.text.projectName");
			wau.waitVisibility("project.tab.reviews");
			wau.clickButtonByJS("project.tab.reviews");
			wau.waitVisibility("project.review.reviewAction.viewReview");
			wau.clickButton("project.review.reviewAction.viewReview");
			wau.waitVisibility("project.review.viewReview.reviewActionsButton");
			wau.waitVisibility("project.review.viewReview.openMarkupReview");
			wau.waitClickable("project.review.viewReview.openMarkupReview");
			wau.clickButton("project.review.viewReview.openMarkupReview");
		} catch (Exception e) {
			wau.getLogger().log(Status.FAIL, "Unable to verify open markup review");
		}
	}
}
