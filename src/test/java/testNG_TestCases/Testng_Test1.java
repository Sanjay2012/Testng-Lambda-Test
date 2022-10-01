package testNG_TestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.lambdatest.basetest.BaseTest;

public class Testng_Test1 extends BaseTest{
	@Test
	public void pageTitleValidation() {
		Reporter.log("<--------Scenario 1: Page title validation Started-------->", true);
		
		String pageTitle=driver.getTitle();
		Reporter.log("Asserting wrong page Title", true);
		soft.assertNotEquals(pageTitle, "LambdaTest");
		soft.assertAll();
	}
	
}
