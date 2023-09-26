package quote.auto;

import java.time.Duration;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.IParameters.*;
import base.TestBase;
import static constants.IParameters.*;

public class AutoQuoteParameterized extends TestBase{
	@Test()
	@Parameters({TITLE, ZIP1, ZIP2 })//interface Iparameters.must do {} for multiple param
public void AutoQuoteParameterized(String title,String zip1,String zip2g) throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().to("https://northeast.aaa.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		homePage.verifyTitleText("Welcome to AAA Northeast");
		//Thread.sleep(5000);
		// homePage.verifySubTitleText("To ensure you receive the best service possible,<br>please enter your zip code below:");
		homePage.zipCodeTest();
		homePage.submitZipCodeButtonTest();
		//homePage.errorMsgTextTest("Please enter a valid ZIP code so we can direct you to the<br>AAA website in your area.");
		//homePage.footerTextTest("AAA Northeast serves members in CT, MA, NH, NJ, NY & RI.");
		homePage.inputZipCodeField("113ab");// alphanumeric
		homePage.submitZipCodeButtonTest();
		homePage.clearTest();
		homePage.inputZipCodeField("11355");
		homePage.submitZipCodeButtonTest();
		

}
}
