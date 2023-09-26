package quote.auto;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import constants.IGroups;

public class AutoQuoteTest extends TestBase {
	@Test(enabled = false,groups={"regression","sanity","smoke"})
	public void getAutoQuoteTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().to("https://northeast.aaa.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		homePage.verifyTitleText("Welcome to AAA Northeast");
		//Thread.sleep(5000);
		 homePage.verifySubTitleText("To ensure you receive the best service possible,<br>please enter your zip code below:");
		 //Thread.sleep(5000);
		homePage.zipCodeTest();
		 //Thread.sleep(5000);
		homePage.submitZipCodeButtonTest();
	    //Thread.sleep(500);
		homePage.errorMsgTextTest("Please enter a valid ZIP code so we can direct you to the<br>AAA website in your area.");
		homePage.footerTextTest("AAA Northeast serves members in CT, MA, NH, NJ, NY & RI.");
		 //Thread.sleep(500);
		homePage.inputZipCodeField("113ab");// alphanumeric
		//Thread.sleep(5000);
		homePage.submitZipCodeButtonTest();
		homePage.clearTest();
		homePage.inputZipCodeField("11355");
		//Thread.sleep(5000);
		homePage.submitZipCodeButtonTest();
		//Thread.sleep(5000);

	}
	@Test(enabled=true,groups= {"regression"})
	public void test2() throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().to("https://northeast.aaa.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);	
		homePage.zipCodeTest();		
		homePage.inputZipCodeField("113ab");// alphanumeric
		Assert.fail();
		homePage.submitZipCodeButtonTest();

	}
}
