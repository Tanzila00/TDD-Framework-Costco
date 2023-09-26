package pages;

import static common.CommonActions.*;
import utils.ReadFile;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Attribute;
import constants.IFile;

import reports.Loggers;

public class HomePage {// this help to instantiate web element (by which we created xpath). web element
	// is Interface
	// public WebDriver driver;
	public HomePage(WebDriver driver) {
		// this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search-field']")
	WebElement search;
	@FindBy(css = "button.btn.search-ico-button")
	WebElement searchButton;
	// driver.findElement(By.cssSelector("button.btn.search-ico-button"));
	// @FindBy(xpath="//button[@name='add-to-cart' and @id='addbutton-0']")
	// WebElement addToCartButton;
	@FindBy(id = "cart-d")
	WebElement cartButton;
	// WebElement sortBy=driver.findElement(By.xpath("//select[@id='sort_by']"));
	@FindBy(xpath = "//select[@id='sort_by']")
	WebElement sortBy;
	@FindBy(xpath = "//a[normalize-space(text())='When Beauty Tetra-Biome Cream Serum, 1 fl oz']")
	WebElement creamSerumLink;
	// @FindBy(css="input.primary-button-v2.valid")
	@FindBy(id = "add-to-cart-btn")
	WebElement creamSerumAddButton;
	@FindBy(xpath = "//a[@id='Home_Ancillary_4']")
	WebElement costcoOpticals;
	@FindBy(className = "copyright") // PROBLEM
	WebElement costcoFooter;// at the bottom
	@FindBy(xpath = "//ul[contains(@class,'list-group') and contains(@class, 'top-links') and contains(@class,'t6-header-font')]/li")
	List<WebElement> headLineMenu;
	@FindBy(xpath = "//a[@id='Home_Ancillary_6']")
	WebElement services;
	@FindBy(xpath = "//div[contains(@class,'ol-xs-12') and contains(@class,'col-md')]/ol")
	List<WebElement> servicesList;
	//div[@id='Home_Ancillary_Popover_6-container']//ol/li[1] for headers
	@FindBy(xpath="//a[text()='Parts & Service Discount']")
	WebElement partsNserviceBtn;

	// div[contains(@class,'col-xs-16') and contains(@class,'col-md-6') and
	// contains(@class,'col')]

	//-------------------- AUTOQUOTETEST FOR AAA---------------------------------------------
	@FindBy(xpath = "//div[text()='Welcome to AAA Northeast']")
	WebElement titleText;
	@FindBy(css = "div.dkg6.italicText.regularText")
	WebElement subTitle;
	@FindBy(xpath = "//input[@id='zipcodeInput']")
	WebElement zipCode;
	@FindBy(id = "zipcodeSubmit")
	WebElement submitZipCodeButton;
	@FindBy(className = "zipcodeBottomText")
	WebElement footerText;
	@FindBy(xpath = "//div[@class='zipcodeMid']/descendant::div[contains(@class,'r6')]")
	WebElement errorMsgText;

	//------------------------- GEICO----------------------------------
	@FindBy(xpath = "//input[@id='ssp-service-zip' and @class='zip-code-input']")
	WebElement geicoZipCode;
	// id="ssp-service-zip"
	@FindBy(id = "section1heading")
	WebElement headLine;

	public void inputSearchField(String searchField) {
		input(search, searchField);// imported static Common Actions to get the static method access
	}

	public void clearCostcoTest() {
		clear(search);
	}

	public void clickSearchButton() {
		click(searchButton);// imported static Common Actions to get the static method access
	}

	public void CartButton() {
		click(cartButton);
	}

	public void SortByButton() {
		click(sortBy);
		// selectDropDownByVisibleText(element, String visibleText);
		selectDropDownByVisibleText(sortBy, "Newest");
	}

	public void creamSerumLink() {
		click(creamSerumLink);
	}

	public void creamSerumAddButton() {
		click(creamSerumAddButton);
	}

	public void opticalsHoverOver(WebDriver driver) {
		hoverOver(driver, costcoOpticals);
	}
	public void servivcesHoverOver(WebDriver driver) throws InterruptedException {
		
		hoverOver(driver, services);
	}

	public void partsNservicesButtonTest(WebDriver driver) {
		hoverOver(driver, services);
		click(partsNserviceBtn);
	}
	public void servicesHoverOverToTest(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		hoverOverTo(driver, services,partsNserviceBtn);
	}

	public void titleTest(WebDriver driver, String expected) {
		verifyTitle(driver, expected);
	}

	public void verifyCostcoFooterText(String expected) {
		verifyTextField(costcoFooter, expected);
		// verifyAttribute(costcoFooter, expected, Attribute.INNER_HTML);
	}

	public void printMenuList() {// using WebELement!
		for (WebElement e : headLineMenu) {
			String menuList = e.getText();
			Loggers.log("Menu List:" + menuList);

		}
		Loggers.log("Test Completed");
	}

	public void iterateMenuList() {// using locator and iteration
		ReadFile file = new ReadFile(IFile.MENU);
		List<String> list = file.getList();
		for (String newlist : list) {// This is how we iterated. each list iterated
			Loggers.log("Menu:" + newlist);

		}

	}

	public void validateMenuList() {
		ReadFile file = new ReadFile(IFile.MENU);
		List<String> expectedList = file.getList();
		for (String newlist : expectedList) {// This is how we iterated. each list iterated
			Loggers.log("Expected:" + newlist);
		}

//		
//		ReadFile file = new ReadFile(IFile.MENU);
//		List<String> expectedlist = file.getList();//reading from menu.txt
//		Loggers.log("Menu:"+expectedlist);
		List<String> actualList = new ArrayList<>();// new array to store input form webelement
		for (WebElement f : headLineMenu) {
			String menu = f.getText();
			// remove the extra text reeceived from actual text using contains();
			if (menu.contains("US") && menu.contains("United States(expand to select country/region)")) {
				menu = "US";//edited using if loop
			}
			actualList.add(menu);
		}
		verifyText(expectedList, actualList);
	}

	public void serivcesList(WebDriver driver) {// hoverOver services and iterate the subList
		hoverOver(driver, services);
		for (WebElement f : servicesList) {
			Loggers.log("Service List:" + f.getText());
		}
		// ReadFile readFile=new ReadFile("");
	}

	// -------------------HERE STARTS NEW URL AAA--------------------------------------------------

	public void verifyTitleText(String expectedValue) {
		verifyTextField(titleText, expectedValue);
	}

	public void verifySubTitleText(String expected) {
		verifyAttribute(subTitle, expected, Attribute.INNER_HTML);
		//verifyTextField(subTitle, expected);
	}

	public void zipCodeTest() {
		click(zipCode);
	}

	public void submitZipCodeButtonTest() {
		click(submitZipCodeButton);
	}

	public void footerTextTest(String expected) {
		 //verifyAttribute(footerText, expected, Attribute.INNER_HTML);//inner html
		// gives logo we don;t want that hence don;t use inner logo
		verifyTextField(footerText, expected);
	}

	public void errorMsgTextTest(String expected) {
		verifyAttribute(errorMsgText, expected, Attribute.INNER_HTML);
	}

	public void inputZipCodeField(String inputValue) {
		input(zipCode, inputValue);// imported static Common Actions to get the static method access
	}

	public void clearTest() {
		clear(zipCode);
	}

	public void verifyLength(String expected) {// GEICO
		verifyAttribute(geicoZipCode, expected, Attribute.MAX_LENGTH);
	}

	public void verifyHeadLineText(String expected) {// GEICO
		verifyAttribute(headLine, expected, Attribute.INNER_HTML);
		// verifyTextField(headLine, expected);
	}
}