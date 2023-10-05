package costco.self.care;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;
import constants.Attribute;

public class SelfCareCheckoutTest extends TestBase {
	@Test(enabled = false)
	public void checkoutTest() {
homePage.titleText(driver, "Welcome to Costco Wholesale");
		homePage.scrollDownTest(driver);
		homePage.verifyCostcoFooterText("© 1998 — 2023 Costco Wholesale Corporation. All rights reserved.");
		homePage.scrollUpTest(driver);
	homePage.inputSearchField("face cream");
		homePage.clickSearchButton();
		homePage.SortByButton();
		homePage.creamSerumLink();
		homePage.creamSerumAddButton();
		homePage.CartButton();

	}

	@Test(enabled = false)
	public void hover_over_test() throws InterruptedException {
		// homePage.opticalsHoverOver(driver);
		// homePage.servivcesHoverOver(driver);
		// homePage.partsNservicesButtonTest(driver);
		homePage.servicesHoverOverToTest(driver);

		Thread.sleep(5000);
	}

	@Test(enabled = false)
	public void scroll_down_test() {

		/*
		 * WebElement addToCart=driver.findElement(By.
		 * xpath("//input[@id='add-to-cart-btn' and @name='add-to-cart']"));
		 * jsExecutor=(JavascriptExecutor)driver;
		 * jsExecutor.executeScript("arguments[0].click()", addToCart);
		 */
	}

	@Test(enabled = true) // ARRAYLIST
	public void costcoListTest() throws InterruptedException {
//List <WebElement> headLineMenu=driver.findElement(By.cssSelector("//ul.list-group.top-links.t6-header-font.hidden-xs.hidden-sm"));
		//homePage.printMenuList();
		// homePage.validateMenuList();
		// homePage.iterateMenuList();
		 homePage.serivcesList(driver);
		// Thread.sleep(5000);;
	}

	// GEICO
	@Test(enabled = false)
	public void geico_attribute_test() throws InterruptedException {
		Thread.sleep(5000);
		driver.navigate().to("https://www.geico.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
//String value=driver.findElement(By.xpath("//input[@id='ssp-service-zip' and @class='zip-code-input']")).getAttribute("maxlength");
//System.out.println("Max length value:"+value);	  
		homePage.verifyLength("5");
		// homePage.verifyHeadLineText("The Insurance Savings You Expect");
	}

}
