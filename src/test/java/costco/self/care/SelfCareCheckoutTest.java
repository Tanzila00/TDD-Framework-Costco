package costco.self.care;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.TestBase;

public class SelfCareCheckoutTest extends TestBase {
	@Test(enabled = false)
	public void checkoutTest() throws InterruptedException {

		homePage.inputSearchField("face cream");
		Thread.sleep(50);
		// homePage.clearCostcoTest();
		// Thread.sleep(500);
		homePage.clickSearchButton();
		homePage.SortByButton();
		homePage.creamSerumLink();
		Thread.sleep(500);
		/*
		 * WebElement addToCart=driver.findElement(By.
		 * xpath("//input[@id='add-to-cart-btn' and @name='add-to-cart']"));
		 * jsExecutor=(JavascriptExecutor)driver;
		 * jsExecutor.executeScript("arguments[0].click()", addToCart);
		 */
		homePage.creamSerumAddButton();
		Thread.sleep(500);
		homePage.CartButton();
		Thread.sleep(500);

	}

	@Test(enabled = false)
	public void test() throws InterruptedException {
		// homePage.opticalsHoverOver(driver);
		//homePage.titleTest(driver, "Welcome to Costco Wholesale");
		//homePage.servivcesHoverOver(driver);
		//homePage.partsNservicesButtonTest(driver);
		homePage.servicesHoverOverToTest(driver);
	
		Thread.sleep(5000);
	}

	@Test(enabled = false)
	public void html_test() {
		
		homePage.verifyCostcoFooterText("© 1998 — 2023 Costco Wholesale Corporation. All rights reserved.");
	}
	@Test(enabled = false)//ARRAYLIST
	public void costcoListTest() throws InterruptedException {
//List <WebElement> headLineMenu=driver.findElement(By.cssSelector("//ul.list-group.top-links.t6-header-font.hidden-xs.hidden-sm"));
		homePage.printMenuList();
		//homePage.validateMenuList();
		//homePage.iterateMenuList();
		//homePage.serivcesList(driver);
		//Thread.sleep(5000);;
	}

	
	
	//GEICO
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
		homePage.verifyHeadLineText("The Insurance Savings You Expect");
	}


}
