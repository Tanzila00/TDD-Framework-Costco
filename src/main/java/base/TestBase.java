package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import common.CommonActions;
import constants.KeyConfig;
import static constants.IBrowserConstant.*;
import java.lang.reflect.Method;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.ReadConfig;
import utils.ReadFile;

public class TestBase {
	public static WebDriver driver;// declared 01
	ReadConfig config;// declared 02
	protected HomePage homePage;
	protected Select select;
	protected JavascriptExecutor jsExecutor;
	protected ReadFile readFile;
	protected ExtentReports extentReports;
	protected ExtentTest extentTest;

	@BeforeSuite
	public void initialReporting() {
		extentReports = ExtentManager.initialReports();
	}

	@BeforeClass // I want this method to run first
	public void beforeClassSetUp() {
		config = new ReadConfig();// initializing 01

	}

//BROWSER is constant because we imported the static IBrowserContant interface values here.So now we can use those keyword
	@Parameters(BROWSER)
	@BeforeMethod
	public void setUpDriver(@Optional(EDGE) String browserName) {// if param(BROSWER) not work optional will work as
																	// default
		driver = initiliazingBrowser(browserName);// initializing 02
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		int pageloadwait = Integer.parseInt(config.getValue(KeyConfig.pageloadwait));// conversion because it was in
																						// string @config.properties
		int implicitlywait = Integer.parseInt(config.getValue(KeyConfig.implicitlywait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadwait));// calling by the name use for int
																						// conversion!!
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlywait));
		driver.get(config.getValue(KeyConfig.url));
		initObjectClass();// to use the homePage we need to call the method created
	}

	public WebDriver initiliazingBrowser(String browserName) {
		switch (browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();// version not defined so latest
			return new ChromeDriver();
		// break; as we are returning the value we don't have to use the break!!
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();// version not defined so latest
			return new FirefoxDriver();
		case EDGE:
			WebDriverManager.edgedriver().setup();// version not defined so latest
			return new EdgeDriver();
		case SAFARI:
			WebDriverManager.safaridriver().setup();// version not defined so latest
			return new SafariDriver();
		default:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}

	}

	public void initObjectClass() {
		homePage = new HomePage(driver);
	}

	@BeforeMethod
	public void initialTest(Method method) {
		extentTest = ExtentTestManager.createTest(extentReports, method.getName());
		extentTest.assignCategory(method.getDeclaringClass().getName());
	}

	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for (String group : result.getMethod().getGroups()) {
			extentTest.assignCategory(group);
		}

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test PASSED");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.addScreenCaptureFromPath(CommonActions.getScreenShot(method.getName(),
			 driver));
			extentTest.log(Status.FAIL, "Test FAILED");
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "Test SKIPPED");
		}
		tearUp();
	}

	public void tearUp() {
		driver.quit();
	}
	
	@AfterSuite
	public void publishReport() {
		extentReports.flush();
	}

}
