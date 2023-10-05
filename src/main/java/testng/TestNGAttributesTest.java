package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import reports.Loggers;

/*working with the param inside the Test annotations
 * First step:in xml no need to use parameter and value it will only need the <test >
 * dependsOnMethods this shows the dependency ex:if test3 is false then the run will fail as it is dependent on test3
 * ignoreMissingDependencies- this helps to fix the problem and continue the run
 * @Test(enabled=true, dependsOnMethods ="test3",ignoreMissingDependencies = true)
 * 
 */
/*
 * Using groups-  this help to define what group of test to run.
 * only runs which ever group is called in the testng.xml
 * Now another dependsOngroup- regression it will not run if the original group for that specific test is "smoke"!!
 */
public class TestNGAttributesTest {
	@Test(enabled = true, groups = { "regression", "smoke",
			"auto" }, dependsOnMethods = "test3", ignoreMissingDependencies = true)
	public void test1() {
		Loggers.log("This is for test1");
	}

	@Test(enabled = true, groups = { "smoke", "regression" }, dependsOnMethods = "test4", alwaysRun = true)
	public void test2() {
		Loggers.log("This is for test2");
	}

	@Test(enabled = false, groups = "regression", alwaysRun = true) // will not run even alwaysrun attri
	public void test3() {
		Loggers.log("This is for test3");
	}

	@Test(enabled = true, groups = "smoke") // , dependsOnGroups = "regression")//will still not run for regression as
											// originally it is smoke
	public void test4() {
		Loggers.log("This is for test4");
		Assert.fail();
	}
}
//retryAnalyzer=retry.RetryClass.class(packagename.Class name.class) is this param is used insisde any paranthesis it means only that test will retry not the other fail tests!!