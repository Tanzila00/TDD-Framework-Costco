package common;

import org.openqa.selenium.TakesScreenshot;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import java.util.NoSuchElementException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import constants.Attribute;
import reports.Loggers;

public class CommonActions {
	public static void input(WebElement element, String inputValue) {
		try {
			element.sendKeys(inputValue);
			Loggers.log(element + "-----> Input value:" + inputValue);
		} catch (NoSuchElementException e) {
			Loggers.log(element + "-----> Not Found\n" + e.getMessage());
		}
	}

	public static void click(WebElement element) {
		try {
			element.click();
			Loggers.log(element + "-----> Clicked");
		} catch (NoSuchElementException e) {
			Loggers.log(element + "-----> Not Found\n" + e.getMessage());
		}

	}

	public static void verifyTextField(WebElement element, String expectedValue) {
		String actual = element.getText();
		Loggers.log(element + " ---> Actual text : " + actual + ". Expected text : " + expectedValue);
		Assert.assertEquals(actual, expectedValue);
	}

	public static void verifyText(Object obj1, Object obj2) {
		Loggers.log(obj1 + " ---> Comparing with : ---> " + obj2);
		Assert.assertEquals(obj1, obj2);
	}

	public static void verifyAttribute(WebElement element, String expected, Attribute attribute) {

		String actual = element.getAttribute(attribute.toString());
		// getAttributeValue(element,attribute);
		// Loggers.log(element + " ---> Actual text : " + actual + ". Expected text : "
		// + expected);
		Assert.assertEquals(actual, expected);
	}

	public static void verifyTitle(WebDriver driver, String expected) {
		try {

			String actual = driver.getTitle();
			Loggers.log("Actual Title is : " + driver.getTitle() + "---> And Expected Title is :" + expected);
			Assert.assertEquals(actual, expected);

		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.log("not valid");
		}

	}

	public static void clear(WebElement element) {
		try {
			element.clear();
			Loggers.log(element + "-------------Cleared");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " No Element Found" + e.getMessage());
		}

	}

	public static void selectDropDownByVisibleText(WebElement element, String visibleText) {

		try {
			Select select = new Select(element);
			Thread.sleep(5000);
			select.selectByVisibleText(visibleText);
			Loggers.log(element + "-----> visibleText"); //

		} catch (NoSuchElementException | InterruptedException e) {
			e.printStackTrace();
			Loggers.log(element + "-----> Not Found\n" + e.getMessage());

		}

	}

	public static void hoverOver(WebDriver driver, WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Loggers.log("Hovering on ---> " + element);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());

		}
	}

	public static void hoverOverTo(WebDriver driver, WebElement src_element, WebElement target_element) {
		try {// move from one to another
			Actions actions = new Actions(driver);
			actions.moveToElement(src_element).click(target_element).build().perform();
			Loggers.log("Hovering on ---> " + src_element);
			Loggers.log("Clicking on ---> " + target_element);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(src_element + " || " + target_element + " ---> Not Found \n" + e.getMessage());
			Assert.fail();

		}
	}

	public static void scrollDown(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
	}

	public static void scrollUp(WebDriver driver) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
	}

	public static void scroll_Js(WebElement element, WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static String getScreenShot(String testName, WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot) driver;// cast the driver -designed in this way!!
		String path = System.getProperty("user.dir") + "/test-output/screenShots";// here user-dir will take you to
																					// project+ "the location where
																					// folder created"
		File folder = new File(path);// created a folder nams ss-
		if (!folder.exists()) {// if folder doesn't exist
			folder.mkdirs();// in built mkdirs it will create the folder even i dont create the ss folder!!
		}

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MM_dd_yyyy hh.mm.ss");
		String dateString = format.format(date);

		File targetFile = new File(path + "/error_" + testName + "_" + dateString + ".png");// where i want to save
																							// my ss!
		try {
			File srcFile = ss.getScreenshotAs(OutputType.FILE);// OutputType.-in built ot get output in the form of
																// FILE!!
			Files.copy(srcFile, targetFile);// to
			Loggers.log("Screenshot has been successfully capture at: \n" + targetFile.getAbsolutePath());
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
			Loggers.log("Screenshot cannot capture" + e.getMessage());
		}
		return targetFile.getAbsolutePath();// return target file
	}
}
