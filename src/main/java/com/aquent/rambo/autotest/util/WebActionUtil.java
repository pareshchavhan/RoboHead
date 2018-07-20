/**
 *
 * Copyright: Copyright (c) 2018 by AQUENT, L.L.C.
 * Company: AQUENT, L.L.C.
 *  
 * @created 18-April-2018
 * @version 1.0
 *
 */
package com.aquent.rambo.autotest.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aquent.rambo.autotest.conf.LocatorProperties;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * 
 * Utility methods to simplify the actions on various web elements, and logging
 * them.
 * 
 * @author pkadwe
 *
 */
public class WebActionUtil {

	private WebDriver driver;
	private ExtentTest test;

	public WebActionUtil(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// To exit without continuing to next case
	public void exitIfFail(boolean result) {
		throw new RuntimeException("Stopping further execution");
	}

	public boolean validateLink(String locatorKey) {

		WebElement element = getElement(locatorKey);
		return element.isDisplayed() && element.isEnabled();
		/*
		 * return extentLog( element.isDisplayed() && element.isEnabled(), "Link check",
		 * locatorKey);
		 */

	}

	// Validate and perform click
	public boolean clickLink(String locatorKey) {

		boolean result = validateLink(locatorKey);
		if (result) {
			WebElement element = getElement(locatorKey);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
			return true;
			/*
			 * return extentLog( true, "Link Click", locatorKey);
			 */
		}
		return false;
	}

	public boolean clickButton(String locatorKey) {

		try {
			WebElement element = getElement(locatorKey);
			//WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}



	}

	public boolean clickButtonByJS(String locatorKey) {
		try {
			WebElement element = getElement(locatorKey);
			//WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.elementToBeClickable(element));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		

	}

	public boolean clickByAction(String locatorKey) {
		WebElement element = getElement(locatorKey);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		return true;
		/*
		 * return extentLog( true, "Button Click", locatorKey);
		 */
	}

	public boolean mouseHover(String locatorKey) {
		WebElement element = getElement(locatorKey);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		return true;
		/*
		 * return extentLog( true, "Mouse hower Successfully", locatorKey);
		 */
	}

	public void scrollIntoView(String locatorKey) {
		WebElement element = getElement(locatorKey);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("arguments[0].scrollIntoView()", element);
	}

	public boolean isCheck(String locatorKey) {
		WebElement element = getElement(locatorKey);
		if (element.isSelected()) {
			test.log(Status.INFO, "Button is already check " + locatorKey);
			return true;
		} else {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
			test.log(Status.INFO, "Button is check now " + locatorKey);
			return false;
		}
	}

	public boolean isUncheck(String locatorKey) {
		WebElement element = getElement(locatorKey);
		if (element.isSelected()) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
			test.log(Status.INFO, "Button is uncheck " + locatorKey);
			return true;
		} else {

			test.log(Status.INFO, "Button is already check " + locatorKey);
			return false;
		}
	}

	public boolean validateColor(String locatorKey, String ExpectedColor) {
		WebElement element = getElement(locatorKey);
		String actualColor = element.getCssValue("border-color");
		if (actualColor.contains(actualColor)) {
			test.log(Status.PASS, "SUCCESS-boder color match" + locatorKey);
			return true;
		} else {
			test.log(Status.FAIL, "FAIL-boder color not match" + locatorKey);
			return false;
		}
	}

	public boolean sendInput(String locatorKey, CharSequence... value) {

		WebElement element = getElement(locatorKey);
		element.sendKeys(value);
		return true;
		/*
		 * return extentLog( element.isDisplayed() && element.isEnabled(), "Input Sent",
		 * locatorKey + " - " + value);
		 */
	}

	public boolean sendInput(String locatorKey, String value) {
		waitVisibility(locatorKey);
		WebElement element = getElement(locatorKey);
		element.sendKeys(value);
		return true;
		/*
		 * return extentLog( element.isDisplayed() && element.isEnabled(), "Input Sent",
		 * locatorKey + " - " + value);
		 */
	}

	public boolean sendInputByJS(String locatorKey, CharSequence... value) {
		WebElement element = getElement(locatorKey);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=" + value + "", element);
		return true;
	}

	public boolean sendActionInput(String locatorKey, CharSequence... value)

	{
		WebElement element = getElement(locatorKey);
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click();
		actions.sendKeys(value);
		actions.build().perform();
		return true;
		/*
		 * return extentLog( element.isDisplayed() && element.isEnabled(), "Input Sent",
		 * locatorKey + " - " + value);
		 */
	}

	public boolean isPresent(String locatorKey) {
		WebElement element = getElement(locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isDisplayed() && element.isEnabled();
		/*
		 * return extentLog( element.isDisplayed() && element.isEnabled(),
		 * "check display and enable", locatorKey);
		 */
	}

	public boolean isEnable(String locatorKey) {
		WebElement element = getElement(locatorKey);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.isEnabled();
	}

	public boolean isTextToBePresent(String locatorKey, String projectName) {
		try {
			WebElement element = getElement(locatorKey);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(element, projectName));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public boolean isDisplay(String locatorKey) {
		try {
			WebElement element = getElement(locatorKey);
			WebDriverWait wait = new WebDriverWait(driver, 05);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				return true;
			}

		} catch (Exception e) {
			return false;
		}
		return false;

		/*
		 * return extentLog( element.isDisplayed(), "check display", locatorKey);
		 */
	}

	public boolean isSelected(String locatorKey) {
		WebElement element = getElement(locatorKey);
		return element.isSelected();
		/*
		 * return extentLog( element.isSelected(), "check selected", locatorKey);
		 */

	}

	public boolean isAvailable(String locatorKey) {

		WebElement element = getElement(locatorKey);
		try {
			if (element.isEnabled()) {
				System.out.println(locatorKey + " isEnabled");
				return true;
			} else {
				System.out.println(locatorKey + " is Not Available");
				return false;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element is not availble");
			return false;
		}

	}

	public boolean retryingFindClick(String locatorKey) {
		WebElement element = getElement(locatorKey);
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 05);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public boolean retryingFindElement(String locatorKey) {
		WebElement element = getElement(locatorKey);
		boolean result = false;
		int attempts = 0;
		while (attempts < 2) {
			try {

				WebDriverWait wait = new WebDriverWait(driver, 05);
				wait.until(ExpectedConditions.visibilityOf(element));
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
			}
			attempts++;
		}
		return result;
	}

	public boolean clickTab(String locatorKey) {

		try {
			WebElement element = getElement(locatorKey);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);
			return true;
		} catch (StaleElementReferenceException e) {
			WebElement newElement = getElement(locatorKey);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", newElement);
			return true;
		}


	}

	public boolean validateImage(String locatorKey) {

		WebElement element = getElement(locatorKey);

		Boolean validImage = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				element);

		return extentLog(validImage, "Image check", locatorKey);
	}

	public boolean validateText(String locatorKey, String expected) {

		WebElement element = getElement(locatorKey);
		String actual = element.getText().trim();
		System.out.println(actual);
		expected.trim();
		return extentLog(expected.equals(actual), "Validate Text", locatorKey + " - " + expected);
	}

	public ExtentTest getLogger() {
		return test;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public boolean waitVisibility(String locatorKey) {
		try {
			if (locatorKey == null) {
				RamboUtil.pause(2000);
			}
			WebElement element = getElement(locatorKey);
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(ExpectedConditions.visibilityOf(element));
			// test.log(Status.PASS, "SUCCESS - wait " + locatorKey);
			return true;
		} catch (TimeoutException e) {
			// test.log(Status.FAIL, "FAILURE - wait " + locatorKey);
			throw new RuntimeException("Stopping further execution");

		} catch (InvalidSelectorException e1) {
			// test.log(Status.ERROR, "ERROR - Unable to locate an element with the xpath
			// expression " + locatorKey);
			throw new RuntimeException("Stopping further execution");

		}

	}

	
	public void fluwait(String locatorKey)
	{
		WebElement element = getElement(locatorKey);
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50))

				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class,StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));



	}


	public void clearAndWait(String locatorKey) {
		WebElement element = getElement(locatorKey);
		element.clear();
		RamboUtil.pause(500);
	}

	public void switchToFrame(String locatorKey) {
		try {

			WebElement element = getElement(locatorKey);
			driver.switchTo().frame(element);
			test.log(Status.PASS, "SUCCESS - switch to frame" + locatorKey);

		} catch (TimeoutException e) {
			test.log(Status.ERROR, "ERROR - Unable to switch required frame");
			throw new RuntimeException("Stopping further execution");
		}

	}

	public void switchToDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
			test.log(Status.PASS, "SUCCESS - switch to default frame ");

		} catch (Exception e) {
			test.log(Status.ERROR, "ERROR - unable to switch default frame ");
			throw new RuntimeException("Stopping further execution");
		}

	}

	public String getAttributeValue(String locatorKey) {
		WebElement element = getElement(locatorKey);
		String value = element.getAttribute("value");
		return value;
	}

	public String getAttribute(String locatorKey, String value) {
		WebElement element = getElement(locatorKey);
		String getValue = element.getAttribute(value);
		System.out.println(getValue);
		return getValue;
	}

	public void waitPresence(String locatorKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorKey)));
			// test.log(Status.PASS, "SUCCESS - wait " + locatorKey);
		} catch (TimeoutException e) {
			// test.log(Status.FAIL, "FAILURE - wait " + locatorKey);
			throw new RuntimeException("Stopping further execution");
		} catch (InvalidSelectorException e1) {
			// test.log(Status.ERROR, "ERROR - Unable to locate an element with the xpath
			// expression " + locatorKey);
			throw new RuntimeException("Stopping further execution");
		}
	}

	public void waitClickable(String locatorKey) {
		try {
			WebElement element = getElement(locatorKey);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			// test.log(Status.PASS, "SUCCESS - wait " + locatorKey);

		} catch (TimeoutException e) {
			// test.log(Status.FAIL, "FAILURE - wait " + locatorKey);
			throw new RuntimeException("Stopping further execution");

		} catch (InvalidSelectorException e1) {
			// test.log(Status.ERROR, "ERROR - Unable to locate an element with the xpath
			// expression " + locatorKey);
			throw new RuntimeException("Stopping further execution");
		}

	}

	public void waitInvisibility(String locatorKey) {
		try {
			WebElement element = getElement(locatorKey);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.invisibilityOf(element));
			// test.log(Status.PASS, "SUCCESS - wait " + locatorKey);

		} catch (TimeoutException e) {
			// test.log(Status.FAIL, "FAILURE - wait " + locatorKey);
			throw new RuntimeException("Stopping further execution");

		} catch (InvalidSelectorException e1) {
			// test.log(Status.ERROR, "ERROR - Unable to locate an element with the xpath
			// expression " + locatorKey);
			throw new RuntimeException("Stopping further execution");
		}
	}

	public void scrollDown(int value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + value + ")");
	}

	public String getElementText(String locatorKey) {

		return getElement(locatorKey).getText();
	}

	private WebElement getElement(String locatorKey) {

		String locator = LocatorProperties.getProperty(locatorKey);
		By by = null;
		if (locator.startsWith("return ")) {
			// assume it is a Javascript
			String id = (String) ((JavascriptExecutor) driver).executeScript(locator);
			if (locatorKey.contains(".field.")) {
				id += "-inputEl";
			} else if (locatorKey.contains(".button.")) {
				id += "-btnInnerEl";
			} else if (locatorKey.contains(".radioButton.")) {
				id += "-boxLabelEl";
			}
			by = By.id(id);
		} else {
			// xpath expression
			by = By.xpath(locator);
		}
		return driver.findElement(by);
	}

	public List<WebElement> getList(String locatorKey) {
		List<WebElement> getList = getElements(locatorKey);
		return getList;
	}

	private List<WebElement> getElements(String locatorKey) {
		String locator = LocatorProperties.getProperty(locatorKey);

		By by = By.xpath(locator);
		return driver.findElements(by);
	}

	private boolean extentLog(boolean success, String type, String locatorKey) {

		if (success) {
			test.log(Status.PASS, "SUCCESS - " + type + " - " + locatorKey);
			return true;
		} else {
			test.log(Status.FAIL, "FAILURE - " + type + " - " + locatorKey);
			return false;
		}
	}

	public void capturedScreen(String screenShotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\ErrorScreenshots\\" + screenShotName + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
	}

	public void uploadFileFromSystem() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			test.log(Status.PASS, "Upload file successfully");
		} catch (AWTException e) {
			test.log(Status.FAIL, "File not uploded");
		}

	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void pageLoadTime(int sec) {
		driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
	}

	public void pressEnter() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {

		}

	}

	public void openTab() {
		try {

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_T);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_T);
		} catch (Exception e) {

		}
	}

	public void closeTab() {
		try {

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_W);
		} catch (Exception e) {

		}
	}

	public void pasteValue() {
		try {

			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		} catch (Exception e) {

		}
	}
}
